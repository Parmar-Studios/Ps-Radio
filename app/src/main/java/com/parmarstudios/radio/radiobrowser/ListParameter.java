package com.parmarstudios.radio.radiobrowser;

import androidx.annotation.NonNull;

import java.util.Map;

/**
 * Parameters for list calls.
 *
 * @author Manish Parmar
 */
public class ListParameter extends  Parameter {

    /**
     * The field name to sort by.
     */
    private FieldName order;

    /**
     * Whether to sort in reverse order.
     */
    private Boolean reverseOrder;

    /**
     * Private constructor
     */
    private ListParameter() {

    }

    /**
     * Creates a new instance.
     *
     * @return a new instance.
     */
    public static ListParameter create() {
        return new ListParameter();
    }

    /**
     * Get reverse order;
     *
     * @return reverseOrder
     */
    public Boolean getReverseOrder() {
        return reverseOrder;
    }


    /**
     * Order by the given field name.
     *
     * @param fieldName the field name to order by.
     * @return {@code this} instance.
     */
    public ListParameter order(@NonNull final FieldName fieldName) {
        this.order = fieldName;
        return this;
    }

    /**
     * Switch to reverse order.
     *
     * @param reverse whether to order reverse.
     * @return {@code this} instance.
     */
    public ListParameter reverseOrder(final boolean reverse) {
        this.reverseOrder = reverse;
        return this;
    }

    /**
     * Transfer this list parameter to the passed multi-valued-map.
     *
     * @param requestParams the target of the list params.
     */
    protected void apply(final Map<String, String> requestParams) {
        if (getOrder() != null) {
            requestParams.put("order",
                    getOrder().name().toLowerCase());
        }
        if (getReverseOrder() != null) {
            requestParams.put("reverse",
                    getReverseOrder().toString());
        }
    }

    /**
     * Get order
     * @return order
     */
    public FieldName getOrder() {
        return order;
    }
}
