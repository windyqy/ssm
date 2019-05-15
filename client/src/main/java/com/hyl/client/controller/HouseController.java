package com.hyl.client.controller;

import com.hyl.core.BaseController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("houseController")
@RequestMapping("/house")
public class HouseController extends BaseController {
    private static Logger log = LoggerFactory.getLogger(HouseController.class);

    @RequestMapping(value = "/a",method = RequestMethod.GET)
    public String testFreemarker(ModelMap model) {
        log.trace("======trace");
        log.debug("======debug");
        log.info("======info");
        log.warn("======warn");
        log.error("======error");
        model.addAttribute("a", "HYL");
        model.put("b", "HBY");
        return "home";
    }

    @RequestMapping(value = "/b",method = RequestMethod.GET)
    public String testJSP(ModelMap model) {
        model.addAttribute("a", "HYL");
        model.put("b", "HBY");
        return "test2";
    }
}
