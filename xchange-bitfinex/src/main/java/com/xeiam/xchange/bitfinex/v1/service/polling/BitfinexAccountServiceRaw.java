package com.xeiam.xchange.bitfinex.v1.service.polling;

import java.io.IOException;
import java.util.Date;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.bitfinex.v1.dto.BitfinexException;
import com.xeiam.xchange.bitfinex.v1.dto.account.*;
import com.xeiam.xchange.exceptions.ExchangeException;

public class BitfinexAccountServiceRaw extends BitfinexBasePollingService {

  /**
   * Constructor
   *
   * @param exchange
   */
  public BitfinexAccountServiceRaw(Exchange exchange) {

    super(exchange);
  }

  public BitfinexBalancesResponse[] getBitfinexAccountInfo() throws IOException {

    try {
      BitfinexBalancesResponse[] balances = bitfinex.balances(apiKey, payloadCreator, signatureCreator,
          new BitfinexBalancesRequest(String.valueOf(exchange.getNonceFactory().createValue())));
      return balances;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }

  public BitfinexMarginInfosResponse[] getBitfinexMarginInfos() throws IOException {

    try {
      BitfinexMarginInfosResponse[] marginInfos = bitfinex.marginInfos(apiKey, payloadCreator, signatureCreator, new BitfinexMarginInfosRequest(
              String.valueOf(exchange.getNonceFactory().createValue())));
      return marginInfos;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }

  public BitfinexPastTransactionsResponse[] getBitfinexTransactionHistory(String currency, String method, Long since, Long until, int limit) throws IOException {

    try {
      BitfinexPastTransactionsResponse[] trades = bitfinex.pastTransactions(apiKey, payloadCreator, signatureCreator,
              new BitfinexPastTransactionsRequest(String.valueOf(exchange.getNonceFactory().createValue()), currency, method, since, until, limit));
      return trades;
    } catch (BitfinexException e) {
      throw new ExchangeException(e.getMessage());
    }
  }

}
