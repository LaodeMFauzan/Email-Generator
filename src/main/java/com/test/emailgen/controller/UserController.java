package com.test.emailgen.controller;

import com.test.emailgen.model.User;
import com.test.emailgen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public String showSignUpForm(User user){
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model model ){
        String fullName = user.getName();
        user.setEmail(fullName+"kalimat.ai");
        user.setUsername(fullName);

        if (result.hasErrors()){
            System.out.println("tes");
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}
