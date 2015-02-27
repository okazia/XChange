package com.xeiam.xchange.btce.v3.dto.trade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.text.MessageFormat;

/**
 * @author Aleksey Kazennov
 */
public class BTCETransHistoryResult implements Comparable<BTCETransHistoryResult> {

  private final Integer type;
  private final BigDecimal amount;
  private final String currency;
  private final String description;
  private final Integer status;
  private final Long timestamp;

  private Long id;
  /**
   * Constructor
   *
   * @param timestamp
   * @param status
   * @param description
   * @param currency
   * @param amount
   * @param type
   */
  public BTCETransHistoryResult(@JsonProperty("timestamp") Long timestamp, @JsonProperty("status") Integer status, @JsonProperty("desc") String description,
                                @JsonProperty("currency") String currency, @JsonProperty("amount") BigDecimal amount,  @JsonProperty("type") Integer type) {

    this.timestamp = timestamp;
    this.currency = currency;
    this.description = description;
    this.status = status;
    this.amount = amount;
    this.type = type;
  }

  public Integer getType() {

    return type;
  }

  public BigDecimal getAmount() {

    return amount;
  }

  public Long getTimestamp() {

    return timestamp;
  }

  public Integer getStatus() {

    return status;
  }

  public String getCurrency() {

    return currency;
  }

  public String getDescription() {

    return description;
  }

  public Long getId() {

    return id;
  }

  public void setId(Long newId) {

    this.id = newId;
  }

  @Override
  public String toString() {
    return MessageFormat.format("BTCEOwnTransaction[type={1}, amount={2}, currency={3}, desc={4}, status={5}, timestamp={6}]", type, amount, currency, description,status, timestamp);
  }

  @Override
  public int compareTo(BTCETransHistoryResult other) {
    //compare name
    if (other == null || other.id == null)
      return 1;
    if (this.id == null)
      return -1;
    return this.id.compareTo(other.id);
  }
}
