package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

    // 멀티 쓰레드 환경에서는 HashMap을 쓰면 안됨, Long 도 마찬가지
    private static final Map<Long, Item> store = new ConcurrentHashMap<>();
    private static final AtomicLong sequence = new AtomicLong(0);


    public Item save(Item item) {
        long currentId = sequence.incrementAndGet();
        store.put(currentId, item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    /*
        updateParam은 지금 Item 객체를 만드는게 아니라, 새로운 DTO를 만드는게 좋다.. (왜냐? update 할때 id 값을 사용하지 않기에)
     */
    public void update(Long itemId, Item updateParam) {
        store.computeIfPresent(itemId, (key, findItem) -> {
            findItem = findById(itemId);
            findItem.setItemName(updateParam.getItemName());
            findItem.setQuantity(updateParam.getQuantity());
            findItem.setPrice(updateParam.getPrice());
        })
    }

    public void clearStore() {
        store.clear();
    }
}
