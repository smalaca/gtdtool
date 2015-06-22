package com.smalaca.gtdtool.applicationdomain;

public class ApplicationError {
    private final ApplicationErrorType type;
    private final String url;
    private final String reason;

    public ApplicationError(ApplicationErrorType type, String url, String reason) {
        this.type = type;
        this.url = url;
        this.reason = reason;
    }

    public ApplicationErrorType getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public String getReason() {
        return reason;
    }
}
