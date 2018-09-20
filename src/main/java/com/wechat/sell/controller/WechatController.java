package com.wechat.sell.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Wechat")
public class WechatController {
    @RequestMapping("authorize")
    public void authorize(@RequestParam("returnUrl")String returnUrl){

    }
}
