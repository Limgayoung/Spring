package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    //new-form은 무조건 get으로만 와야 할 때
//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) //@RequestMapping은 메소드로 이루어져 있어서 다 넣을 수 있음
    @GetMapping("/new-form") //위와 동일한 작업을 하는 애노테이션
    //애노테이션 기반의 컨트롤러는 ModelAndView로 반환해도 되고 문자로 반환해도 됨. (굉장히 유동성 있어서)
    public String newForm(){ //애노테이션 기반으로 동작해서 메서드 이름은 임의로 지으면 됨
        return "new-form";
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }
}
