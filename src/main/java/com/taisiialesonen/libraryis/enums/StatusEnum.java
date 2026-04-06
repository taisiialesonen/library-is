package com.taisiialesonen.libraryis.enums;

public enum StatusEnum {
    ACTIVE(0),
    BLOCKED(1),
    DELETED(2);

    private final int index;

    StatusEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getStatusName() {
        return "STATUS_" + this.name();
    }
}
