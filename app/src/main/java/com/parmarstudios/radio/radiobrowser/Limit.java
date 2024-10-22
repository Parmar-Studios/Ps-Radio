package com.parmarstudios.radio.radiobrowser;


/**
 * Immutable limit configuration.
 * The limit is used to limit the size of a sub list that can be retrieved.
 *
 * @author Manish Parmar
 * @see Paging
 */
public final class Limit {

    /**
     * The total number of elements to process.
     */
    private final int size;

    /**
     * Creates a new paging. This method is private.
     *
     * @param myLimit the limit to use.
     * @throws IllegalArgumentException if limit or offset are wrong.
     * @see #of(int)
     */
    private Limit(final int myLimit) {
        if (myLimit <= 0) {
            throw new IllegalArgumentException(
                    "Limit is " + myLimit + ", but must be > 0");
        }

        this.size = myLimit;
    }

    
    public int getSize() {
        return size;
    }

    /**
     * Creates a new limit with the given number of entries.
     *
     * @param limit the maximum number of entries.
     * @return the limit instance created.
     */
    public static Limit of(final int limit) {
        return new Limit(limit);
    }
}
