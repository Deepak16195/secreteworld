package com.credosys.solutions.secrete.world.Utility;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by credosys on 10/3/18.
 */

public class CommonMessageDialog {
    private static final CommonMessageDialog ourInstance = new CommonMessageDialog();
    public static CommonMessageDialog getInstance() {
        return ourInstance;
    }

    private CommonMessageDialog() {

    }

    public void show(Context context,String msg){
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
