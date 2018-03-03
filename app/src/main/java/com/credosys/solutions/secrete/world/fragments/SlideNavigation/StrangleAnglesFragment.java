package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.TooltipCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.nhaarman.supertooltips.ToolTip;
import com.nhaarman.supertooltips.ToolTipRelativeLayout;
import com.nhaarman.supertooltips.ToolTipView;

/**
 * Created by SONY on 02-03-18.
 */

public class StrangleAnglesFragment extends Fragment implements View.OnClickListener, ToolTipView.OnToolTipViewClickedListener {
    LinearLayout LlAssistance;
    View inflated;
    private ToolTipView mPurpleToolTipView;
    ToolTipRelativeLayout toolTipRelativeLayout;
    public static StrangleAnglesFragment newInstance() {

        Bundle args = new Bundle();

        StrangleAnglesFragment fragment = new StrangleAnglesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        ((MainActivity)getActivity()).setActionBarTitle("STRANGER ANGELS");
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_strangle_angles);
       inflated=viewStub.inflate();
        toolTipRelativeLayout = (ToolTipRelativeLayout) inflated.findViewById(R.id.activity_main_tooltipframelayout);
        LlAssistance=inflated.findViewById(R.id.ll_assistance);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                addPurpleToolTipView();
            }
        }, 1300);
        LlAssistance.setOnClickListener(this);
        return v;
    }

    private void addPurpleToolTipView() {
        ToolTip toolTip = new ToolTip()
                .withContentView(LayoutInflater.from(getActivity()).inflate(R.layout.tooltip_assistance, null))
                .withColor(getResources().getColor(R.color.grayColor))
                .withAnimationType(ToolTip.AnimationType.NONE);

        mPurpleToolTipView = toolTipRelativeLayout.showToolTipForView(toolTip, inflated.findViewById(R.id.ll_assistance));
        mPurpleToolTipView.setOnToolTipViewClickedListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_assistance:
                addPurpleToolTipView();
                break;
        }
    }

    @Override
    public void onToolTipViewClicked(ToolTipView toolTipView) {
        if (mPurpleToolTipView == null) {
            addPurpleToolTipView();
        } else {
            mPurpleToolTipView.remove();
            mPurpleToolTipView = null;
        }
    }
}
