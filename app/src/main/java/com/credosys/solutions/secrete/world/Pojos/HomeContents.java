package com.credosys.solutions.secrete.world.Pojos;

/**
 * Created by win7 on 23-Dec-17.
 */

public class HomeContents {
    private String name;
    private String title;
    private String subtitle;
    private String lable;


    public HomeContents(String name, String title, String subtitle){
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
    }
    public HomeContents(String name, String title, String subtitle,String lable) {
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
        this.lable=lable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }
}
