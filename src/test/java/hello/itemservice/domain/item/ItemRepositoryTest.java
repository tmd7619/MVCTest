package hello.itemservice.domain.item;

import hello.itemservice.domain.item.service.ItemServiceImpl;
import hello.itemservice.domain.item.vo.Item;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 최근 Junit5에서는 public이 없어도 됨
class ItemRepositoryTest {

    ItemServiceImpl itemService = new ItemServiceImpl();

//    // 다음 테스트 시 데이터 제거 용
//    @AfterEach
//    void afterEach() {
//        itemService.clearStore();
//    }


    @Test
    void save() {

        //given
        Item item = new Item("itemA", 10000, 10);

        //when
        Item saveItem = itemService.save(item);

        //then
        Item findItem = itemService.findById(item.getId());
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
