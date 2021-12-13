package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    //private final ObjectProvider<MyLogger> myLoggerProvider;
    private final MyLogger myLogger; //진짜 myLogger가 아닌 가짜 myLogger(프록시) 를 집어넣음, 요청이 오면 내부에서 진짜 빈을 스프링 컨테이너에서 찾아옴

    @RequestMapping("log-demo")
    @ResponseBody //화면 없이 문자만 그대로 응답 보낼 수 있음

    public String LogDemo(HttpServletRequest request) throws InterruptedException {
        String requestURL = request.getRequestURL().toString();

        System.out.println("myLogger = " + myLogger.getClass());


        //MyLogger myLogger = myLoggerProvider.getObject(); //getObject를 최초로 하는 시점에 만들어짐
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        //Thread.sleep(1000); //요청이 섞여도 구분 가능하고, 요청이 많아도 스프링이 각각의 빈을 할당해줘서 섞이지 않음
        //멤버 변수 같은 경우 request로 활용 가능함
        logDemoService.logic("testId");
        return "OK";
    }
}
