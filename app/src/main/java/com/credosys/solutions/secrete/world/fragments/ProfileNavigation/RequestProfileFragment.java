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

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.ProfileRequestAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;

/**
 * Created by win7 on 12-Jan-18.
 */

public class RequestProfileFragment extends Fragment {
    RecyclerView rvProfileRequest;
    public static RequestProfileFragment newInstance() {

        Bundle args = new Bundle();

        RequestProfileFragment fragment = new RequestProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile_request,null,false);
        rvProfileRequest=v.findViewById(R.id.rv_profile_request);

        ((MainActivity)getActivity()).setActionBarTitle("MY REQUEST");
//        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
//        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);
//        ((MainActivity)getActivity()).showBackButton(true);

        ProfileRequestAdapter pra=new ProfileRequestAdapter();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvProfileRequest.setLayoutManager(layoutManager);
        rvProfileRequest.setItemAnimator(new DefaultItemAnimator());
        rvProfileRequest.setAdapter(pra);
        rvProfileRequest.setNestedScrollingEnabled(true);
        return v;
    }
}
