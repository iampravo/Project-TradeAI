package com.iampravo.project.tradeAi.service;

import com.iampravo.project.tradeAi.exception.TradeAIInvalidStockException;

public interface TradeAIService {
    public String getStockDetail(String ticker) throws TradeAIInvalidStockException;

}
