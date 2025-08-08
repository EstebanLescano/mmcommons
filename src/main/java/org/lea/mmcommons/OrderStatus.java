package org.lea.mmcommons;

public enum OrderStatus {
    PENDING,
    PROCESSING,
    COMPLETED,
    CANCELLED,
    REFUNDED,
    FAILED;

    public boolean isFinal() {
        return this == COMPLETED || this == CANCELLED || this == REFUNDED || this == FAILED;
    }
}
