package com.parmarstudios.radio.radiobrowser;


import android.util.Log;

import java.util.List;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A spliterator that iterates over a paged set of entities.
 *
 * @param <T> the element type to return in the spliteration.
 * @author Manish Parmar
 */
class PagingSpliterator<T> extends Spliterators.AbstractSpliterator<T> {
    /**
     * Default page size.
     */
    private static final int FETCH_SIZE_DEFAULT = 128;

    /**
     * The current paging.
     */
    private Paging logicalPage;

    /**
     * The current page data.
     */
    private List<T> currentData;

    /**
     * Current index to {@linkplain #currentData}.
     */
    private int currentDataIndex = 0;

    /**
     * The function for getting the specified page.
     */
    private final Function<Paging, List<T>> fetchPage;

    /**
     * The optional view boundary of the paging. Paging will happen in this
     * range if it is set.
     */
    private Paging view;

    /**
     * Whether this spliterator is at the end of the list.
     */
    private boolean endOfList;

    /**
     * Creates a new instance.
     *
     * @param fetchPageFunction the function for fetching the specified
     *                          page.
     * @param view              optional view boundary of the spliterator. This is the offset and limit range in
     *                          what the spliterator is returning elements.
     */
    PagingSpliterator(final Function<Paging, List<T>> fetchPageFunction, final Paging view) {
        super(Long.MAX_VALUE, 0);
        logicalPage = Paging.at(0, FETCH_SIZE_DEFAULT);
        this.fetchPage = fetchPageFunction;
        this.currentData = null;
        this.view = view;
        this.endOfList = false;
    }

    /**
     * Loads the page given in {@link #logicalPage}.
     */
    private void loadPage() {

        Paging physicalPage = null;
        // do we have a view?
        if (view != null) {
            boolean lastPage = logicalPage.getOffset() + FETCH_SIZE_DEFAULT >= view.getLimit();

            int fetchLimit = FETCH_SIZE_DEFAULT;
            // last page has a hard restriction
            if (lastPage) {
                fetchLimit = Math.min(FETCH_SIZE_DEFAULT, view.getLimit() - logicalPage.getOffset());
                if (fetchLimit <= 0) {
                    fetchLimit = 0;
                    endOfList = true;
                }
            }

            if (fetchLimit > 0) {
                physicalPage = Paging.at(
                        view.getOffset() + logicalPage.getOffset(), fetchLimit);
            }
        } else {
            physicalPage = logicalPage;
        }

        Log.d(this.getClass().getSimpleName(), "Loading logical page " + logicalPage + ", physical page " + physicalPage + ", view " + view);
        if (physicalPage != null) {
            currentData = fetchPage.apply(physicalPage);
            Log.d(this.getClass().getSimpleName(), "Elements in loaded page: " + currentData.size());
            currentDataIndex = 0;
            if (currentData.isEmpty()) {
                endOfList = true;
            }
        }
    }

    @Override
    public boolean tryAdvance(final Consumer<? super T> action) {
        boolean hasMore = !endOfList;

        // has no data -> load
        if (currentData == null && !endOfList) {
            loadPage();
        }

        // end of page -> increment, load
        if (currentData != null &&
                !endOfList &&
                currentDataIndex >= currentData.size()) {
            logicalPage = logicalPage.next();
            loadPage();
        }

        // in page -> return element
        if (currentData != null && currentDataIndex < currentData.size()) {
            T element = currentData.get(currentDataIndex);
            action.accept(element);
            currentDataIndex++;
            hasMore = true;
        }

        return hasMore;
    }
}