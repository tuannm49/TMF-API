package oda.api.tmf.commons.repository;

import oda.api.tmf.commons.exceptions.BadUsageException;
import oda.api.tmf.commons.exceptions.ExceptionType;
import oda.api.tmf.commons.exceptions.UnknownResourceException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/**
 * MongoDB implementation of GenericRepository using MongoTemplate.
 *
 * @param <T> the type of the entity
 */
public class MongoRepository<T> implements GenericRepository<T> {

    private final MongoTemplate mongoTemplate;
    private final Class<T> entityClass;

    /**
     * Constructor for MongoRepository.
     *
     * @param mongoTemplate the MongoTemplate instance
     * @param entityClass   the class of the entity
     */
    public MongoRepository(MongoTemplate mongoTemplate, Class<T> entityClass) {
        this.mongoTemplate = mongoTemplate;
        this.entityClass = entityClass;
    }

    @Override
    public int create(List<T> entities) throws BadUsageException {
        if (entities == null || entities.isEmpty()) {
            return 0;
        }
        mongoTemplate.insertAll(entities);
        return entities.size();
    }

    @Override
    public T create(T entity) throws BadUsageException {
        if (entity == null) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Entity cannot be null");
        }
        return mongoTemplate.insert(entity);
    }

    @Override
    public T edit(T entity) throws UnknownResourceException {
        if (entity == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }
        T saved = mongoTemplate.save(entity);
        if (saved == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }
        return saved;
    }

    @Override
    public void remove(Object id) throws UnknownResourceException {
        Query query = new Query(Criteria.where("_id").is(id));
        T entity = mongoTemplate.findAndRemove(query, entityClass);
        if (entity == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }
    }

    @Override
    public void removeAll() {
        mongoTemplate.remove(new Query(), entityClass);
    }

    @Override
    public T find(Object id) throws UnknownResourceException {
        T entity = mongoTemplate.findById(id, entityClass);
        if (entity == null) {
            throw new UnknownResourceException(ExceptionType.UNKNOWN_RESOURCE);
        }
        return entity;
    }

    @Override
    public void detach(T entity) {
        // No-op: MongoDB does not use a persistence context
    }

    @Override
    public void clearCache() {
        // No-op: MongoDB does not use a persistence context cache
    }

    @Override
    public List<T> findAll() {
        return mongoTemplate.findAll(entityClass);
    }

    @Override
    public List<T> findRange(int[] range) {
        Query query = new Query();
        query.skip(range[0]);
        query.limit(range[1] - range[0]);
        return mongoTemplate.find(query, entityClass);
    }

    @Override
    public int count() {
        return (int) mongoTemplate.count(new Query(), entityClass);
    }

    @Override
    public List<T> findByCriteria(Map<String, List<String>> map, Class<T> clazz) {
        try {
            Query query = new Query();
            List<Criteria> andCriteria = new ArrayList<>();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<String> values = entry.getValue();
                Criteria criteria;
                if (values.size() > 1) {
                    // OR condition: name=value1,value2
                    List<Criteria> orCriteria = new ArrayList<>();
                    for (String value : values) {
                        orCriteria.add(buildCriteria(key, value));
                    }
                    criteria = new Criteria().orOperator(orCriteria.toArray(new Criteria[0]));
                } else {
                    // Single condition: name=value
                    criteria = buildCriteria(key, values.get(0));
                }
                andCriteria.add(criteria);
            }
            query.addCriteria(new Criteria().andOperator(andCriteria.toArray(new Criteria[0])));
            return mongoTemplate.find(query, clazz);
        } catch (BadUsageException e) {
            return null;
        }
    }

    private Criteria buildCriteria(String name, String value) throws BadUsageException {
        int index = name.indexOf('.');
        if (index > 0 && index < name.length()) {
            // Nested field: rootFieldName.subFieldName=value
            String rootFieldName = name.substring(0, index);
            String subFieldName = name.substring(index + 1);
            return buildCriteria(rootFieldName + "." + subFieldName, value);
        } else if (isMultipleAndValue(value)) {
            // AND condition: name=(subname1=value1&subname2=value2)
            List<Map.Entry<String, String>> subFieldNameValue = convertMultipleAndValue(value);
            List<Criteria> andCriteria = new ArrayList<>();
            for (Map.Entry<String, String> entry : subFieldNameValue) {
                String subFieldName = entry.getKey();
                String subValue = entry.getValue();
                andCriteria.add(buildCriteria(name + "." + subFieldName, subValue));
            }
            return new Criteria().andOperator(andCriteria.toArray(new Criteria[0]));
        } else if (isMultipleOrValue(value)) {
            // OR condition: name=value1,value2
            List<String> valueList = convertMultipleOrValueToList(value);
            List<Criteria> orCriteria = new ArrayList<>();
            for (String currentValue : valueList) {
                orCriteria.add(buildCriteriaWithOperator(name, currentValue));
            }
            return new Criteria().orOperator(orCriteria.toArray(new Criteria[0]));
        } else {
            // Simple condition: name=value
            return buildCriteriaWithOperator(name, value);
        }
    }

    private Criteria buildCriteriaWithOperator(String name, String value) throws BadUsageException {
        Operator operator = Operator.fromString(name);
        String fieldName = operator != null ? name.substring(operator.getValue().length() + 1) : name;

        Object convertedValue = convertStringValueToObject(value, Object.class);
        if (operator == null) {
            return Criteria.where(fieldName).is(convertedValue);
        }

        switch (operator) {
            case EQ:
                return Criteria.where(fieldName).is(convertedValue);
            case NE:
                return Criteria.where(fieldName).ne(convertedValue);
            case GT:
                return Criteria.where(fieldName).gt(convertedValue);
            case GTE:
                return Criteria.where(fieldName).gte(convertedValue);
            case LT:
                return Criteria.where(fieldName).lt(convertedValue);
            case LTE:
                return Criteria.where(fieldName).lte(convertedValue);
            case EX:
                String pattern = value.replace("*", ".*");
                return Criteria.where(fieldName).regex(Pattern.compile(pattern, Pattern.CASE_INSENSITIVE));
            default:
                throw new BadUsageException(ExceptionType.BAD_USAGE_OPERATOR, "Unsupported operator: " + operator);
        }
    }

    private boolean isMultipleOrValue(String value) {
        return value.contains(",");
    }

    private boolean isMultipleAndValue(String value) {
        return value.startsWith("(") && value.endsWith(")");
    }

    private List<String> convertMultipleOrValueToList(String value) {
        return Arrays.asList(value.split(","));
    }

    private List<Map.Entry<String, String>> convertMultipleAndValue(String multipleValue) {
        List<Map.Entry<String, String>> nameValueList = new ArrayList<>();
        if (multipleValue.startsWith("(") && multipleValue.endsWith(")")) {
            String[] tokenArray = multipleValue.substring(1, multipleValue.length() - 1).split("&");
            for (String nameValue : tokenArray) {
                String[] split = nameValue.split("=");
                if (split.length == 2) {
                    nameValueList.add(new AbstractMap.SimpleEntry<>(split[0], split[1]));
                }
            }
        }
        return nameValueList;
    }

    private Object convertStringValueToObject(String value, Class<?> clazz) throws BadUsageException {
        try {
            if (clazz.isEnum()) {
                return safeEnumValueOf(clazz, value);
            } else if (Date.class.isAssignableFrom(clazz)) {
                return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").parse(value);
            } else if (Number.class.isAssignableFrom(clazz) || clazz.isPrimitive()) {
                return NumberFormat.getInstance().parse(value);
            } else {
                return value;
            }
        } catch (ParseException e) {
            throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Invalid format for value: " + value);
        }
    }

    private Enum<?> safeEnumValueOf(Class<?> enumType, String name) {
        try {
            return Enum.valueOf((Class<? extends Enum>) enumType, name);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    enum Operator {
        EQ("eq"),
        GT("gt"),
        GTE("gte"),
        LT("lt"),
        LTE("lte"),
        NE("ne"),
        EX("ex");

        private final String value;

        Operator(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static Operator fromString(String value) {
            if (value != null) {
                for (Operator b : Operator.values()) {
                    if (value.equalsIgnoreCase(b.value)) {
                        return b;
                    }
                }
            }
            return null;
        }
    }
}