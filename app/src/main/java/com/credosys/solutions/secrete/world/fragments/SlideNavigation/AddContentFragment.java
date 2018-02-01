package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;


/**
 * Created by SONY on 14-01-18.
 */

public class AddContentFragment extends Fragment implements View.OnClickListener {

    LinearLayout llTitle,llMain,llCategory,llDesc,llExtdesc,llTag,llPic,rlPicExpand,llLocation;
    RelativeLayout rlTitleExpand,rlCategoryExpand,rlDescExpand,rlExtdescExpand,rlTagExpand,rlLocationExpand;
    ScrollView svMain;
    Animation slide_down;
//   ExpandableRelativeLayout rlTitleExpand;
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

        llMain=v.findViewById(R.id.ll_main_addcontent);
        llTitle=v.findViewById(R.id.ll_addcontent_title);
        rlTitleExpand=v.findViewById(R.id.rl_title_expand);
        svMain=v.findViewById(R.id.sv_main);
        llCategory=v.findViewById(R.id.ll_addcontent_category);
        rlCategoryExpand=v.findViewById(R.id.rl_category_expand);
        llDesc=v.findViewById(R.id.ll_addcontent_description);
        rlDescExpand=v.findViewById(R.id.rl_description_expand);
        llExtdesc=v.findViewById(R.id.ll_addcontent_extdesc);
        rlExtdescExpand=v.findViewById(R.id.rl_extdesc_expand);
        llTag=v.findViewById(R.id.ll_addcontent_tag);
        rlTagExpand=v.findViewById(R.id.rl_tag_expand);
        llPic=v.findViewById(R.id.ll_addcontent_pic);
        rlPicExpand=v.findViewById(R.id.rl_pic_expand);
        llLocation=v.findViewById(R.id.ll_addcontent_location);
        rlLocationExpand=v.findViewById(R.id.rl_location_expand);

        llTitle.setOnClickListener(this);
        llCategory.setOnClickListener(this);
        llDesc.setOnClickListener(this);
        llExtdesc.setOnClickListener(this);
        llTag.setOnClickListener(this);
        llPic.setOnClickListener(this);
        llLocation.setOnClickListener(this);





        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            svMain.setNestedScrollingEnabled(true);

        }



        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_addcontent_title:
                 rlTitleExpand.setVisibility(View.VISIBLE);
                 rlCategoryExpand.setVisibility(View.GONE);
                 rlDescExpand.setVisibility(View.GONE);
                 rlExtdescExpand.setVisibility(View.GONE);
                 rlTagExpand.setVisibility(View.GONE);
                 rlPicExpand.setVisibility(View.GONE);
                  rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_category:
                rlCategoryExpand.setVisibility(View.VISIBLE);
                rlTitleExpand.setVisibility(View.GONE);
                rlDescExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_description:
                rlDescExpand.setVisibility(View.VISIBLE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_extdesc:
                rlExtdescExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_tag:
                rlTagExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_pic:
                rlPicExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_location:
                rlLocationExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                break;



        }
    }
}
