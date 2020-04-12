package com.example.slamjammonitor.Entity;
/**
 * Class Merch present product from the site
 * <b>id</b>, <b>name</b>, <b>price</b>, <b>sizes</b> and <b>src</b> - product information
 * @autor Whatislove118
 */

import java.util.Set;

public class Merch{
    /** id field */
    private String id;
    /** name field */
    private String name;
    /** price field */
    private Double price;
    /** sizes field */
    private Set<String> sizes;
    /** src for image field */
    private  String src;

    public Merch(){

    }
    /**
     * Function to get the field value {@link Merch#src}
     * @return src for image
     */
    public String getSrc() {
        return src;
    }
    /**
     * Function to set the field value {@link Merch#src}
     * @param src - url for the image
     */
    public void setSrc(String src) {
        this.src = src;
    }
    /**
     * Function to get the field value {@link Merch#id}
     * @return id of the product
     */
    public String getId() {
        return id;
    }
    /**
     * Function to set the field value {@link Merch#id}
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Function to get the field value {@link Merch#name}
     * @return name of the product
     */
    public String getName() {
        return name;
    }
    /**
     * Function to set the field value {@link Merch#name}
     * @param name - product's name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Function to get the field value {@link Merch#price}
     * @return product's price
     */
    public Double getPrice() {
        return price;
    }
    /**
     * Function to set the field value {@link Merch#price}
     * @param price - product's price
     */
    public void setPrice(Double price) {
        this.price = price;
    }
    /**
     * Function to get the field value {@link Merch#sizes}
     * @return product's sizes
     */
    public Set<String> getSizes() {
        return sizes;
    }
    /**
     * Function to set the field value {@link Merch#sizes}
     * @param sizes - product's sizes
     */
    public void setSizes(Set<String> sizes) {
        this.sizes = sizes;
    }
}

