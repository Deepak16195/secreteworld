package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 1/3/18.
 */

public class QuickRequestFragment extends MainFragment {
    RelativeLayout rlBgBlue;
    public static QuickRequestFragment newInstance() {

        Bundle args = new Bundle();
        
        QuickRequestFragment fragment = new QuickRequestFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
//        ((MainActivity)getActivity()).setActionBarTitle("");


        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
//        rlBgBlue=v.findViewById(R.id.rl_bg_blue);
//        rlBgBlue.setVisibility(View.GONE);


        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_quick_request);
        View inflated=viewStub.inflate();
        TextView pageTitle=inflated.findViewById(R.id.txt_common_assistance);
        pageTitle.setText("NEED HELP?");
        Spinner spinCategory=inflated.findViewById(R.id.spin_category);
        ArrayAdapter adapterCategory=new ArrayAdapter(getActivity(),R.layout.spin_layout,new String[]{"CATEGORY","TICKET FOR PURCHASE"});
        spinCategory.setAdapter(adapterCategory);
        return v;
    }

}
