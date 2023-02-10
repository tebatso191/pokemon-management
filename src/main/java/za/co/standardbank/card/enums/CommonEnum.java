package za.co.standardbank.card.enums;

public enum CommonEnum {
    EXCEPTION("EXCEPTION"),
    RESPONSE_BODY_LOG("Response Body: {}"),
    SUCCESS("Success");

    private final String value;

    CommonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}