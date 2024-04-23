package hello.itemservice.domain.item.service;

import hello.itemservice.domain.item.vo.Item;

import java.util.List;

public interface ItemService {

    Item save(Item item);
    Item findById(Long id);
    List<Item> findAll();
    void update(Long itemId, Item updateParam);
    void cleaStore();
}
