package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 23-Dec-17.
 */

public class RequestFragment extends Fragment {

    public static Fragment newInstance() {
        return new RequestFragment();
    }
    public RequestFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_request,null,false);
        return v;
    }
}