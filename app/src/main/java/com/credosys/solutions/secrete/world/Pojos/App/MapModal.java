package com.credosys.solutions.secrete.world.Pojos.App;

import android.widget.RatingBar;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by credosys on 17/3/18.
 */

public class MapModal {
    private String title;
    private String subTitle;
    private String name;
    private int ratingBar;
    private LatLng latLng;
    public MapModal(LatLng latLng){
        this.latLng=latLng;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRatingBar() {
        return ratingBar;
    }

    public void setRatingBar(int ratingBar) {
        this.ratingBar = ratingBar;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }
}
