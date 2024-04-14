package hello.itemservice.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// 최근 Junit5에서는 public이 없어도 됨
class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    // 다음 테스트 시 데이터 제거 용
    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }


    @Test
    void save() {

        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemRepository.save(item);

        //then
        Item findItem = itemRepository.findById(item.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void update() {
    }

    @Test
    void clearStore() {
    }
}
