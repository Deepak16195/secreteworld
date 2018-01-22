package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 30-Dec-17.
 */

public class ExploreGooglePlaces {
    String places;
    int count;

    public ExploreGooglePlaces(String places, int count) {
        this.places = places;
        this.count = count;
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
}
