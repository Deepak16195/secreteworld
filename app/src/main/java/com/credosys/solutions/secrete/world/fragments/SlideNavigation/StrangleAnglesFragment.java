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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.Utility.CommonAssistance;


/**
 * Created by SONY on 02-03-18.
 */

public class StrangleAnglesFragment extends Fragment implements View.OnClickListener{
    LinearLayout LlAssistance,llViewStubHolder;
    View inflated;
    ViewGroup container;
    RelativeLayout rlBgBlue;
    TextView txtCommonAssistance;

    public static StrangleAnglesFragment newInstance() {

        Bundle args = new Bundle();

        StrangleAnglesFragment fragment = new StrangleAnglesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.container=container;
        ((MainActivity) getActivity()).setUpTopHeader(R.drawable.launch_banner, Gravity.TOP, false, true, false);
        ((MainActivity) getActivity()).setActionBarTitle(" ");
        ((MainActivity) getActivity()).setCollpsingImage(R.drawable.stranger_angels);

        init();
        View v = inflater.inflate(R.layout.fragment_common_content, container, false);
        rlBgBlue=v.findViewById(R.id.rl_bg_blue);
        llViewStubHolder=v.findViewById(R.id.ll_view_stub_holder);
        rlBgBlue.setVisibility(View.GONE);

        ViewStub viewStub = v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_strangle_angles);
        inflated = viewStub.inflate();
        LlAssistance = inflated.findViewById(R.id.ll_assistance);
        txtCommonAssistance=inflated.findViewById(R.id.txt_common_assistance);
        txtCommonAssistance.setText(" ");
        LlAssistance.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_assistance:
                new CommonAssistance(getActivity(),LlAssistance).show();
                break;
        }
    }
    private void init(){
        ((MainActivity)getActivity()).setUpTxtToolbar(View.VISIBLE,"STRANGER ANGELS");
        ((MainActivity) getActivity()).setOverlap(R.dimen.collapoverlap);
//        ((MainActivity) getActivity()).setConfigToolbar(R.drawable.gradiant_toolbar);
    }
    @Override
    public void onResume() {
        super.onResume();
       init();
    }

    @Override
    public void onStop() {
        super.onStop();
        ((MainActivity)getActivity()).setUpTxtToolbar(View.GONE,"");
        ((MainActivity) getActivity()).setOverlap(R.dimen.collapsoverlapzero);
//        ((MainActivity) getActivity()).setConfigToolbar(0);
    }
}
