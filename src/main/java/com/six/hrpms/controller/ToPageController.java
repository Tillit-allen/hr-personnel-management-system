package com.six.hrpms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ToPageController {

    @RequestMapping(value = "/toPage",method = {RequestMethod.GET})
    public String sad(String page){
        return page;
    }
}
