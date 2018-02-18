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
import com.credosys.solutions.secrete.world.R;

/**
 * Created by SONY on 18-02-18.
 */

public class SellerUserFragment extends Fragment {
    public static SellerUserFragment newInstance() {

        Bundle args = new Bundle();

        SellerUserFragment fragment = new SellerUserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_common_content, container, false);
        ((MainActivity)getActivity()).setActionBarTitle("");
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);


        ViewStub viewStub = v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_seller_user);
        View inflated = viewStub.inflate();
        return v;
    }
}
