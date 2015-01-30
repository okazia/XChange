package com.xeiam.xchange.bitfinex.v1.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BitfinexCancelAllOrdersResponse {

  private final String result;

  /**
   * Constructor
   *
   * @param result
   */
  public BitfinexCancelAllOrdersResponse(@JsonProperty("result") String result) {

    this.result = result;
  }

  public String getResult() {

    return result;
  }

  @Override
  public String toString() {

    StringBuilder builder = new StringBuilder();
    builder.append("BitfinexCancelAllOrdersResponse [result=");
    builder.append(result);
    builder.append("]");
    return builder.toString();
  }
}
