package com.test.emailgen.controller;

import com.test.emailgen.model.User;
import com.test.emailgen.repository.UserRepository;
import com.test.emailgen.util.Generator;
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
        Generator generator = new Generator(user.getName());

        if(userRepository.findByEmail(generator.getEmail()).size() > 0){
            int i = 1;
            while(userRepository.findByEmail(generator.getEmail()).size() > 0){
                generator.setEmail(generator.getUserName()+i+"@kalimat.ai");
                i++;
            }
        }
        user.setUsername(generator.getUserName());
        user.setEmail(generator.getEmail());

        if (result.hasErrors()){
            return "add-user";
        }
        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());

        return "index";
    }
}
