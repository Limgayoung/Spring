package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    //단축키 psvm enter
    public static void main(String[] args) {
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();
        
        //Spring 버전
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //appconfig에 있는 환결 설정 정보를 가지고 Spring이 @Bean이 붙은 것들을 스프링 컨테이너 안에 넣어서 다 관리함
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //메소드 이름, 타입으로 찾아야 함
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        //단축키: ctrl + alt + v
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("find Member = "+ findMember.getName());
    }
}
