package com.springbootacademy.batch6POS.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customers;
    private Date date;
    private Double total;
    private boolean activeState;
    private List<RequestOrdeDetailsSave> orderDetails;
}
