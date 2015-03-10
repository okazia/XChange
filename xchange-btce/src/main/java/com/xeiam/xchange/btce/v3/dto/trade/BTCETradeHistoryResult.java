package com.xeiam.xchange.btce.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * @author Raphael Voellmy
 */
public class BTCETradeHistoryResult implements Comparable<BTCETradeHistoryResult>{

  private final String pair;
  private final Type type;
  private final BigDecimal amount;
  private final BigDecimal rate;
  private final Long orderId;
  /**
   * reflects who created original order. True means that you opened the order and then someone completely bought/sold it. False means you bought/sold
   * from someone else's order.
   */
  private final int isYourOrder;
  private final Long timestamp;

  private Long id;

  /**
   * Constructor
   * 
   * @param timestamp
   * @param isYourOrder
   * @param orderId
   * @param rate
   * @param amount
   * @param type
   * @param pair
   */
  public BTCETradeHistoryResult(@JsonProperty("timestamp") Long timestamp, @JsonProperty("is_your_order") int isYourOrder,
      @JsonProperty("rate") BigDecimal rate, @JsonProperty("amount") BigDecimal amount, @JsonProperty("order_id") Long orderId,
      @JsonProperty("type") Type type, @JsonProperty("pair") String pair) {

    this.timestamp = timestamp;
    this.isYourOrder = isYourOrder;
    this.orderId = orderId;
    this.rate = rate;
    this.amount = amount;
    this.type = type;
    this.pair = pair;
  }

  public String getPair() {

    return pair;
  }

  public Type getType() {

    return type;
  }

  public BigDecimal getAmount() {

    return amount;
  }

  public BigDecimal getRate() {

    return rate;
  }

  public Long getTimestamp() {

    return timestamp;
  }

  public Long getOrderId() {

    return orderId;
  }

  public boolean isYourOrder() {

    return isYourOrder == 1;
  }

  public Long getId() {

    return id;
  }

  public void setId(Long newId) {

    this.id = newId;
  }

  @Override
  public String toString() {

    return MessageFormat.format("BTCEOwnTrade[pair=''{0}'', type={1}, amount={2}, rate={3}, timestamp={4}, orderId={5}, isYourOrder={6}]", pair, type, amount, rate, timestamp, orderId,
        isYourOrder);
  }

  public static enum Type {
    buy, sell
  }

  @Override
  public int compareTo(BTCETradeHistoryResult other) {
    //compare name
    if (other == null || other.id == null)
      return 1;
    if (this.id == null)
      return -1;
    return this.id.compareTo(other.id);
  }
}
