package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//spring에서는 설정 정보에 이렇게 해야함

public class AppConfig { //어플리케이션의 환경 설정에 대한 것을 다 함 //애플리케이션의 구성, 설정 정보를 담당함

    //@Bean -> memberService -> new MemoryMemberRepository
    //@Bean -> orderService -> new MemoryMemberRepository

    //예상
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.memberRepository
    //call AppConfig.orderService
    // call AppConfig.memberRepository

    //실제로 호출되는 call
    //call AppConfig.memberService
    //call AppConfig.memberRepository
    //call AppConfig.orderService

    @Bean
    //bean을 붙이면 스프링 컨테이너에 등록됨
    public MemberService memberService(){ //키는 이름, value는 객체 인스턴스로 스프링 컨테이너에 등록됨, 꺼낼때는 이름, 타입으로 꺼냄
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
        //단축키: ctrl + alt + M -> 리펙토링
        //생성자를 통해 객체가 인스턴스로 들어감
        //생성자 주입
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
