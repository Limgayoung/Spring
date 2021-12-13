package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //스프링이 자동으로 빈으로 등록함 //이 방식이 가장 깔끔해서 거의 이 방식만 사용함
//@Component
//@RequestMapping
//밑의 두 개로도 @Controller 역할을 할 수 있음
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form")
    public ModelAndView process(){ //애노테이션 기반으로 동작해서 메서드 이름은 임의로 지으면 됨
        return new ModelAndView("new-form");
    }
}
