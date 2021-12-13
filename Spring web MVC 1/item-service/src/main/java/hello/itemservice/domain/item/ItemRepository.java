package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository //component scan의 대상이 됨
public class ItemRepository {

    private static final Map<Long, Item> store = new HashMap<>(); //실제로는 hashmap을 사용하면 안됨 //static
    //멀티쓰레드 환경에서 여러개가 동시에 접근하는 경우에는 hashmap을 사용하면 안됨
    //사용하고 싶으면 ConcurrentHashMap<>() 사용해야 함
    private static long sequence = 0L; //static
    //얘도 long으로 사용하면 안됨. 그때는 atomicLong과 같은 다른걸 사용해야 함

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(long id){
        return store.get(id);
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
        //한번 감싸서  반환하게 되면 ArrayList에 값을 넣어도 실제 store에는 변함 없기 때문에 안전하게 감싼 것

    }

    public void update(Long itemId, Item updateParam){
        Item findItem = findById(itemId);
        //별도의 update용 객체를 만드는 게 원래 맞음
        //정석대로라면 ItemParamDTO 같은 객체를 만드는게 맞음
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore(){
        store.clear();
    }
}
