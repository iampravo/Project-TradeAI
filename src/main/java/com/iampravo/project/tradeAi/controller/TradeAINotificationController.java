package com.iampravo.project.tradeAi.controller;

import com.iampravo.project.tradeAi.service.TradeAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/tradeAI/prediction")
public class TradeAINotificationController {

    @Autowired
    TradeAIService tradeAIService;


    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to TradeAi";
    }


}
