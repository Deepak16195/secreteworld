package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 01-Feb-18.
 */

public class Navigation {
    String strNav;
    int img;

    public Navigation(String strNav, int img) {
        this.strNav = strNav;
        this.img = img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getStrNav() {
        return strNav;
    }

    public void setStrNav(String strNav) {
        this.strNav = strNav;
    }
}
