package com.lnson.simple.spring.task.demo2.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "home")
public class HomeController {

    private final static Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(value = "/index.do", method = {RequestMethod.GET})
    public ModelAndView indexAction() {
        return new ModelAndView("index");
    }

}
