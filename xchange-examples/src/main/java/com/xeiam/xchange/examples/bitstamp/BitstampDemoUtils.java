package com.xeiam.xchange.examples.bitstamp;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.ExchangeSpecification;
import com.xeiam.xchange.bitstamp.BitstampExchange;

/**
 * @author Matija Mazi
 */
public class BitstampDemoUtils {

  public static Exchange createExchange() {

    ExchangeSpecification exSpec = new BitstampExchange().getDefaultExchangeSpecification();
    exSpec.setUserName("068748");
    exSpec.setApiKey("xTt0m8u0ZbBXHQnPpQv4BsjTamSIGGLO");
    exSpec.setSecretKey("XH5gUXuJqn7pNBCsDVWi0AfT5O0s0FhL");
    return ExchangeFactory.INSTANCE.createExchange(exSpec);
  }
}
