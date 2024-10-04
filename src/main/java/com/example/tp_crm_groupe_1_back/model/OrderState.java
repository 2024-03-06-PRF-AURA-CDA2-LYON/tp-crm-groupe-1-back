package com.example.tp_crm_groupe_1_back.model;

import lombok.Getter;

@Getter
public enum OrderState {
    CANCELED(0),
    OPTION(1),
    CONFIRMED(2);

    private int value;
    OrderState(int value) {
        this.value = value;
    }
}
