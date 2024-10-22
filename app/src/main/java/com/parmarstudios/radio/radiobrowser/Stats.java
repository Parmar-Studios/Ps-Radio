package com.parmarstudios.radio.radiobrowser;

/**
 * Representation of an api endpoint statistics.
 * @author Manish Parmar
 */

public class Stats {

    /**
     * The supported version
     **/
    private Integer supportedVersion;

    /**
     * The version of the API.
     **/
    private String softwareVersion;

    /**
     * The status, should be "OK".
     **/
    private String status;

    /**
     * Number of stations stored on the server.
     **/
    private Integer stations;

    /**
     * The number of broken stations.
     */
    private Integer stationsBroken;

    /**
     * The number of tags
     */
    private Integer tags;

    /**
     * The number of clicks in the last hour.
     */
    private Integer clicksLastHour;

    /**
     * The number of clicks in last 24 hours.
     */
    private Integer clicksLastDay;

    /**
     * The number of languages.
     */
    private Integer languages;

    /**
     * The number of countries.
     */
    private Integer countries;


    public Integer getSupportedVersion() {
        return supportedVersion;
    }

    public void setSupportedVersion(Integer supportedVersion) {
        this.supportedVersion = supportedVersion;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStations() {
        return stations;
    }

    public void setStations(Integer stations) {
        this.stations = stations;
    }

    public Integer getStationsBroken() {
        return stationsBroken;
    }

    public void setStationsBroken(Integer stationsBroken) {
        this.stationsBroken = stationsBroken;
    }

    public Integer getTags() {
        return tags;
    }

    public void setTags(Integer tags) {
        this.tags = tags;
    }

    public Integer getClicksLastHour() {
        return clicksLastHour;
    }

    public void setClicksLastHour(Integer clicksLastHour) {
        this.clicksLastHour = clicksLastHour;
    }

    public Integer getClicksLastDay() {
        return clicksLastDay;
    }

    public void setClicksLastDay(Integer clicksLastDay) {
        this.clicksLastDay = clicksLastDay;
    }

    public Integer getLanguages() {
        return languages;
    }

    public void setLanguages(Integer languages) {
        this.languages = languages;
    }

    public Integer getCountries() {
        return countries;
    }

    public void setCountries(Integer countries) {
        this.countries = countries;
    }
}
