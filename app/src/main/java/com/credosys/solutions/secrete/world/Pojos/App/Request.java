package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by credosys on 27/2/18.
 */

public class Request {
    int image;
    String title;
    String note;

    public Request(int image, String title, String note) {
        this.image = image;
        this.title = title;
        this.note = note;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
