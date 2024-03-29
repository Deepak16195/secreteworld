package com.credosys.solutions.secrete.world;

import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by win7 on 02-Feb-18.
 */

public class MainApplication extends Application {
    private static final MainApplication ourInstance = new MainApplication();
    private boolean diary=false;
    private MainActivity mainActivity;
    public static MainApplication getInstance() {
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
    public void show(Context context, String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        });
        builder.setMessage(msg);
        builder.setCancelable(false);

        builder.create().show();
    }
}
