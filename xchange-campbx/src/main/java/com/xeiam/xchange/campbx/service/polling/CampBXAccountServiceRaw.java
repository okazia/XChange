package com.xeiam.xchange.campbx.service.polling;

import java.io.IOException;
import java.math.BigDecimal;

import si.mazi.rescu.RestProxyFactory;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.campbx.CampBX;
import com.xeiam.xchange.campbx.dto.CampBXResponse;
import com.xeiam.xchange.campbx.dto.account.MyFunds;

/**
 * @author Matija Mazi
 */
public class CampBXAccountServiceRaw extends CampBXBasePollingService {

  private final CampBX campBX;

  /**
   * Constructor
   *
   * @param exchange
   */
  public CampBXAccountServiceRaw(Exchange exchange) {

    super(exchange);
    this.campBX = RestProxyFactory.createProxy(CampBX.class, exchange.getExchangeSpecification().getSslUri());
  }

  public MyFunds getCampBXAccountInfo() throws IOException {

    MyFunds myFunds = campBX.getMyFunds(exchange.getExchangeSpecification().getUserName(), exchange.getExchangeSpecification().getPassword());
    return myFunds;
  }

  public CampBXResponse withdrawCampBXFunds(BigDecimal amount, String address) throws IOException {

    CampBXResponse campBXResponse = campBX.withdrawBtc(exchange.getExchangeSpecification().getUserName(), exchange.getExchangeSpecification()
        .getPassword(), address, amount);
    return campBXResponse;
  }

  public CampBXResponse requestCampBXBitcoinDepositAddress() throws IOException {

    CampBXResponse campBXResponse = campBX.getDepositAddress(exchange.getExchangeSpecification().getUserName(), exchange.getExchangeSpecification()
        .getPassword());
    return campBXResponse;
  }

}
