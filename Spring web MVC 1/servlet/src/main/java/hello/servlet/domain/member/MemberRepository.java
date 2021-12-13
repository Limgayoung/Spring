package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {

    //동시성 문제가 고려되어 있지 않아서 실무에서는 ConcurrentHashMap, AtomicLong 사용을 고려해야함
    //싱글톤으로 만들어 놔서 static 없어도 되지만 일단 만듬
    private static Map<Long, Member> store = new HashMap<>(); //key는 Long value는 Member
    private static long sequence = 0L; //아이디가 하나씩 증가하는 시퀀스 생성

    //싱글톤으로 만들기
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    //private로 생성자를 막아서 아무나 못만들게 해줘야함
    private MemberRepository(){
    }

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values()); //store에 있는 values 값을 수정하지 않게 하기 위해서. (store 자체를 보호하기 위해서)
    }

    public void clearStore(){//테스트 같은 곳에서만 쓰는거임
        store.clear();
    }
}
