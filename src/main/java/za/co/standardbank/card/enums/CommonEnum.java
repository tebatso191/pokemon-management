package za.co.standardbank.card.enums;

public enum CommonEnum {
    EXCEPTION("EXCEPTION"),
    SUCCESS("Success");

    private final String value;

    CommonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}