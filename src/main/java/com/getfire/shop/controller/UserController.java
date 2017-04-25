package com.getfire.shop.controller;

import com.getfire.shop.model.User;
import com.getfire.shop.service.SecurityService;
import com.getfire.shop.service.UserService;
import com.getfire.shop.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

    private final UserService userService;

    private final SecurityService securityService;

    private final UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.securityService = securityService;
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "/user/registration";
    }

    @RequestMapping(value = "/user/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "user/registration";
        }
        userService.saveUser(userForm);
        securityService.autoLogin(userForm.getUsername(), userForm.getConfirmPassword());
        return "redirect:/user/welcome";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Username or password is incorrect.");
        }
        if (logout != null) {
            model.addAttribute("message", "Logged out success");
        }
        return "/user/login";
    }

    @RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
    public String welcome(Model model) {
        return "/user/welcome";
    }

    @RequestMapping(value = "/user/admin", method = RequestMethod.GET)
    public String admin(Model model) {
        return "/user/admin";
    }


}
