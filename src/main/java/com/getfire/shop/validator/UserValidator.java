package com.getfire.shop.validator;

import com.getfire.shop.model.User;
import com.getfire.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

//@Component
//public class UserValidator implements Validator {
public class UserValidator  {

//    private UserService userService;
//
//    @Autowired
//    public UserValidator(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.equals(clazz);
//    }
//
//    @Override
//    public void validate(Object object, Errors errors) {
//        User user = (User) object;
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Required");
//        if (user.getLogin().length() < 6 || user.getLogin().length() > 30) {
//            errors.rejectValue("login", "Size.loginForm.login");
//        }
//        if (userService.findByLogin(user.getLogin()) != null) {
//            errors.rejectValue("login", "Duplicate.loginForm.login");
//        }
//
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Required");
//
//        if (user.getPassword().length() < 6 || user.getPassword().length() > 30) {
//            errors.rejectValue("password", "Size.loginForm.password");
//        }
//
//        if (!user.getConfirmPassword().equals(user.getPassword())) {
//            errors.rejectValue("password", "Different.loginForm.password");
//        }
//    }
}
