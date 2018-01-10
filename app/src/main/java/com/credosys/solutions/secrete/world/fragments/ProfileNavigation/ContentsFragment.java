package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.ContentsAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.HomeContents;
import com.credosys.solutions.secrete.world.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 10-Jan-18.
 */

public class ContentsFragment extends Fragment implements View.OnClickListener{
    RelativeLayout rlBackground;
    //    LinearLayout llPublish;
    RecyclerView rvContents;
    Button btnPublish;
    CardView cvNormalText,cvPublish;

    public static ContentsFragment newInstance() {

        Bundle args = new Bundle();

        ContentsFragment fragment = new ContentsFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_profile_wall_contents,null,false);

//        rlNormaltext=v.findViewById(R.id.rl_normal_text);
//        rlPublish=v.findViewById(R.id.rl_publish);
        btnPublish=v.findViewById(R.id.btn_publish);
        rlBackground=v.findViewById(R.id.rl_background);
        rvContents =v.findViewById(R.id.rv_wall_contents);
//        llPublish=v.findViewById(R.id.ll_publish);
        cvNormalText=v.findViewById(R.id.cv_normal_text);
        cvPublish=v.findViewById(R.id.cv_publish);

        cvNormalText.setOnClickListener(this);
        btnPublish.setOnClickListener(this);

        ((MainActivity)getActivity()).setActionBarTitle("CONTENTS");
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).showBackButton(true);

//
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        rvContents.setLayoutManager(layoutManager);
//        rvContents.setItemAnimator(new DefaultItemAnimator());
//        rvContents.setAdapter(wa);
//        rvContents.setNestedScrollingEnabled(true);

        ContentsAdapter contentsAdapter=new ContentsAdapter(tempList());
        rvContents.setAdapter(contentsAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rvContents.setLayoutManager(staggeredGridLayoutManager);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cvPublish.setNestedScrollingEnabled(false);
        }


        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_publish){
//            rlPublish.animate()
//                    .translationY(rlPublish.getHeight())
//                    .alpha(0.0f)
//                    .setDuration(300)
//                    .setListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);
            rlBackground.setVisibility(View.GONE);
            cvPublish.setVisibility(View.GONE);
            cvNormalText.setVisibility(View.VISIBLE);
//                        }
//                    });


        }
        if(v.getId()==R.id.cv_normal_text){
//            rlNormaltext.animate()
//                    .translationY(rlNormaltext.getHeight())
//                    .alpha(0.0f)
//                    .setDuration(300)
//                    .setListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            super.onAnimationEnd(animation);

//                        }
//                    });

            cvNormalText.setVisibility(View.GONE);
            cvPublish.setVisibility(View.VISIBLE);
            rlBackground.setVisibility(View.VISIBLE);
        }
    }
    List<HomeContents> tempList(){
        List<HomeContents> al=new ArrayList<>();
        al.add(new HomeContents("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius...","FOOD"));
        al.add(new HomeContents("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger...","OTHERS"));
        al.add(new HomeContents("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius...","HISTORICAL PLACES"));
        al.add(new HomeContents("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger...","HISTORICAL PLACES"));
        al.add(new HomeContents("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius...","OTHERS"));
        al.add(new HomeContents("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger...","FOOD"));
        al.add(new HomeContents("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius...","OTHERS"));
        al.add(new HomeContents("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger...","HISTORICAL PLACES"));
        return al;
    }
}
