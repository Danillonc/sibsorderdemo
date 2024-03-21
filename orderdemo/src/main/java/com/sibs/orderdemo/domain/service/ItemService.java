package com.sibs.orderdemo.domain.service;

import com.sibs.orderdemo.domain.entity.Item;

import java.util.Optional;

public interface ItemService {
    public Optional<Item> createItem(final Item item);
    public Optional<Item> getItem(long itemId);
    public void updateItem(final Item item, long itemId);
    public void deleteItem(long itemId);
}
