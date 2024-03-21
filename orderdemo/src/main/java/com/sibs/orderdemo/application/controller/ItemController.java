package com.sibs.orderdemo.application.controller;

import com.sibs.orderdemo.application.request.ItemDto;
import com.sibs.orderdemo.domain.service.ItemService;
import com.sibs.orderdemo.util.ItemDtoConverter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/item")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }


    @PostMapping("/create")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){
        ItemDto dto = ItemDtoConverter.convertToDto(
                this.itemService.createItem(ItemDtoConverter.convertToDomain(itemDto)));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<ItemDto> getItem(@PathVariable long itemId){
        return new ResponseEntity<>(ItemDtoConverter.convertToDto(this.itemService.getItem(itemId)), HttpStatus.OK);
    }

    @PatchMapping("/update/{itemId}")
    public ResponseEntity<Void> updateItem(@RequestBody final ItemDto itemDto, @PathVariable long itemId){
        this.itemService.updateItem(ItemDtoConverter.convertToDomain(itemDto), itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{itemId}")
    public ResponseEntity<Void> deleteItem(@PathVariable long itemId){
        this.itemService.deleteItem(itemId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
