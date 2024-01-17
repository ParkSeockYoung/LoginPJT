package hello.hello.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    ModelAndView mav = new ModelAndView();

    @GetMapping("/hello")
    public ModelAndView hello() {
        mav.setViewName("hello");
        mav.addObject("data", "hello!!!!!");
        return mav;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        mav.setViewName("login");
        return mav;
    }

    @PostMapping("/login/try")
    @ResponseBody
    public ModelAndView loginTry(@RequestParam("ID") String id, @RequestParam("PW") String password) {
        mav.setViewName("login");
        mav.addObject("password", password);
        mav.addObject("id", id);
        System.out.println(id);
        System.out.println(password);
        return mav;
    }

}
