package com.fusetest.testing.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fusetest.testing.pojo.AdditionalInfo;
import org.hibernate.validator.constraints.Length;


public class B2BAccessTokenDTO implements Serializable  {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Length(min = 3, max = 64)
    @NotNull
    private String grantType;
    @Valid
    private AdditionalInfo additionalInfo;

    public String getGrantType() {
        return grantType;
    }
    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }
    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }
    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }


}

