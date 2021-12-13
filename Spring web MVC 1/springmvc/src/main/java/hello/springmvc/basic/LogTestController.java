package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j //이 애노테이션을 넣으면 밑의 log 선언 코드를 자동으로 해줌
@RestController //RestAPI 만들 때 핵심적인 controller
public class LogTestController {
//    private final Logger log = LoggerFactory.getLogger(getClass()); //Logger와 LoggerFactory는 slf4j꺼로 해야함

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";

        System.out.println("name = " + name); //단순하게 출력됨

        //log 레벨 : TRACE > DEBUG > INFO > WARN > ERROR
        //보통 개발 서버는 DEBUG 출력, 운영 서버는 INFO 출력
        log.trace("trace log={}", name);
        log.debug("trace log={}", name);
        //이 둘은 원래 안나옴
        //application.properties에서 설정을 해주면 나옴
        log.info("info log={}", name); //log로 많은 정보가 함께 찍혀서 나옴
        log.warn("trace log={}", name);
        log.error("trace log={}", name);



        return "ok";
        //RestController 를 사용하면 return 한 스트링 값이 http 바디에 넣어짐
        //간단하게 test할 때 편리하게 사용할 수 있음
    }
}
