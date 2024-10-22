package com.parmarstudios.radio.radiobrowser;

/**
 * A tuple parameters for creating API connections to the
 * radio browser API
 */
public class ConnectionParams {

    /**
     * The URL of the radio browser API.
     * Must not be {@code null}
     */
    private String apiUrl;

    /**
     * The timeout for connect and read requests in milliseconds.
     * Must be greater than zero
     */
    private int timeout;

    /**
     * The user agent to use for identifying with the API
     */
    private String userAgent;

    /**
     * The Proxy URI to use. May be {@code null}
     */
    private String proxyUri;

    /**
     * The Proxy user to use. May be {@code null}
     */
    private String proxyUser;

    /**
     * The Proxy password to use. May be {@code null}
     */
    private String proxyPassword;

    /**
     * The wait interval between two retries.
     */
    private long retryInterval = 1000;

    /**
     * The number of retries on error.
     */
    private int retries = 3;

    /**
     * Checks the parameters.
     *
     * @throws IllegalArgumentException if parameters are invalid.
     */

    private ConnectionParams() {

    }

    private ConnectionParams(Builder builder) {
        this.apiUrl = builder.apiUrl;
        this.timeout = builder.timeout;
        this.userAgent = builder.userAgent;
        this.proxyUri = builder.proxyUri;
        this.proxyUser = builder.proxyUser;
        this.proxyPassword = builder.proxyPassword;
        this.retryInterval = builder.retryInterval;
        this.retries = builder.retries;
    }

    void check() {
        if (apiUrl == null) {
            throw new IllegalArgumentException(
                    "apiUrl must not be null");
        }

        if (timeout <= 0) {
            throw new IllegalArgumentException(
                    "timeout must be > 0, but is "
                            + getTimeout());
        }

        if (retries <= 0) {
            throw new IllegalArgumentException(
                    "retries must be > 0, but is "
                            + getRetries());
        }

        if (retryInterval <= 0) {
            throw new IllegalArgumentException(
                    "retryInterval must be > 0, but is "
                            + getRetryInterval());
        }

        if (userAgent == null) {
            throw new IllegalArgumentException(
                    "userAgent must not be null");
        }

        if (proxyUri != null) {
            if (proxyUser != null && proxyPassword == null) {
                throw new IllegalArgumentException(
                        "proxyUser was given, but not a proxyPassword");
            }
            if (proxyUser == null && proxyPassword != null) {
                throw new IllegalArgumentException(
                        "proxyUser was not given, but a proxyPassword");
            }
        }
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public int getTimeout() {
        return timeout;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public String getProxyUri() {
        return proxyUri;
    }

    public String getProxyUser() {
        return proxyUser;
    }

    public String getProxyPassword() {
        return proxyPassword;
    }

    public long getRetryInterval() {
        return retryInterval;
    }

    public int getRetries() {
        return retries;
    }

    public static class Builder {
        /**
         * The URL of the radio browser API.
         * Must not be {@code null}
         */
        private String apiUrl;

        /**
         * The timeout for connect and read requests in milliseconds.
         * Must be greater than zero
         */
        private int timeout;

        /**
         * The user agent to use for identifying with the API
         */
        private String userAgent;

        /**
         * The Proxy URI to use. May be {@code null}
         */
        private String proxyUri;

        /**
         * The Proxy user to use. May be {@code null}
         */
        private String proxyUser;

        /**
         * The Proxy password to use. May be {@code null}
         */
        private String proxyPassword;

        /**
         * The wait interval between two retries.
         */
        private long retryInterval = 1000;

        /**
         * The number of retries on error.
         */
        private int retries = 3;

        public Builder setApiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
        }

        public Builder setProxyUri(String proxyUri) {
            this.proxyUri = proxyUri;
            return this;
        }

        public Builder setProxyUser(String proxyUser) {
            this.proxyUser = proxyUser;
            return this;
        }

        public Builder setProxyPassword(String proxyPassword) {
            this.proxyPassword = proxyPassword;
            return this;
        }

        public Builder setRetryInterval(long retryInterval) {
            this.retryInterval = retryInterval;
            return this;
        }

        public Builder setRetries(int retries) {
            this.retries = retries;
            return this;
        }

        public ConnectionParams build() {
            return new ConnectionParams(this);
        }
    }

}
