package com.springbootacademy.batch6POS.service.impl;

import com.springbootacademy.batch6POS.dto.ItemDTO;
import com.springbootacademy.batch6POS.dto.paginated.PaginatedResponseItemDto;
import com.springbootacademy.batch6POS.dto.request.RequestItemSaveDTO;
import com.springbootacademy.batch6POS.entity.Item;
import com.springbootacademy.batch6POS.exception.NotFoundException;
import com.springbootacademy.batch6POS.repo.ItemRepo;
import com.springbootacademy.batch6POS.service.ItemService;
import com.springbootacademy.batch6POS.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItem(RequestItemSaveDTO requestItemSaveDTO) {

        Item item = modelMapper.map(requestItemSaveDTO, Item.class);

        if (!itemRepo.existsById(item.getItemId())) {
            itemRepo.save(item);
            return "Save Sucessful";
        } else {
            throw new DuplicateKeyException("Already Added");
        }
    }

    @Override
    public List<ItemDTO> getCustomerByNameAndActiveState(String itemName) {
        List<Item> items = itemRepo.findAllByItemNameEqualsAndActiveStateEquals(itemName, true);

        //List<ItemDTO> itemsDTOS = modelMapper.map(items, new TypeToken<List<ItemDTO>>(){}.getType());

        List<ItemDTO> itemsDTOS = itemMapper.entityListToDtoList2(items);

        return itemsDTOS;
    }

    @Override
    public PaginatedResponseItemDto getAllItemsActive(int page, int size, boolean activeState) {
        Page<Item> items = itemRepo.findAllByActiveStateEquals(activeState, PageRequest.of(page,size));
        if(items.getSize() < 1) {
            throw new NotFoundException("No Data According to your request");
        }
        return new PaginatedResponseItemDto( itemMapper.pageToList(items), itemRepo.countAllByActiveStateEquals(activeState));
    }
}
