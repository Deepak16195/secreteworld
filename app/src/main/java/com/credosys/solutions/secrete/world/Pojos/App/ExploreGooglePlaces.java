package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 30-Dec-17.
 */

public class ExploreGooglePlaces {
    String places;
    int count;
    int color;

    public ExploreGooglePlaces(String places, int count,int color) {
        this.places = places;
        this.count = count;
        this.color=color;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
