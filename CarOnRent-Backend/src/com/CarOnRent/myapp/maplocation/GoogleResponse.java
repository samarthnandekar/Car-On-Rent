package com.CarOnRent.myapp.maplocation;

import org.codehaus.jackson.annotate.JsonIgnore;

public class GoogleResponse {

	@JsonIgnore
    private Result[] results;

    private String status;

    public Result[] getResults() {
        return results;
    }

    public void setResults(Result[] results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
