package com.fusetest.testing.util;

import java.util.UUID;

import org.apache.camel.Exchange;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenerateID {

    private static final Logger log = LoggerFactory.getLogger(GenerateID.class);

    public void process(String input, Exchange exchange) throws Exception {
        try {

            String str =String.valueOf(exchange.getProperty("timestamp", Long.class));
            UUID uuid = UUID.randomUUID();
            log.info("Convert Timestamp to String: \n" + str);
            exchange.setProperty("uuid", uuid);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
