package com.credosys.solutions.secrete.world.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.WindowManager;

/**
 * Created by win7 on 13-Feb-18.
 */

public class MainFragment extends Fragment /*implements OnBackPressListener*/ {
//
//    @Override
//    public boolean onBackPressed() {
//        return new BackPressImpl(this).onBackPressed();
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        super.onCreate(savedInstanceState);
    }
}
