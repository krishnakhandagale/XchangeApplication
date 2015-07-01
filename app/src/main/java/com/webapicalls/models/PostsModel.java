package com.webapicalls.models;

/**
 * Created by krishna.khandagale on 6/10/2015.
 */
public class PostsModel {
    String title;
    String description;
    String category;
    String city;
    String locality;
    String state;
    int isExchange;
    int isSell;
    String preferredItem;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getLocality() {
        return locality;
    }
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public int getIsExchange() {
        return isExchange;
    }
    public void setIsExchange(int isExchange) {
        this.isExchange = isExchange;
    }
    public int getIsSell() {
        return isSell;
    }
    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }
    public String getPreferredItem() {
        return preferredItem;
    }
    public void setPreferredItem(String preferredItem) {
        this.preferredItem = preferredItem;
    }


}

