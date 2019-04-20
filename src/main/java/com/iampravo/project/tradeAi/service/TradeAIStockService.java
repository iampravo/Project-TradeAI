package com.iampravo.project.tradeAi.service;

import com.iampravo.project.tradeAi.dao.TradeAIDao;
import com.iampravo.project.tradeAi.exception.TradeAIInvalidStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeAIStockService implements TradeAIService {
    @Autowired
    TradeAIDao tradeAIDao;

    public String getStockDetail(String ticker) throws TradeAIInvalidStockException {
        return tradeAIDao.getStockDetail(ticker);

    }
}
