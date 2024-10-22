package com.parmarstudios.radio.radiobrowser;

/** The mode to search for.
 * @see RadioBrowser#listStationsBy(SearchMode, String, Parameter...)
 * @author Manish Parmar
 * */
public enum SearchMode {
    /**
     * Search by UUID.
     */
    BYUUID,
    /**
     * Search by name.
     */
    BYNAME,
    /**
     * Search by exact name.
     */
    BYNAMEEXACT,
    /**
     * Search by codec.
     */
    BYCODEC,
    /**
     * Search by exact codec.
     */
    BYCODECEXACT,
    /**
     * Search by ISO 3166-1 alpha-2 country code.
     */
    BYCOUNTRYCODEEXACT,
    /**
     * Search by state.
     */
    BYSTATE,
    /**
     * Search by exact state.
     */
    BYSTATEEXACT,
    /**
     * Search by language.
     */
    BYLANGUAGE,
    /**
     * Search by exact language.
     */
    BYLANGUAGEEXACT,
    /**
     * Search by tag.
     */
    BYTAG,
    /**
     * Search by exact tag.
     */
    BYTAGEXACT
}
