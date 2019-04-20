package com.iampravo.project.tradeAi.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class RestUtility {
    public static final String DATA_SOURCE_URL = "dataSourceUrl";
    public static final String APIKEY = "apikey";
    public static final String AND = "&";
    public static final String TICKER_PLACEHOLDER = "%TICKER%";
    public static final String FUNCTION_PLACEHOLDER = "%FUNCTION%";
    public static final String INTERVAL_PLACEHOLDER = "%INTERVAL%";

    @Autowired
    private Environment environment;


    public static String buildRestUrl() {

        return "";
    }

    public String buildRestQueryUrl() {
        // final String uri = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=INFY&interval=5min&apikey=RMMR7NG6ZAARQ0N4";
        return new StringBuffer(environment.getProperty(DATA_SOURCE_URL)).append("/query")
                .append("?").append("function=").append(FUNCTION_PLACEHOLDER)
                .append(AND).append("symbol=").append(TICKER_PLACEHOLDER)
                .append(AND).append("interval=").append(INTERVAL_PLACEHOLDER).append(AND).append(APIKEY).append("=")
                .append(environment.getProperty(APIKEY)).toString();
    }

    public String buildRestSearchSymbolUrl() {
        return new StringBuffer(environment.getProperty(DATA_SOURCE_URL))
                .append("/query?function=SYMBOL_SEARCH&keywords=").append(TICKER_PLACEHOLDER).append("&").append(APIKEY)
                .append("=").append(environment.getProperty(APIKEY)).toString();
    }
}
