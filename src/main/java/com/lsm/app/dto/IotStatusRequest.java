package com.lsm.app.dto;

public class IotStatusRequest {
    private String alertid;
    private String statecode;
    private String reason;

    public String getAlertid() {
        return alertid;
    }

    public void setAlertid(String alertid) {
        this.alertid = alertid;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
