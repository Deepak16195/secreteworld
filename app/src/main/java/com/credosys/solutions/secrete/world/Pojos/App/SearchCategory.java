package com.credosys.solutions.secrete.world.Pojos.App;

/**
 * Created by win7 on 05-Jan-18.
 */

public class SearchCategory {
    private String placeNames;
    private int placeNumber;
    private int imgPlaces;
    private boolean isChecked;

    public SearchCategory(String placeNames, int placeNumber) {
        this.placeNames = placeNames;
        this.placeNumber = placeNumber;
    }


    public SearchCategory(String placeNames, int placeNumber, int imgPlaces) {
        this.placeNames = placeNames;
        this.placeNumber = placeNumber;
        this.imgPlaces = imgPlaces;
    }

    public SearchCategory(String placeNames, int placeNumber, int imgPlaces, boolean isChecked) {
        this.placeNames = placeNames;
        this.placeNumber = placeNumber;
        this.imgPlaces = imgPlaces;
        this.isChecked = isChecked;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public int getImgPlaces() {
        return imgPlaces;
    }

    public void setImgPlaces(int imgPlaces) {
        this.imgPlaces = imgPlaces;
    }

    public int getPlaceNumber() {
        return placeNumber;
    }

    public void setPlaceNumber(int placeNumber) {
        this.placeNumber = placeNumber;
    }

    public SearchCategory(String placeNames) {
        this.placeNames = placeNames;
    }

    public String getPlaceNames() {
        return placeNames;
    }

    public void setPlaceNames(String placeNames) {
        this.placeNames = placeNames;
    }
}
