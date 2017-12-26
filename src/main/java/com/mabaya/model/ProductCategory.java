package com.mabaya.model;

/**
 * @author Daniil Tyshchenko
 * @version 0.0.1
 * @since 0.0.1
 */
public enum ProductCategory {
    SMART_PHONE("smartPhone"), T_SHIRT("t-Short"), SHOES("shoes");

    private String val;

    ProductCategory(String val) {
        this.val = val;
    }
}
