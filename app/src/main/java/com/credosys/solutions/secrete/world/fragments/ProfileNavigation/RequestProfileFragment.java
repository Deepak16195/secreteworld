package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
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
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.Pojos.App.Request;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 12-Jan-18.
 */

public class RequestProfileFragment extends MainFragment {
    RecyclerView rvProfileRequest;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static RequestProfileFragment newInstance() {

        Bundle args = new Bundle();

        RequestProfileFragment fragment = new RequestProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_profile_request,null,false);
        rvProfileRequest=v.findViewById(R.id.rv_profile_request);
        mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
        mainApp.setActionBarTitle("MY REQUEST");
        mainApp.setExpandableTitle(Gravity.CENTER);
        mainApp.setAppBarLayoutExpand(true,true);
        mainApp.showBackButton(true);
        mainApp.lockDrawer();
        List<Request> list=new ArrayList<>();
        list.add(new Request(R.drawable.vadapav,"",""));
        list.add(new Request(R.drawable.savpuri,"",""));
        list.add(new Request(R.drawable.img_sabudana,"",""));
        list.add(new Request(R.drawable.vadapav,"",""));
        list.add(new Request(R.drawable.savpuri,"",""));
        list.add(new Request(R.drawable.img_sabudana,"",""));

        ProfileRequestAdapter pra=new ProfileRequestAdapter(list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvProfileRequest.setLayoutManager(layoutManager);
        rvProfileRequest.setItemAnimator(new DefaultItemAnimator());
        rvProfileRequest.setAdapter(pra);
        rvProfileRequest.setNestedScrollingEnabled(true);
        return v;
    }
}
