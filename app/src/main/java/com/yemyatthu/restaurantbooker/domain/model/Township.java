package com.yemyatthu.restaurantbooker.domain.model;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */


public class Township {
    private int id;
    private String name;
    private String imageUrl;
    private String lastUpdated;

    public Township(){

    }
    public Township(int id, String name, String imageUrl, String lastUpdated){
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
