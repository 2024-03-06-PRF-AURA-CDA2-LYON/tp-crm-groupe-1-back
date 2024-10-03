package com.example.tp_crm_groupe_1_back.model;

import lombok.Getter;

@Getter
public enum CustomerOrderState {
    ACTIVE(0),
    INACTIVE(1);

    private int value;
    CustomerOrderState(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
