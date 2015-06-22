package com.smalaca.gtdtool.systemtests.restclient.dto;

public class ErrorDTO {
    private String type;
    private String url;
    private String reason;
    private int httpStatus;

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getReason() {
        return reason;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public int getHttpStatus() {
        return httpStatus;
    }
}
