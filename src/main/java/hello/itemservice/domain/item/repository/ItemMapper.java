package hello.itemservice.domain.item.repository;

import hello.itemservice.domain.item.vo.Item;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {

    Item save(Item item);
    Item findById(Long id);
    List<Item> findAll();
    void update(Long itemId, Item updateParam);
    void cleaStore();

}
