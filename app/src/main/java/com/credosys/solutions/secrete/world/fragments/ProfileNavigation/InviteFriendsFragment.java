package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

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
import com.credosys.solutions.secrete.world.R;

/**
 * Created by credosys on 21/2/18.
 */

public class InviteFriendsFragment extends Fragment {
    public static InviteFriendsFragment newInstance() {

        Bundle args = new Bundle();

        InviteFriendsFragment fragment = new InviteFriendsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_invite_friends);
        View inflated=viewStub.inflate();
       return v;
    }
}
