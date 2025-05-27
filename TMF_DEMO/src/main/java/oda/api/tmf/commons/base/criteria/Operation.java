package oda.api.tmf.commons.base.criteria;

import oda.api.tmf.commons.base.ParsedVersion;
import oda.api.tmf.commons.base.exceptions.BadUsageException;
import oda.api.tmf.commons.base.exceptions.ExceptionType;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author bahman.barzideh
 *
 */
public class Operation {
    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");

    private Operator operator;
    private HashSet<OperationValue> values = new HashSet<OperationValue>();

    public Operation(Operator operator) throws IllegalArgumentException {
        if (operator == null) {
            throw new IllegalArgumentException("operator is required");
        }

        this.operator = operator;
    }

    public Operator getOperator() {
        return operator;
    }

    public Set<OperationValue> getValues() {
        return values;
    }

    public void addValue(String value) throws IllegalArgumentException {
        if (value == null) {
            throw new IllegalArgumentException("value is required");
        }

        values.add(new OperationValue(value));
    }

    public void normalizeValuesAsVersion() {
        for (OperationValue value : values) {
            ParsedVersion parsedVersion = new ParsedVersion(value.getInputValue());
            value.setObjectValue(parsedVersion.getInternalView());
        }
    }

    public void normalizeValuesAsNumber() throws BadUsageException {
        for (OperationValue value : values) {
         try {
                value.setObjectValue((Comparable) NumberFormat.getInstance().parse(value.getInputValue()));
            }
            catch (Exception ex) {
                System.err.println ("Failed to parse '" + value.getInputValue() + "' as Number");
                throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Wrong format for value " + value);
            }
        }
    }

    public void normalizeValuesAsDate() throws BadUsageException {
        for (OperationValue value : values) {
            try {
                value.setObjectValue(dateFormatter.parse(value.getInputValue()));
            }
            catch (Exception ex) {
                System.err.println ("Failed to parse '" + value.getInputValue() + "' as Date");
                throw new BadUsageException(ExceptionType.BAD_USAGE_FORMAT, "Wrong format for value " + value);
            }
        }
    }

    public void normalizeValuesAsEnumeration(Object enumeratedValues []) throws BadUsageException {
        if (enumeratedValues == null || enumeratedValues.length <= 0) {
            return;
        }

        for (OperationValue value : values) {
            String inputValue = value.getInputValue();
            if (inputValue == null) {
                value.setObjectValue(null);
                continue;
            }

            for (Object object : enumeratedValues) {
                if (object == null || (object instanceof Enum) == false) {
                    continue;
                }

                if (inputValue.equals(object.toString ()) == false) {
                    continue;
                }

                value.setObjectValue((Comparable) object);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Operation{" + "operator=" + operator + ", values=" + values + '}';
    }

}
