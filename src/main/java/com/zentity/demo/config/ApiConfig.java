package com.zentity.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "api")
public class ApiConfig {

    private String headerName = "X-Geo-Key";
    private String key = "fcc0f086be175a03c5b57face2de4f8b8299629b7025afccdd5791c636cd6ab5";

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getHeaderName() {
        return headerName;
    }

    public void setHeaderName(String headerName) {
        this.headerName = headerName;
    }
}
