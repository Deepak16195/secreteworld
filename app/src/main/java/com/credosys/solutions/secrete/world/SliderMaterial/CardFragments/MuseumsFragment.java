package com.credosys.solutions.secrete.world.SliderMaterial.CardFragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.SliderMaterial.CardAdapter;

/**
 * Created by win7 on 17-Jan-18.
 */

public class MuseumsFragment extends Fragment {

    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        mCardView.setRadius(5.0f);
        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }
}
