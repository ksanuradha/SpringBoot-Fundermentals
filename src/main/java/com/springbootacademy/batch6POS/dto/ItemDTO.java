package com.springbootacademy.batch6POS.dto;

import com.springbootacademy.batch6POS.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDTO {
    private int itemId;
    private String itemName;
    private MeasuringUnitType measuringUnitType;
    private double balanceQty;
    private double supplier_price;
    private double sellingPrice;
    private boolean activeState;
}
