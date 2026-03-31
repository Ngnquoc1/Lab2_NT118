package com.nhom18.lab2_mobile;

public class Dish {
    private String name;
    private Thumbnail thumbnail;
    private boolean promotion;

    // Constructor, Getter và Setter
    public Dish() {}

    public Dish(String name, Thumbnail thumbnail, boolean promotion) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.promotion = promotion;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Thumbnail getThumbnail() { return thumbnail; }
    public void setThumbnail(Thumbnail thumbnail) { this.thumbnail = thumbnail; }

    public boolean isPromotion() { return promotion; }
    public void setPromotion(boolean promotion) { this.promotion = promotion; }
}