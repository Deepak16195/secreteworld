package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.WallAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by win7 on 06-Jan-18.
 */

public class WallFragment extends MainFragment implements View.OnClickListener{
    RelativeLayout rlBackground;
//    LinearLayout llPublish;
    RecyclerView rvWall;
    Button btnPublish;
    CardView cvNormalText,cvPublish;

    public static WallFragment newInstance() {

        Bundle args = new Bundle();

        WallFragment fragment = new WallFragment();
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
        rvWall=v.findViewById(R.id.rv_wall_contents);
//        llPublish=v.findViewById(R.id.ll_publish);
        cvNormalText=v.findViewById(R.id.cv_normal_text);
        cvPublish=v.findViewById(R.id.cv_publish);

        cvNormalText.setOnClickListener(this);
        btnPublish.setOnClickListener(this);

        ((MainActivity)getActivity()).setActionBarTitle("MY WALL");
//        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).showBackButton(true);

        WallAdapter wa=new WallAdapter();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvWall.setLayoutManager(layoutManager);
        rvWall.setItemAnimator(new DefaultItemAnimator());
        rvWall.setAdapter(wa);
        rvWall.setNestedScrollingEnabled(true);

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
}
