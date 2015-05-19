package com.xeiam.xchange.examples.bitfinex.trade;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.bitfinex.v1.dto.trade.BitfinexTradeResponse;
import com.xeiam.xchange.bitfinex.v1.service.polling.BitfinexTradeServiceRaw;
import com.xeiam.xchange.examples.bitfinex.BitfinexDemoUtils;

import java.io.IOException;

public class BitfinexTradeDemo {

  public static void main(String[] args) throws IOException {

    Exchange bfx = BitfinexDemoUtils.createExchange();

    //raw(bfx);
      BitfinexTradeServiceRaw tradeService = (BitfinexTradeServiceRaw) bfx.getPollingTradeService();
      String response = tradeService.accountInfos();
  }

  private static void raw(Exchange bfx) throws IOException {

    BitfinexTradeServiceRaw tradeService = (BitfinexTradeServiceRaw) bfx.getPollingTradeService();
    //LimitOrder limitOrder = new LimitOrder.Builder(OrderType.BID, CurrencyPair.BTC_USD).limitPrice(new BigDecimal("481.69"))
    //    .tradableAmount(new BigDecimal("0.001")).build();
    //tradeService.placeBitfinexLimitOrder(limitOrder, BitfinexOrderType.LIMIT, false);

       BitfinexTradeResponse[] response =  tradeService.getBitfinexTradeHistory("BTCUSD", 0L, 100);
      tradeService.getBitfinexTradeHistory("BTCUSD", 0L, 100);

  }
}
