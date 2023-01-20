package com.fusetest.testing.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@PropertySource("classpath:application.properties")
public class GenerateSignature {
    @Value( "${postgre.host}" )
    private String postgreHost;
    @Value( "${postgre.port}" )
    private String postgrePort;
    @Value( "${postgre.db}" )
    private String postgreDb;
    @Value( "${postgre.user}" )
    private String postgreUser;
    @Value( "${postgre.password}" )
    private String postgrePassword;
    @Value( "${postgre.table.partners}" )
    private String postgreTablePartners;
    private static final Logger log = LoggerFactory.getLogger(GenerateSignature.class);

    @Autowired
    private ObjectMapper objectMapper;

    public String getSecret(String appId) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        String secret = "";
        String url = "jdbc:postgresql://"+postgreHost+":"+postgrePort+"/"+postgreDb;
        try {
            Connection con = DriverManager.getConnection(url, postgreUser, postgrePassword);
            pst = con.prepareStatement("SELECT secret FROM "+postgreTablePartners+" where app_id=?");
            pst.setString(1, appId);
            rs = pst.executeQuery();

            while (rs.next()) {
                secret = rs.getString(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            rs.close();
            pst.close();
            log.info(ex.getMessage());
        }
        return secret;
    }

    public void process(String privateKey, Exchange exchange) throws Exception {
        try {
            String secret = this.getSecret(exchange.getProperty("appId").toString());

            // Convert generic POJO to Map
            Map<String, Object> map = objectMapper.convertValue(exchange.getIn().getBody(),
                    new TypeReference<Map<String, Object>>() {
                    });

            if (map.containsKey("signature")) {
                map.remove("signature");
            }

            String[] keys = new String[map.size()];
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                keys[i++] = entry.getKey();
            }
            Arrays.sort(keys);
            StringBuilder stringBuilder = new StringBuilder();
            for (String key : keys) {
                stringBuilder.append(key);
                stringBuilder.append(":");

                if (key.equals("body")) {
                    if (map.get(key) instanceof LinkedHashMap || map.get(key) instanceof ArrayList) {
                        stringBuilder.append(objectMapper.writeValueAsString(map.get(key)).replace(" ", ""));
                        continue;
                    }
                }

                stringBuilder.append(map.get(key));
            }
            stringBuilder.append(secret);
            String str = stringBuilder.toString();
            str = stringBuilder.toString();

            log.info("String to encrypt: \n" + str);

            String signature = DigestUtils.md5Hex(str).toUpperCase();
            exchange.setProperty("signature", signature);

            // Generate Final Payload
            //exchange.getIn().getBody(Payload.class).setSignature(signature);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

