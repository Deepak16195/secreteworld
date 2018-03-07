package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by win7 on 02-Jan-18.
 */

public class ProfileFragment extends MainFragment implements View.OnClickListener{
    Button btnDetails,btnGetPrimium,btnSeller,btnExpert;
    LinearLayout LlWall,LlContents,LlFriends,LlMessages,LlRequest,LlOrders,LlSellers,LlExpert;
    NestedScrollView profileNestedScrollView;
    MainActivity mainApp= MainApplication.getInstance().getMainActivity();
     public static ProfileFragment newInstance() {
        Bundle args = new Bundle();
        ProfileFragment fragment = new ProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_profile,container,false);
        profileNestedScrollView = v.findViewById(R.id.profile_NestedScrollView);

        profileNestedScrollView.setNestedScrollingEnabled(false);

        assert mainApp != null;

        mainApp.unlockDrawer();
        mainApp.setActionBarTitle("PROFILE");
        mainApp.setExpandableTitle(Gravity.NO_GRAVITY);
        mainApp.showBackButton(false);
        mainApp.setAppBarLayoutExpand(false,false);
        mainApp.setCollpsingImage(R.drawable.topbg);

        LlWall=v.findViewById(R.id.ll_wall);
        LlContents=v.findViewById(R.id.ll_contents);
        LlFriends=v.findViewById(R.id.ll_friends);
        LlMessages=v.findViewById(R.id.ll_messages);
        LlRequest=v.findViewById(R.id.ll_request);
        LlOrders=v.findViewById(R.id.ll_orders);
        LlExpert=v.findViewById(R.id.ll_expert);
        LlSellers=v.findViewById(R.id.ll_sellers);
        btnDetails =v.findViewById(R.id.btn_profile_details);
        btnGetPrimium=v.findViewById(R.id.btn_get_premium);
        btnSeller=v.findViewById(R.id.btn_seller_user);
        btnExpert=v.findViewById(R.id.btn_expert_user);

        LlWall.setOnClickListener(this);
        LlContents.setOnClickListener(this);
        LlFriends.setOnClickListener(this);
        LlMessages.setOnClickListener(this);
        LlRequest.setOnClickListener(this);
        LlOrders.setOnClickListener(this);
        LlExpert.setOnClickListener(this);
        LlSellers.setOnClickListener(this);
        btnDetails.setOnClickListener(this);
        btnGetPrimium.setOnClickListener(this);
        btnSeller.setOnClickListener(this);
        btnExpert.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.btn_profile_details:
                mainApp.setFragments(15);
                break;
            case R.id.btn_get_premium:
                mainApp.setFragments(23);
                break;
            case R.id.btn_seller_user:
                mainApp.setFragments(19);
                break;
            case R.id.btn_expert_user:
                mainApp.setFragments(18);
                break;
            case R.id.ll_wall:
                mainApp.setFragments(7);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_contents:
                mainApp.setFragments(6);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_friends:
                mainApp.setFragments(8);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_messages:
                mainApp.setFragments(9);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_request:
                mainApp.setFragments(11);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_orders:
                mainApp.setFragments(12);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_expert:
                mainApp.setFragments(14);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
            case R.id.ll_sellers:
                mainApp.setFragments(13);
                mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
                break;
        }
    }



}
