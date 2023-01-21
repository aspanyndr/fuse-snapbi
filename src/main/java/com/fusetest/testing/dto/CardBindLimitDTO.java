package com.fusetest.testing.dto;

import com.fusetest.testing.pojo.AdditionalInfo;

import java.io.Serializable;

public class CardBindLimitDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String partnerReferenceNo;
    private String bankAccountNo;
    private String bankCardNo;
    private String limit;
    private String bankCardToken;
    private String otp;
    private AdditionalInfo additionalInfo;

    public String getPartnerReferenceNo() {
        return partnerReferenceNo;
    }

    public void setPartnerReferenceNo(String partnerReferenceNo) {
        this.partnerReferenceNo = partnerReferenceNo;
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo;
    }

    public String getBankCardNo() {
        return bankCardNo;
    }

    public void setBankCardNo(String bankCardNo) {
        this.bankCardNo = bankCardNo;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getBankCardToken() {
        return bankCardToken;
    }

    public void setBankCardToken(String bankCardToken) {
        this.bankCardToken = bankCardToken;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public AdditionalInfo getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(AdditionalInfo additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
