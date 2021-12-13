package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core.member", //파일을 찾을 위치 지정, 여러 시작 위치를 지정할수도 있음
        basePackageClasses = AutoAppConfig.class, //이 패키지인 hello.core부터 시작
        //시작 지점을 지정하지 않으면 이것을 붙인 클래스의 패키지부터 찾음

        //뺄거 지정
        //필터타입이고, configuration은 빼고 함
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = Configuration.class))
//@Component 이 붙은 클래스를 찾아서 자동으로 스프링 빈으로 등록해줌
public class AutoAppConfig {
//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository)_{
//        return new MemoryMemberRepository();
//    }
}
