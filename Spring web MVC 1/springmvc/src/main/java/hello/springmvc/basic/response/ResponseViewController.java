package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseView1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello!");

        return mav;
    }

    //@ResponseBody // 얘를 쓰면 return 값이 view로 안가고 바로 화면에 출력됨
    @RequestMapping("/response-view-v2")
    public String responseView2(Model model) {
        model.addAttribute("data","hello!");
        return "response/hello";
    }

    @RequestMapping("/response/hello") //경로의 이름과 같음 //권장하지 않음
    //controller의 이름과 view의 논리적 이름이 같으면 그대로 실행해줌
    public void responseView3(Model model) {
        model.addAttribute("data","hello!");
    }

}
