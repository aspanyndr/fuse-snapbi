package com.fusetest.testing.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import com.fusetest.testing.pojo.AdditionalInfo;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class BalanceInquiryDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Length(min = 3, max = 64)
    private String partnerReferenceNo;
    @NotEmpty
    @Length(min = 3, max = 128)
    private String bankCardToken;
    @NotEmpty
    @Length(min = 3, max = 16)
    private String accountNo;
    private List<String> balanceTypes = null;
    @Valid
    private AdditionalInfo additionalInfo;

    public String getPartnerReferenceNo() {
        return partnerReferenceNo;
    }
    public void setPartnerReferenceNo(String partnerReferenceNo) {
        this.partnerReferenceNo = partnerReferenceNo;
    }
    public String getBankCardToken() {
        return bankCardToken;
    }
    public void setBankCardToken(String bankCardToken) {
        this.bankCardToken = bankCardToken;
    }
    public String getAccountNo() {
        return accountNo;
    }
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
    public List<String> getBalanceTypes() {
        return balanceTypes;
    }
    public void setBalanceTypes(List<String> balanceTypes) {
        this.balanceTypes = balanceTypes;
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
