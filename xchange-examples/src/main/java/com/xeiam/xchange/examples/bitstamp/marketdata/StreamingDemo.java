package com.xeiam.xchange.examples.bitstamp.marketdata;

import com.xeiam.xchange.Exchange;
import com.xeiam.xchange.ExchangeFactory;
import com.xeiam.xchange.bitstamp.BitstampExchange;
import com.xeiam.xchange.bitstamp.service.streaming.BitstampStreamingConfiguration;
import com.xeiam.xchange.dto.marketdata.Trade;
import com.xeiam.xchange.service.streaming.ExchangeEvent;
import com.xeiam.xchange.service.streaming.StreamingExchangeService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Demonstrate requesting Depth at Bitstamp
 */
public class StreamingDemo {

    public static void main(String[] args) throws IOException {

        // Use the factory to get Bitstamp exchange API using default settings
        Exchange bitstamp = ExchangeFactory.INSTANCE.createExchange(BitstampExchange.class.getName());
        BitstampStreamingConfiguration streamCfg = new BitstampStreamingConfiguration();
        // Interested in the public streaming market data feed (no authentication)
        StreamingExchangeService streamService = bitstamp.getStreamingExchangeService(streamCfg);
        streamService.connect();
        go(streamService);
        streamService.disconnect();
    }

    private static void go(StreamingExchangeService streamService) throws IOException {

        try {
            Long fullTimestamp = null;
            Long diffTimestamp = null;
            for (int i = 0; i < 1000; i++) {
                ExchangeEvent evt = streamService.getNextEvent(1, TimeUnit.SECONDS);
                if (evt == null) {
                    System.out.println("No message");
                    continue;
                }
                switch (evt.getEventType()) {
                    case SUBSCRIBE_ORDERS: {
                        //System.out.println(((OrderBook) evt.getPayload()).toString());
                        System.out.println(fullTimestamp == null ? "first time" : System.currentTimeMillis() - fullTimestamp);
                        fullTimestamp = System.currentTimeMillis();
                        break;
                    }
                    case DEPTH:
                    /*
                        System.out.println(((OrderBook) evt.getPayload()).toString());
                        System.out.println(diffTimestamp == null
                                ? String.format("first diff time. %s", ((OrderBook)evt.getPayload()).getAsks().size() + ((OrderBook)evt.getPayload()).getBids().size())
                                : String.format("update time %s. %s", System.currentTimeMillis() - diffTimestamp, ((OrderBook)evt.getPayload()).getAsks().size() + ((OrderBook)evt.getPayload()).getBids().size())
                                );
                        diffTimestamp = System.currentTimeMillis();
                        */
                        break;
                    case TRADE:
                        System.out.println(((Trade) evt.getPayload()).toString());
                        break;
                    default:
                        break;
                }

            }
            System.out.println("Closing Bitstamp stream.");
        } catch (InterruptedException e) {
            e.printStackTrace(System.err);
        }
    }

}
