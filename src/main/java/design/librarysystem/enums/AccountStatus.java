package design.librarysystem.enums;

public enum AccountStatus {
    ACTIVE("active", 1),
    CLOSED("closed", 2),
    CANCELED("canceled", 3),
    BLACKLISTED("blacklisted", 4),
    NONE("none", 5);

    private final String status;
    private final Integer statusCode;

    AccountStatus(final String status, final Integer statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }
}
