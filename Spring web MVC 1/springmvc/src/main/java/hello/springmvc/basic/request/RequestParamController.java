package hello.springmvc.basic.request;


import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        log.info("username={}, age={}", username, age);


        response.getWriter().write("ok");
    }

    @ResponseBody //return 된 ok라는 문자를 http 응답 메세지에 넣어서 반환함, restController와 같은 효과
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge)
    {
        log.info("username={}, age={}", memberName, memberAge);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username, //파라미터 값과 변수명이 같으면 생략 가능 ("username")
            @RequestParam int age)
    {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) //단순 타입이면 (String, int, Integer 등) @RequestParam 생략 가능
    {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username, //아무것도 안 적으면 true, true면 username이 꼭 들어 있어야함
            @RequestParam(required = false) Integer age) //false면 없어도 됨, int면 null을 넣을 수 없어서 Integer로 넣어줘야 함
            //java에서 Integer는 객체형. 객체형은 null이 들어갈 수 있음
    {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username, //값이 안들어오면 guest로 받아들임
            @RequestParam(required = false, defaultValue = "-1") int age)
            //defaultValue가 있으면 required가 필요 없음. 값이 있든 없든 실행돼서
            //빈 문자까지 처리해줌 ("")도 "guest"로 받아줌

    {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }
    //파라미터를 Map, MultiValueMap으로 조회 가능
    //?userIds=id1&userIds=id2
    //key = userIds, value = [id1, id2]
    //보통 파라미터값은 1개를 씀, 애매하게 2개를 쓰는 경우는 많지 않음

    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){ //모델(HelloData) 객체가 생성되고 요청 파라미터 값도 모두 들어가 있음
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return ("ok");
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){ //@ModelAttribute 생략 가능
        log.info("username={}, age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={}", helloData);

        return ("ok");

    }
}
