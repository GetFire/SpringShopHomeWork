package com.getfire.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AppController {
    @RequestMapping(method = RequestMethod.GET)
    public String welcome() {
        return "index";
    }


}
