package com.credosys.solutions.secrete.world;

import android.app.Application;

/**
 * Created by win7 on 02-Feb-18.
 */

public class MainApplication extends Application {
    private static final MainApplication ourInstance = new MainApplication();
    private boolean diary=false;
    private MainActivity mainActivity;
    static MainApplication getInstance() {
        return ourInstance;
    }
    public MainActivity getMainActivity() {
        return mainActivity;
    }

    public boolean isDiary() {
        return diary;
    }

    public void setDiary(boolean diary) {
        this.diary = diary;
    }

    public void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    public MainApplication() {}
}
