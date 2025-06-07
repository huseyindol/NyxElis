package com.nyxelis.enums;

import lombok.Getter;

@Getter
public enum ComponentType {
    MODULE("module"),
    WIDGET("widget"),
    SLIDER("slider");

    private final String type;

    ComponentType(String type) {
        this.type = type;
    }
}
