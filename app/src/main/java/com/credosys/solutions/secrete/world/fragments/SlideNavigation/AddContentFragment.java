package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;

/**
 * Created by SONY on 14-01-18.
 */

public class AddContentFragment extends Fragment implements View.OnClickListener {

    LinearLayout llTitle;
    RelativeLayout rlTitleExpand;
    public static AddContentFragment newInstance() {

        Bundle args = new Bundle();

        AddContentFragment fragment = new AddContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_add_content,null,false);
        ((MainActivity)getActivity()).setActionBarTitle("ADD CONTENT");
        ((MainActivity)getActivity()).setCollpsingImage(R.drawable.topbg);
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);
        ((MainActivity)getActivity()).showBackButton(false);

        llTitle=v.findViewById(R.id.ll_addcontent_title);
        llTitle.setOnClickListener(this);
        rlTitleExpand=v.findViewById(R.id.rl_title_expand);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_addcontent_title:
                rlTitleExpand.setVisibility(View.VISIBLE);
                break;
        }
    }
}
