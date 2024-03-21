package com.sibs.orderdemo.domain.service.impl;

import com.sibs.orderdemo.domain.entity.Item;
import com.sibs.orderdemo.domain.repository.ItemRepository;
import com.sibs.orderdemo.domain.service.ItemService;
import jakarta.persistence.EntityNotFoundException;

import java.util.Optional;

public class ItemServiceImpl implements ItemService {

    private ItemRepository itemRepository;

    public ItemServiceImpl(final ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Optional<Item> createItem(Item item) {
        Item itemDb =  this.itemRepository.saveAndFlush(item);
        return Optional.of(itemDb);
    }

    @Override
    public Optional<Item> getItem(long itemId) {
        return this.itemRepository.findById(itemId);
    }

    @Override
    public void updateItem(Item item, long itemId) {
        this.itemRepository.findById(itemId)
                .ifPresentOrElse(itemDb -> {
                            itemDb.setName(item.getName());
                            itemDb.setName(item.getName());
                            this.itemRepository.saveAndFlush(itemDb);
                        },
                        () -> {
                            throw new EntityNotFoundException("Item not foudn");
                        });
    }

    @Override
    public void deleteItem(long itemId) {
        this.itemRepository.findById(itemId)
                .ifPresentOrElse(itemDb -> {
                            this.itemRepository.deleteById(itemId);
                        },
                        () -> {
                            throw new EntityNotFoundException("Cannot delete item.");
                        });
    }
}
