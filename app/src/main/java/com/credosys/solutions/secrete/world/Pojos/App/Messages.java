package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 12-Jan-18.
 */

public class Messages {
    private String name;
    private String content;
private int img;
    public Messages(String name, String content,int img) {
        this.name = name;
        this.content = content;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
   }

    public int getImg() {
        return img;
    }
}
