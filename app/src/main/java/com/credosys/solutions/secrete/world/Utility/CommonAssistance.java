package com.credosys.solutions.secrete.world.Utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.credosys.solutions.secrete.world.R;
import com.michael.easydialog.EasyDialog;

/**
 * Created by credosys on 5/3/18.
 */

public class CommonAssistance {
    private Context context;
    private View assistanceView;

    public CommonAssistance(Context context, View assistanceView) {
        this.context = context;
        this.assistanceView=assistanceView;
    }

    public void show(){
        new EasyDialog(context)
                // .setLayoutResourceId(R.layout.layout_tip_content_horizontal)//layout resource id
                .setLayout(LayoutInflater.from(context).inflate(R.layout.tooltip_assistance,null,false))
                .setBackgroundColor(context.getResources().getColor(R.color.customRed))
                // .setLocation(new location[])//point in screen
                .setLocationByAttachedView(assistanceView)
                .setMarginLeftAndRight(10,10)
                .setGravity(EasyDialog.GRAVITY_BOTTOM)
                .setAnimationTranslationShow(EasyDialog.DIRECTION_Y, 1000, 600, 100, -50, 50, 0)
                .setAnimationAlphaShow(1000, 0.3f, 1.0f)
                .setAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 500, 0, 800)
                .setAnimationAlphaDismiss(500, 1.0f, 0.0f)
                .setTouchOutsideDismiss(true)
                .setMatchParent(true)
                .setMarginLeftAndRight(24, 24)
                .setOutsideColor(context.getResources().getColor(R.color.transparent))
                .show();
    }
}
// .setAnimationTranslationShow(EasyDialog.DIRECTION_Y, 1000, -600, 100, -50, 50, 0)
//         .setAnimationTranslationDismiss(EasyDialog.DIRECTION_Y, 500, -50, 800)