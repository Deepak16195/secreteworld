package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.FriendsAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.Pojos.App.pojoFriends;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;

/**
 * Created by win7 on 10-Jan-18.
 */

public class FriendsFragment extends MainFragment implements View.OnClickListener{
    RecyclerView rvFriends;
    private RecyclerView.LayoutManager mLayoutManager;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static FriendsFragment newInstance() {

        Bundle args = new Bundle();

        FriendsFragment fragment = new FriendsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_friends, null, false);
        ((MainActivity) getActivity()).setActionBarTitle("MY FRIENDS");
        ((MainActivity) getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity) getActivity()).setAppBarLayoutExpand(true, true);
        ((MainActivity) getActivity()).showBackButton(true);
        mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
        mainApp.lockDrawer();
        Button btnInvite=v.findViewById(R.id.btn_invite);
        rvFriends = v.findViewById(R.id.rv_friends);


        btnInvite.setOnClickListener(this);


        mLayoutManager = new GridLayoutManager(getActivity(), 3);
        rvFriends.setLayoutManager(mLayoutManager);
        ArrayList<pojoFriends> friend = new ArrayList<>();
        friend.add(new pojoFriends(R.drawable.p1));
        friend.add(new pojoFriends(R.drawable.p2));
        friend.add(new pojoFriends(R.drawable.p3));
        friend.add(new pojoFriends(R.drawable.p4));
        friend.add(new pojoFriends(R.drawable.p5));
        friend.add(new pojoFriends(R.drawable.p6));
        friend.add(new pojoFriends(R.drawable.p1));
        friend.add(new pojoFriends(R.drawable.p2));
        friend.add(new pojoFriends(R.drawable.p3));
        friend.add(new pojoFriends(R.drawable.p4));
        friend.add(new pojoFriends(R.drawable.p5));
        friend.add(new pojoFriends(R.drawable.p6));
        FriendsAdapter fa = new FriendsAdapter(friend);
        rvFriends.setAdapter(fa);
        rvFriends.setNestedScrollingEnabled(true);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_invite:
                mainApp.setFragments(21);
                break;
        }
    }
}
