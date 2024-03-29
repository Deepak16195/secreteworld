package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.credosys.solutions.secrete.world.Adapters.ViewPagers.CustomPagerAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 24/2/18.
 */

public class WhereEatFragment extends MainFragment implements View.OnClickListener{
    Context context;
    ImageView imgReview;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static WhereEatFragment newInstance() {

        Bundle args = new Bundle();

        WhereEatFragment fragment = new WhereEatFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mainApp.showBackButton(true);
        mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);

        context=getActivity();
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_where_eat);
        View inflated=viewStub.inflate();
        ViewPager mViewPager=inflated.findViewById(R.id.pager);
        imgReview=inflated.findViewById(R.id.img_review);

        inflated.findViewById(R.id.btn_eat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)context).setFragments(22);
            }
        });
        CustomPagerAdapter mCustomPagerAdapter = new CustomPagerAdapter(getActivity());
        mViewPager.setAdapter(mCustomPagerAdapter);


        imgReview.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.img_review:
                showReviewDialog();
                break;
        }
    }
    private void showReviewDialog(){
        Dialog dlg=new Dialog(getActivity());
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dlg.setContentView(R.layout.dialog_review);
        dlg.show();
    }
}
