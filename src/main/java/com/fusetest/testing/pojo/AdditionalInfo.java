package com.fusetest.testing.pojo;


import java.io.Serializable;

public class AdditionalInfo implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private String deviceId;
    private String channel;

    public String getDeviceId() {
        return deviceId;
    }
    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getChannel() {
        return channel;
    }
    public void setChannel(String channel) {
        this.channel = channel;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    @Override
    public String toString() {
        return "RegLimitAdditionalInfo [deviceId=" + deviceId + ", channel=" + channel + "]";
    }



}

