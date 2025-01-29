package com.springbootacademy.batch6POS.controller;

import com.springbootacademy.batch6POS.dto.paginated.PaginatedResponseOrderDetails;
import com.springbootacademy.batch6POS.dto.request.RequestOrderSaveDTO;
import com.springbootacademy.batch6POS.service.OrderService;
import com.springbootacademy.batch6POS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.Max;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDTO) {
        String id = orderService.addOrder(requestOrderSaveDTO);
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,id + "item sucessfully saved", id ),
                HttpStatus.CREATED
        );
    }

    @GetMapping(
            params = {"stateType", "page", "size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size
    ) {
        PaginatedResponseOrderDetails paginatedResponseOrderDetails = null;
        if(stateType.equalsIgnoreCase("active") | stateType.equalsIgnoreCase("inactive")) {
            boolean status = stateType.equalsIgnoreCase("active")? true : false;
            paginatedResponseOrderDetails = orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"sucess", paginatedResponseOrderDetails),
                HttpStatus.OK
        );
    }
}
