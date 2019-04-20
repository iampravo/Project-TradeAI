package com.iampravo.project.tradeAi.dao;

import com.iampravo.project.tradeAi.exception.TradeAIInvalidStockException;

public interface TradeAIDao {
    public String getStockDetail(String ticker) throws TradeAIInvalidStockException;
}
