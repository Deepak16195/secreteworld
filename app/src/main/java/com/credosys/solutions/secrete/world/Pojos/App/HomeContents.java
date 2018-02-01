package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 23-Dec-17.
 */

public class HomeContents {
    private String name;
    private String title;
    private String subtitle;
    private String lable;
    private int color;
    private int img;


    public HomeContents(String name, String title, String subtitle, int img){
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
        this.img=img;
    }
    public HomeContents(String name, String title, String subtitle,String lable, int color,int img) {
        this.name = name;
        this.title = title;
        this.subtitle = subtitle;
        this.lable=lable;
        this.color=color;
        this.img=img;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
