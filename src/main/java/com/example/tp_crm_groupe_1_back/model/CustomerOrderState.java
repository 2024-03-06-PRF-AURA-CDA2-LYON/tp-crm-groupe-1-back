package com.example.tp_crm_groupe_1_back.model;

import lombok.Getter;

@Getter
public enum CustomerOrderState {
    ACTIVE(0),
    INACTIVE(1);

    private final int value;
    CustomerOrderState(int value) {
        this.value = value;
    }
}
