package vn.edu.iuh.fit.models;

public enum isGrant {
    ONE(1),
    MINUS_ONE(-1),
    ZERO(0);
    private final int value;

    private isGrant(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
}
