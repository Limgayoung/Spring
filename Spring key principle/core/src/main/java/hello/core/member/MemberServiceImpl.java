package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//인터페이스 밑에 구현체가 하나만 있을 때에는 관례상 인터페이스 명 뒤에 Impl이라고 많이 씀
@Component //빈이 자동으로 등록되지만 의존관계를 주입할 수 있는 방법이 없음 -> Autowired를 사용해서 자동으로 주입
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Autowired //이 기능을 생성자에 붙여주면 멤버 리파지토리에 맞는 타입을 찾아와서 자동으로 연결해서 주입해 줌
    // 마치 ac.getBean(MemberRepository.class)와 같음
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //뒤에 ;까지 완성해주는 단축키 : shift + ctrl + enter

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
