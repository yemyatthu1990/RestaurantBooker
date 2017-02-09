package com.yemyatthu.restaurantbooker.presentation.model;

/**
 * Created by Ye Myat Thu on 2/8/2017.
 */



public class TownshipModel {
    private int id;
    private String name;
    private String imageUrl;

    public TownshipModel(){

    }
    public TownshipModel(int id, String name, String imageUrl ){
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

}
