package oda.sid.tmf.model.base.exceptions;

public enum ExceptionType {

    BAD_USAGE_GENERIC(new ExceptionBean("4000", "Bad Usage")),
    BAD_USAGE_SEARCH_QUERY(new ExceptionBean("4001", "Search query is not valid")),
    BAD_USAGE_STATUS_TRANSITION(new ExceptionBean("4002", "The status transition is not allowed")),
    BAD_USAGE_MANDATORY_FIELDS(new ExceptionBean("4003", "Missing mandatory field")),
    BAD_USAGE_UNKNOWN_VALUE(new ExceptionBean("4004", "Unknown value")),
    BAD_USAGE_OPERATOR(new ExceptionBean("4011", "Wrong operator usage")),
    BAD_USAGE_FORMAT(new ExceptionBean("4012", "Wrong format")),
    ILLEGAL_LIFECYCLE_STATUS_INIT(new ExceptionBean("4021", "Bad initial status")),
    ILLEGAL_LIFECYCLE_STATUS_TRANSITION(new ExceptionBean("4022", "Invalid status transition")),
    ILLEGAL_LIFECYCLE_STATUS_FINAL(new ExceptionBean("4023", "Final status; No transitons allowed")),
    BAD_ENUMERATION_VALUE(new ExceptionBean("4024", "Unrecognized value")),
    UNKNOWN_RESOURCE(new ExceptionBean("4041", "Unknown resource"));

    private ExceptionBean info;

    ExceptionType(ExceptionBean info) {
        this.info = info;
    }

    @Override
    public String toString() {
        String out = String.format("%1$ - %2$ - %3$", this.getInfo().getCode(), this.name(), this.getInfo().getTitle());
        return out;
    }

    public ExceptionBean getInfo() {
        return info;
    }
}
