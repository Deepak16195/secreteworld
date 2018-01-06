package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import  android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.SliderMaterial.CardFragmentPagerAdapter;
import com.credosys.solutions.secrete.world.SliderMaterial.CardItem;
import com.credosys.solutions.secrete.world.SliderMaterial.CardPagerAdapter;
import com.credosys.solutions.secrete.world.SliderMaterial.ShadowTransformer;

/**
 * Created by win7 on 23-Dec-17.
 */

public class MyDiaryFragment extends Fragment/* implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener */{
//    private Button mButton;
    private ViewPager mViewPager;

    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;

    private boolean mShowingFragments = false;

    public static Fragment newInstance() {
        return new MyDiaryFragment();
    }
    public MyDiaryFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_mydiary,null,false);
        mViewPager = (ViewPager) v.findViewById(R.id.viewpager_mydiary);
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
