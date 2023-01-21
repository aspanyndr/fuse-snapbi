package com.fusetest.testing.dto;

import java.io.Serializable;
import java.util.UUID;

public class B2B2CAccessTokenDTO implements Serializable {


    private static final long serialVersionUID = 1L ;
    private String grantType;
    private String authCode;
    private String refreshToken;

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
