package com.springbootacademy.batch6POS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrdeDetailsSave {
    private String itemName;
    private double qty;
    private Double amount;
    private int items;
}
