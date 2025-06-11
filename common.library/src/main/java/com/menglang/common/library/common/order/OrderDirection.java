package com.menglang.common.library.common.order;

public enum OrderDirection {
    ASC("asc"),
    DESC("desc");

    private final String value;

    OrderDirection(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static OrderDirection fromString(String value) {
        for (OrderDirection dir : OrderDirection.values()) {
            if (dir.value.equalsIgnoreCase(value)) {
                return dir;
            }
        }
        throw new IllegalArgumentException("Unknown OrderDirection: " + value);
    }
}
