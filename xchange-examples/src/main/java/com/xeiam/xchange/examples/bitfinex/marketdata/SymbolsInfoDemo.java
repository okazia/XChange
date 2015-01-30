package com.xeiam.xchange.examples.bitfinex.marketdata;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitfinex.v1.BitfinexExchange;
import com.xeiam.xchange.bitfinex.v1.dto.marketdata.BitfinexSymbolInfo;
import com.xeiam.xchange.bitfinex.v1.service.polling.BitfinexMarketDataServiceRaw;
import com.xeiam.xchange.service.polling.marketdata.PollingMarketDataService;

import java.io.IOException;
import java.util.Arrays;

public class SymbolsInfoDemo {

  public static void main(String[] args) throws Exception {

    // Use the factory to get Bitfinex exchange API using default settings
    Exchange bitfinex = ExchangeFactory.INSTANCE.createExchange(BitfinexExchange.class.getName());

    // Interested in the public polling market data feed (no authentication)
    PollingMarketDataService marketDataService = bitfinex.getPollingMarketDataService();

    raw((BitfinexMarketDataServiceRaw) marketDataService);
  }

  private static void raw(BitfinexMarketDataServiceRaw marketDataService) throws IOException {

    BitfinexSymbolInfo[] symbolInfos = marketDataService.getBitfinexSymbolInfo();
    System.out.println("SymbolInfo, default. Size= " + symbolInfos.length);
    System.out.println(Arrays.toString(symbolInfos));
  }
}
