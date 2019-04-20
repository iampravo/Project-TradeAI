package com.iampravo.project.tradeAi.dao;

import com.iampravo.project.tradeAi.exception.TradeAIInvalidStockException;
import com.iampravo.project.tradeAi.rest.RestUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Repository
public class TradeAIStockDao implements TradeAIDao {


    @Autowired
    RestUtility restUtility;

    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public String getStockDetail(String ticker) throws TradeAIInvalidStockException {
        validateStockTicker(ticker);
        String function = "TIME_SERIES_INTRADAY";
        String interval = "5min";
        String restQueryUrl = restUtility.buildRestQueryUrl();
        restQueryUrl = restQueryUrl.replace(RestUtility.FUNCTION_PLACEHOLDER, function)
                .replace(RestUtility.TICKER_PLACEHOLDER, ticker)
                .replace(RestUtility.INTERVAL_PLACEHOLDER, interval);
        return restTemplate.getForObject(restQueryUrl, String.class);

    }

    private void validateStockTicker(String ticker) throws TradeAIInvalidStockException {
        String restUrl = restUtility.buildRestSearchSymbolUrl();
        restUrl = restUrl.replace("%TICKER%", ticker);
        if (restTemplate.getForObject(restUrl, String.class).contains("Error Message"))
            throw new TradeAIInvalidStockException(ticker + " does not exist, please provide correct Ticker");
    }
}
