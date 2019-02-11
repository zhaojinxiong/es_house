package com.coder.es_house.web.controller;

import com.coder.es_house.base.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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

    @GetMapping("/get")
    @ResponseBody
    public ApiResponse getOfMessage(){
        return  ApiResponse.ofMessage(200,"成功了！");
    }


    @GetMapping("/404")
    public String notFoundPage() {
        return "404";
    }

    @GetMapping("/403")
    public String accessError() {
        return "403";
    }

    @GetMapping("/500")
    public String internalError() {
        return "500";
    }

    @GetMapping("/logout")
    public String logoutPage() {
        return "logout";
    }
}
