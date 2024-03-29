package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.SliderMaterial.CardFragment;
import com.credosys.solutions.secrete.world.SliderMaterial.CardFragmentPagerAdapter;
import com.credosys.solutions.secrete.world.SliderMaterial.CardItem;
import com.credosys.solutions.secrete.world.SliderMaterial.CardPagerAdapter;
import com.credosys.solutions.secrete.world.SliderMaterial.ShadowTransformer;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by win7 on 23-Dec-17.
 */

public class MyDiaryFragment extends MainFragment/* implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener */{
//    private Button mButton;
    private ViewPager mViewPager;
    TextView txtMydiaryLableOne,txtMydiaryLableTwo;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    MainActivity mainApp= MainApplication.getInstance().getMainActivity();
    public static Fragment newInstance() {
        return new MyDiaryFragment();
    }
    public MyDiaryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_mydiary,null,false);
        mViewPager =v.findViewById(R.id.viewpager_mydiary);
        txtMydiaryLableOne=v.findViewById(R.id.txt_mydiary_lable_one);
        txtMydiaryLableTwo=v.findViewById(R.id.txt_mydiary_lable_two);
        mainApp.setActionBarTitle("DIARY");
//        mainApp.  setTabLayoutColors(R.color.marineGreen, R.color.gradientColor, R.color.cutomGreen, R.color.white, R.color.white);
        mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
//        mButton = (Button) v.findViewById(R.id.cardTypeBtn);
//        ((CheckBox) v.findViewById(R.id.checkBox)).setOnCheckedChangeListener(this);
//        mButton.setOnClickListener(this);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem(R.string.title_1, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_2, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_3, R.string.text_1));
        mCardAdapter.addCardItem(new CardItem(R.string.title_4, R.string.text_1));
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getChildFragmentManager(),
                dpToPixels(2, getActivity()));

        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
        mViewPager.setAdapter(mFragmentCardAdapter);
        mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);

        mCardShadowTransformer.enableScaling(true);
        mFragmentCardShadowTransformer.enableScaling(true);
//        mViewPager.setAdapter(mCardAdapter);
//        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                try {
                    ((CardFragment) mFragmentCardAdapter.getItem(position)).setCurrFragNum(position);
                    ((CardFragment) mFragmentCardAdapter.getItem(position)).setEachCard();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                switch(position)
                {
                    case 0:
                        txtMydiaryLableOne.setText("HELP US TO");
                        txtMydiaryLableTwo.setText("KNOW THE WORLD");
                        break;
                    case 1:
                        txtMydiaryLableOne.setText("A TRIP");
                        txtMydiaryLableTwo.setText("TO A PHOTO");
                        break;
                    case 2:
                        txtMydiaryLableOne.setText("PROMOTE EVENTS");
                        txtMydiaryLableTwo.setText("");
                        break;
                    case 3:
                        txtMydiaryLableOne.setText("MUSEUMS - ARTS GALLERIES");
                        txtMydiaryLableTwo.setText("CONCERTS - THEATERS");
                        break;
                    case 4:
                        txtMydiaryLableOne.setText("CREATE A");
                        txtMydiaryLableTwo.setText("TRAVEL ITINERARY");
                        break;
                    case 5:
                        txtMydiaryLableOne.setText("CREATE A");
                        txtMydiaryLableTwo.setText("TRAVEL DIARY");
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        return v;
    }

//    @Override
//    public void onClick(View v) {
//        if (!mShowingFragments) {
//            Log.d("clickOne",""+!mShowingFragments);
//            mButton.setText("Views");
//            mViewPager.setAdapter(mFragmentCardAdapter);
//            mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
//        }
// else {
//            Log.d("clickOneTwo",!mShowingFragments+"");
//            mButton.setText("Fragments");
//            mViewPager.setAdapter(mCardAdapter);
//            mViewPager.setPageTransformer(false, mCardShadowTransformer);
//        }

//        mShowingFragments = !mShowingFragments;
//    }
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

//    @Override
//    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//        mCardShadowTransformer.enableScaling(b);
//        mFragmentCardShadowTransformer.enableScaling(b);
//    }
}
