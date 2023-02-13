package za.co.standardbank.card.enums;

public enum CommonEnum {
    EXCEPTION("EXCEPTION"),
    LOG_RESPONSE_BODY("Response Body: {}"),
    SUCCESS("Success");

    private final String value;

    CommonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}