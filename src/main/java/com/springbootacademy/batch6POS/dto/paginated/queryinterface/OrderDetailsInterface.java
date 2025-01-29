package com.springbootacademy.batch6POS.dto.paginated.queryinterface;

import java.util.ArrayList;
import java.util.Date;

public interface OrderDetailsInterface {
     String getCustomerName();
     String getCustomerAdress();
     ArrayList getContactNumber();
     Date getDate();
     Double getTotal();
}
