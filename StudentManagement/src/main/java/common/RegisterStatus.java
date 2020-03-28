package common;

public enum RegisterStatus {

    REGISTERED,
    WAITTING,
    CANCEL;

    private static final RegisterStatus[] ENUMS = RegisterStatus.values();

    public static RegisterStatus of(int status) {
        if (status < 1 || status > 3) {
            throw new NumberFormatException("Invalid value for Status: " + status);
        }
        return ENUMS[status - 1];
    }

    public int getValue() {
        return ordinal() + 1;
    }

}
