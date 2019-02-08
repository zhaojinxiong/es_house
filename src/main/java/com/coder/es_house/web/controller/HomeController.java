package com.coder.es_house.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * @author:apple
 * @date: 2019/2/5
 * @time: 下午10:24
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("name","imooc");
        return "index";
    }
}
