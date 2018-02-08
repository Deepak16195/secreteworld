package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.FriendsAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.pojoFriends;
import com.credosys.solutions.secrete.world.R;

import java.util.ArrayList;

/**
 * Created by win7 on 10-Jan-18.
 */

public class FriendsFragment extends Fragment {
    RecyclerView rvFriends;
    private RecyclerView.LayoutManager mLayoutManager;

    public static FriendsFragment newInstance() {

        Bundle args = new Bundle();

        FriendsFragment fragment = new FriendsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friends, null, false);

        ((MainActivity) getActivity()).setActionBarTitle("MY FRIENDS");
//        ((MainActivity) getActivity()).setExpandableTitle(Gravity.CENTER);
//        ((MainActivity) getActivity()).setAppBarLayoutExpand(true, true);
//        ((MainActivity) getActivity()).showBackButton(true);

        rvFriends = v.findViewById(R.id.rv_friends);
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
}
