package com.parmarstudios.radio.radiobrowser;

import java.util.Map;

/**
 * A provider for HTTP request parameters.
 *
 * @author Manish Parmar
 */

abstract class InternalParameter {
    /**
     * Applies the parameters stored in this instance to the given
     * request parameters.
     *
     * @param requestParams the parameters to apply to the instance content to.
     */
    protected abstract void apply(Map<String, String> requestParams);

}
