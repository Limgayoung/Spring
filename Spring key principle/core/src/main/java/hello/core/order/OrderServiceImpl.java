package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor //final이 붙은 필수값을 가지고 생성자를 만들어줌 //현재 매개체의 final의 생성자를 만들어줌 ㄱㅇㄷ~
public class OrderServiceImpl implements OrderService{

    //필드 주입
    //@Autowired private MemberRepository memberRepository; //의존관계를 필드에서 바로 주입해줌
    //순수한 자바로 테스트할 수 있는 방법이 없음
    //최근에는 필드 주입을 거의 안씀

    //ctrl+B 사용하는 것들 추적

    private final MemberRepository memberRepository; //값이 무조건 있어야 한다고 지정해둔 것 (생성자에서 넣어줌)
    private final DiscountPolicy discountPolicy;

    //@Autowired //스프링이 생성할 때 자동으로 주입해줌 //생성자 주입 방법
    //생성자가 1개만 있으면 Autowired를 생략해도 bean(Component로 등록해도 ㄱㅊ)일 경우에 자동으로 주입해줌
//    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        //생성자에는 왠만하면 값을 다 채워넣어야 함 (주로)
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
