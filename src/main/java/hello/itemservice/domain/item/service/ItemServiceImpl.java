package hello.itemservice.domain.item.service;

import hello.itemservice.domain.item.repository.ItemMapper;
import hello.itemservice.domain.item.vo.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemMapper itemMapper;


    @Override
    public Item save(Item item) {

        return itemMapper.save(item);
    }

    @Override
    public Item findById(Long id) {
        return itemMapper.findById(id);
    }

    @Override
    public List<Item> findAll() {
        return itemMapper.findAll();
    }

    @Override
    public void update(Long itemId, Item updateParam) {

    }

    @Override
    public void cleaStore() {

    }
}
