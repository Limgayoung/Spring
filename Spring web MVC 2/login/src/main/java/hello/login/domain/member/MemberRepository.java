package hello.login.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
public class MemberRepository {

    private static Map<Long, Member> store = new HashMap<>(); //static 사용
    private static long sequence = 0L; //static 사용

    public Member save(Member member) {
        member.setId(++sequence);
        log.info("save: member={}", member);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public Optional<Member> findByLoginId(String loginId){
        /*
        List<Member> all = findAll();
        for (Member m : all) {
            if(m.getLoginId().equals(loginId)){
                return Optional.of(m);
            }
        }
        return Optional.empty();
*/
        //위와 동일한 코드
        //lamda와 stream을 기본으로 사용할 수 있어야 함
        return findAll().stream()
                .filter(m -> m.getLoginId().equals(loginId)) //filter에서 걸러진 애들만 다음 단계로 넘어갈 수 있음
                .findFirst();
        //Optional : 들어 있을 수도 있고 비어 있을 수도 있음
        //값이 없을 때 (null) Optional로 empty할 수 있도록 함
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore(){
        store.clear();
    }

}
