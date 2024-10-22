package com.parmarstudios.radio.radiobrowser;

import java.util.Map;

/**
 * Immutable paging configuration.
 * The paging is used to address a sub list that can be retrieved in
 * one logical page. This enables client to iterate through a
 * long list without needing to store the whole result in memory.
 *
 * @author Manish Parmar
 * @see Limit
 */
public class Paging extends Parameter {

    public static final Paging DEFAULT_START = new Paging(0, 64);

    private final int offset;
    private final int limit;

    /**
     * Creates a new paging. This method is private.
     *
     * @param myOffset the offset to use.
     * @param myLimit  the limit to use.
     * @throws IllegalArgumentException if limit or offset are wrong.
     * @see #at(int, int)
     */
    private Paging(final int myOffset, final int myLimit) {
        if (myOffset < 0) {
            throw new IllegalArgumentException(
                    "Offset is " + myOffset + ", but must be >= 0");
        }
        if (myLimit <= 0) {
            throw new IllegalArgumentException(
                    "Limit is " + myLimit + ", but must be > 0");
        }

        this.offset = myOffset;
        this.limit = myLimit;
    }

    public int getOffset() {
        return offset;
    }


    public int getLimit() {
        return limit;
    }

    /**
     * Creates a new paging at the given offset and limit.
     *
     * @param offset the positive offset of the page.
     * @param limit  the maximum number of entries.
     * @return the paging instance created.
     */
    public static Paging at(final int offset, final int limit) {
        return new Paging(offset, limit);
    }

    /**
     * Address the previous paging.
     * Will never go beyond offset 0.
     *
     * @return returns the paging at {@code offset - limit} and keeps the
     * {@code limit}. Will return {@code 0} if going beyond offset 0.
     */
    public Paging previous() {
        int newOffset = offset - limit;
        if (newOffset < 0) {
            newOffset = 0;
        }
        return new Paging(newOffset, limit);
    }

    /**
     * Address the next paging.
     *
     * @return returns the paging at {@code offset + limit} and keeps the
     * {@code limit}.
     */
    public Paging next() {
        return new Paging(offset + limit, limit);
    }

    @Override
    protected void apply(final Map<String, String> requestParams) {
        requestParams.put("limit",
                Integer.toString(getLimit()));
        requestParams.put("offset",
                Integer.toString(getOffset()));
    }
}
