package kr.bit.controller;

import javax.validation.Valid;
import kr.bit.beans.User;
import kr.bit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(@ModelAttribute("loginBean") User loginProBean, Model model,
                        @RequestParam(value="fail", defaultValue = "false") boolean fail) {
        model.addAttribute("fail", fail);
        return "main";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginBean") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "main";
        }

        boolean loginResult = userService.login(user.getUser_id(), user.getUser_pw());
        System.out.println("로그인 결과: " + loginResult);

        if (!loginResult) {
            return "login_fail";
        }

        return "login_success";
    }
}
