package com.taisiialesonen.libraryis.enums;

public enum RoleEnum {
    ADMIN(0),
    LIBRARIAN(1),
    READER(2);

    private final int index;

    RoleEnum(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public String getRoleName() {
        return "ROLE_" + this.name();
    }
}
