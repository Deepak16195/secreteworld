package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.ExpertAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.Utility.SimpleDividerItemDecoration;

/**
 * Created by win7 on 13-Jan-18.
 */

public class ExpertFragment extends Fragment {
    RecyclerView rvExpert;
    public static ExpertFragment newInstance() {

        Bundle args = new Bundle();

        ExpertFragment fragment = new ExpertFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_expert,null,false);

        ((MainActivity)getActivity()).setActionBarTitle("EXPERT");
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);
        ((MainActivity)getActivity()).showBackButton(true);

        rvExpert=v.findViewById(R.id.rv_expert);
        ExpertAdapter expertAdapter=new ExpertAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvExpert.setLayoutManager(layoutManager);
        rvExpert.setItemAnimator(new DefaultItemAnimator());
        rvExpert.setAdapter(expertAdapter);
        rvExpert.addItemDecoration(new SimpleDividerItemDecoration(getActivity()));
        rvExpert.setNestedScrollingEnabled(true);
        return v;
    }

}