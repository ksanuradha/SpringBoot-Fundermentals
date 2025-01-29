package com.springbootacademy.batch6POS.controller;

import com.springbootacademy.batch6POS.dto.ItemDTO;
import com.springbootacademy.batch6POS.dto.paginated.PaginatedResponseItemDto;
import com.springbootacademy.batch6POS.dto.request.RequestItemSaveDTO;

import com.springbootacademy.batch6POS.exception.NotFoundException;

import com.springbootacademy.batch6POS.service.ItemService;
import com.springbootacademy.batch6POS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {

    @Autowired
    private ItemService itemService;

//    @PostMapping(path = "/save")
//    public String saveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO) {
//        return itemService.saveItem(requestItemSaveDTO);
//    }

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem(@RequestBody RequestItemSaveDTO requestItemSaveDTO) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucess", itemService.saveItem(requestItemSaveDTO)),
                HttpStatus.OK
        );
    }

    @GetMapping(
            path = "/get-by-name",
            params = "name"
    )
    public List<ItemDTO> getItemByNameAndActiveState(@RequestParam(value = "name") String itemName) {
        List<ItemDTO> customerByNameAndActiveState = itemService.getCustomerByNameAndActiveState(itemName);
        if (customerByNameAndActiveState.size() > 0) {
            return customerByNameAndActiveState;
        } else {
            throw new NotFoundException("Not Found MTP Perera");
        }
    }

    @GetMapping(
            path = "/get-by-name1",
            params = "name"
    )
    public ResponseEntity<StandardResponse> getItemByNameAndActiveState1(@RequestParam(value = "name") String itemName) {
        List<ItemDTO> customerByNameAndActiveState = itemService.getCustomerByNameAndActiveState(itemName);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucess", customerByNameAndActiveState),
                HttpStatus.OK
        );
        return response;
    }

    @GetMapping(
            path = "/get-all-item-by-status",
            params = {"page", "size","activeState"}
    )
    public ResponseEntity<StandardResponse> getAllItemsActive(
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") @Max(50) int size,
            @RequestParam(value = "activeState") @Max(50) boolean activeState
            ) {
        PaginatedResponseItemDto paginatedResponseItemDto = itemService.getAllItemsActive(page,size,activeState);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(201,"Sucess", paginatedResponseItemDto),
                HttpStatus.OK
        );
        return response;
    }
}
