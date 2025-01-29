package com.springbootacademy.batch6POS.service;

import com.springbootacademy.batch6POS.dto.ItemDTO;
import com.springbootacademy.batch6POS.dto.paginated.PaginatedResponseItemDto;
import com.springbootacademy.batch6POS.dto.request.RequestItemSaveDTO;
import java.util.List;

public interface ItemService {

    String saveItem(RequestItemSaveDTO requestItemSaveDTO);

    List<ItemDTO> getCustomerByNameAndActiveState(String itemName);

    PaginatedResponseItemDto getAllItemsActive(int page, int size, boolean activeState);
}
