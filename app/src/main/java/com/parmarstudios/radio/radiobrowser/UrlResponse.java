package com.parmarstudios.radio.radiobrowser;

import java.util.UUID;


/**
 * API response from the radio browser API.
 *
 * @author Manish Parmar
 * @see <a href="https://at1.api.radio-browser.info/">API documentation</a>
 */

class UrlResponse {
    /**
     * Whether this operation went ok.
     */
    private boolean ok;

    /**
     * The error message of this operation.
     */
    private String message;

    /**
     * The uuid of the referenced entity.
     */
    private UUID uuid;

    /**
     * The name of the referenced entity.
     */
    private String name;

    /**
     * The url of the referenced entity.
     */
    private String url;

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}