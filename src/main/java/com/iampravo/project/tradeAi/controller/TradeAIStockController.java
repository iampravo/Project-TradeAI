package com.iampravo.project.tradeAi.controller;

import com.iampravo.project.tradeAi.exception.TradeAIInvalidStockException;
import com.iampravo.project.tradeAi.service.TradeAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collector;

@RestController
@RequestMapping(value = "/tradeAI/stock")
public class TradeAIStockController {

    @Autowired
    TradeAIService tradeAIService;


    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "Welcome to TradeAi";
    }

    @RequestMapping(value = "/{ticker}")
    public String getStockDetail(@PathVariable String ticker) {
        String response = "";
        try {
            response = tradeAIService.getStockDetail(ticker);
        } catch (TradeAIInvalidStockException e) {
            response = e.getLocalizedMessage();
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "/multiple/{ticker}")
    public String[] getStockDetail(String[] tickers) {
        String response[] = new String[tickers.length];

        response = (String[]) Arrays.stream(tickers).map(ticker ->
        {
            try {
                return tradeAIService.getStockDetail(ticker);
            } catch (TradeAIInvalidStockException e) {
                e.printStackTrace();
                return e.getLocalizedMessage();
            }
        }).toArray();
        return response;
    }
}
