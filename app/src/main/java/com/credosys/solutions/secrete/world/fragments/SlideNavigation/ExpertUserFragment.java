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

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by Yogesh on 16-Feb-18.
 */

public class ExpertUserFragment extends MainFragment {
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static ExpertUserFragment newInstance() {

        Bundle args = new Bundle();

        ExpertUserFragment fragment = new ExpertUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        mainApp.setActionBarTitle(" ");
        mainApp.showBackButton(true);
        mainApp.setUpTopHeader(R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_expert_user);
         View inflated=viewStub.inflate();

        return v;
    }
}
