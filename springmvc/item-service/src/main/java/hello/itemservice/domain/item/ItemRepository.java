package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//리포지토리 패키지 따로 분리할 수 있지만 프로젝트 사이즈가 작아서 그냥 한 곳에 만들게
@Repository // 이 안에 @Componant 있음. 이제 스프링 쓴다~~
public class ItemRepository {

    // static 사용함
    // 실무에서는 여러 곳에서 접근하니까 해시맵 쓰면 안되고 Concurrent HashMap 써야함. 해시맵 -> 싱글톤 생성이라
    private static final Map<Long, Item> store = new HashMap<>();
    // 아래 이것도 실무에서 동시에 접속하니까 long 쓰면 안되고 AtomicLong 등 다른 거 써야함.
    private static long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }
}
