package com.parmarstudios.radio.radiobrowser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import kotlin.collections.ArrayDeque;

/**
 * Representation of a Radio Station
 *
 * @author Manish Parmar
 */
public class Station extends Parameter {

    /**
     * A globally unique identifier for the change
     * of the station information.
     */
    private UUID changeUUID;

    /**
     * A globally unique identifier for the station.
     */
    private UUID stationUUID;

    /**
     * The name of the station.
     */
    private String name;

    /**
     * The URL of the stream.
     */
    private String url;

    /**
     * An automatically "resolved" stream URL.
     */
    private String urlResolved;

    /**
     * The URL of the stations' homepage.
     */
    private String homepage;

    /**
     * The URL of the stations' favicon.
     */
    private String favicon;

    /**
     * The tags for this station as a list.
     * The comma separated version can be obtained using
     * {@link #getTags()}.
     *
     * @see #getTags()
     */
    private List<String> tagList = new ArrayList<>();

    /**
     * Official country codes according to ISO 3166-1 alpha-2.
     */
    private String countryCode;

    /**
     * The state this station is located at.
     */
    private String state;

    /**
     * The languages of this station as a list.
     * The comma separated version can be obtained using
     * {@link #getLanguage()}.
     *
     * @see #getLanguage()
     */
    private List<String> languageList = new ArrayList<>();

    /**
     * The votes for this station.
     */
    private Integer votes;

    /**
     * The codec used for the stream.
     */
    private String codec;

    /**
     * The bitrate used for the stream.
     */
    private Integer bitrate;

    /**
     * Mark if this stream is using HLS distribution or non-HLS.
     */
    private String hls;

    /**
     * The current online/offline state of this stream.
     */
    private Integer lastcheckok;

    /**
     * The last time when any Radio-Browser server checked
     * the online state of this stream.
     */
    private Date lastchecktime;

    /**
     * The last time when the stream was checked for
     * the online status with a positive result.
     */
    private Date lastcheckoktime;

    /**
     * The last time when this server checked the online state
     * and the metadata of this stream.
     */
    private Date lastlocalchecktime;

    /**
     * The time of the last click recorded for this stream.
     */
    private Date clicktimestamp;

    /**
     * Clicks within the last 24 hours.
     */
    private Integer clickcount;

    /**
     * The difference of the click counts within the last 2 days.
     */
    private Integer clicktrend;

    /**
     * Timestamp of the last change of the stations' data.
     */
    private Date lastchangetime;

    /**
     * Geo latitude of the station.
     */
    private Double geoLatitude;

    /**
     * Geo longitude of the station.
     */
    private Double geoLongitude;

    /**
     * Is true, if the stream owner does
     * provide extended information as HTTP headers
     * which override the information in the database.
     */
    private Boolean hasExtendedInfo;

    /**
     * JSON getter for the {@link #tagList}.
     * You would probably prefer using the {@link #tagList} property.
     *
     * @return comma separated tag names.
     * @see #setTags(String)
     */
    public String getTags() {
        return String.join(",", tagList);
    }

    /**
     * JSON setter for the {@link #tagList}.
     * You would probably prefer using the {@link #tagList} property.
     *
     * @param commaTags comma separated tag names.
     * @see #getTags()
     */
    public void setTags(final String commaTags) {
        tagList = Arrays.asList(commaTags.split(","));
    }

    /**
     * JSON setter for {@link #languageList}.
     * You would probably prefer using the {@link #languageList} property.
     *
     * @return comma separated languages.
     * @see #setLanguage(String)
     */
    public String getLanguage() {
        return String.join(",", languageList);
    }

    /**
     * JSON setter for {@link #languageList}.
     * You would probably prefer using the {@link #languageList} property.
     *
     * @param commaLanguages comma separated languages.
     * @see #getLanguage()
     */
    public void setLanguage(final String commaLanguages) {
        languageList = Arrays.asList(commaLanguages.split(","));
    }

    @Override
    public String toString() {
        return "Station{" + "name=" + name + ", url=" + url + '}';
    }


    @Override
    protected void apply(final Map<String, String> requestParams) {
        requestParams.put("name",
                getName());
        requestParams.put("url",
                getUrl());
        if (getHomepage() != null) {
            requestParams.put("homepage",
                    getHomepage());
        }
        if (getFavicon() != null) {
            requestParams.put("favicon",
                    getFavicon());
        }
        if (getCountryCode() != null) {
            requestParams.put("countrycode",
                    getCountryCode());
        }
        if (getState() != null) {
            requestParams.put("state",
                    getState());
        }
        if (getLanguage() != null) {
            requestParams.put("language",
                    getLanguage());
        }
        if (getTagList() != null) {
            requestParams.put("tagList", getTags());
        }
        if (getGeoLatitude() != null) {
            requestParams.put("geo_lat", getGeoLatitude().toString());
        }
        if (getGeoLongitude() != null) {
            requestParams.put("geo_long", getGeoLongitude().toString());
        }

    }

    public UUID getChangeUUID() {
        return changeUUID;
    }

    public void setChangeUUID(UUID changeUUID) {
        this.changeUUID = changeUUID;
    }

    public UUID getStationUUID() {
        return stationUUID;
    }

    public void setStationUUID(UUID stationUUID) {
        this.stationUUID = stationUUID;
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

    public String getUrlResolved() {
        return urlResolved;
    }

    public void setUrlResolved(String urlResolved) {
        this.urlResolved = urlResolved;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getFavicon() {
        return favicon;
    }

    public void setFavicon(String favicon) {
        this.favicon = favicon;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getLanguageList() {
        return languageList;
    }

    public void setLanguageList(List<String> languageList) {
        this.languageList = languageList;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public String getCodec() {
        return codec;
    }

    public void setCodec(String codec) {
        this.codec = codec;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public Integer getLastcheckok() {
        return lastcheckok;
    }

    public void setLastcheckok(Integer lastcheckok) {
        this.lastcheckok = lastcheckok;
    }

    public Date getLastchecktime() {
        return lastchecktime;
    }

    public void setLastchecktime(Date lastchecktime) {
        this.lastchecktime = lastchecktime;
    }

    public Date getLastcheckoktime() {
        return lastcheckoktime;
    }

    public void setLastcheckoktime(Date lastcheckoktime) {
        this.lastcheckoktime = lastcheckoktime;
    }

    public Date getLastlocalchecktime() {
        return lastlocalchecktime;
    }

    public void setLastlocalchecktime(Date lastlocalchecktime) {
        this.lastlocalchecktime = lastlocalchecktime;
    }

    public Date getClicktimestamp() {
        return clicktimestamp;
    }

    public void setClicktimestamp(Date clicktimestamp) {
        this.clicktimestamp = clicktimestamp;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    public Integer getClicktrend() {
        return clicktrend;
    }

    public void setClicktrend(Integer clicktrend) {
        this.clicktrend = clicktrend;
    }

    public Date getLastchangetime() {
        return lastchangetime;
    }

    public void setLastchangetime(Date lastchangetime) {
        this.lastchangetime = lastchangetime;
    }

    public Double getGeoLatitude() {
        return geoLatitude;
    }

    public void setGeoLatitude(Double geoLatitude) {
        this.geoLatitude = geoLatitude;
    }

    public Double getGeoLongitude() {
        return geoLongitude;
    }

    public void setGeoLongitude(Double geoLongitude) {
        this.geoLongitude = geoLongitude;
    }

    public Boolean getHasExtendedInfo() {
        return hasExtendedInfo;
    }

    public void setHasExtendedInfo(Boolean hasExtendedInfo) {
        this.hasExtendedInfo = hasExtendedInfo;
    }

}
