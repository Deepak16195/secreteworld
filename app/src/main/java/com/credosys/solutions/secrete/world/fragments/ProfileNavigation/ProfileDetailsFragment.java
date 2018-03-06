package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by Yogesh on 14-Feb-18.
 */

public class ProfileDetailsFragment extends MainFragment implements View.OnClickListener {
    Button btnSubmit;
    public static ProfileDetailsFragment newInstance() {

        Bundle args = new Bundle();

        ProfileDetailsFragment fragment = new ProfileDetailsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile_details, container, false);
        ((MainActivity) getActivity()).setActionBarTitle("DETAILS");
        ((MainActivity) getActivity()).showBackButton(true);
        ((MainActivity) getActivity()).setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);

        ImageView imgEdit = v.findViewById(R.id.img_edit);
        btnSubmit = v.findViewById(R.id.btn_submit);
        imgEdit.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_edit:
                btnSubmit.setVisibility(View.VISIBLE);
                break;
        }
    }
}
