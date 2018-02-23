package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 23/2/18.
 */

public class GetPrimiumFragment extends MainFragment {
    public static GetPrimiumFragment newInstance() {

        Bundle args = new Bundle();

        GetPrimiumFragment fragment = new GetPrimiumFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        ((MainActivity)getActivity()).setActionBarTitle("");
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_get_primium);
        viewStub.inflate();
        return v;
    }
}
