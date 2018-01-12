package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 12-Jan-18.
 */

public class OrderFragment extends Fragment {
    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_orders,null,false);
        ((MainActivity)getActivity()).setActionBarTitle("MY ORDER");
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);
        ((MainActivity)getActivity()).showBackButton(true);
        return v;
    }
}
