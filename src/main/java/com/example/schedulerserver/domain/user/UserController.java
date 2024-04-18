package com.example.schedulerserver.domain.user;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j(topic = "user controller")
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody @Valid UserCreateForm userCreateForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/signup";
        }
        if(!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())){
            bindingResult.rejectValue("password2","passwordInCorrect","2개의 패스워드가 일치하지 않습니다.");
            return "redirect:/signup";
        }
        userService.create(userCreateForm.getUserid(),userCreateForm.getName(),userCreateForm.getPassword1());
        return "redirect:/";
    }
    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

}
