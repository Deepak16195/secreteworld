package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by win7 on 23-Dec-17.
 */

public class RequestFragment extends MainFragment {
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static Fragment newInstance() {
        return new RequestFragment();
    }
    public RequestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_request,null,false);
        mainApp.setActionBarTitle("REQUEST");
//        mainApp.setTabLayoutColors(R.color.white, R.color.white, R.color.customBlue, R.color.tab_layout_text, R.color.tab_layout_text);
        mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        mainApp.showBackButton(false);
        return v;
    }
}
