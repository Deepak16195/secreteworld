package com.credosys.solutions.secrete.world.SliderMaterial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.R;


public class CardFragment extends Fragment {
    int currFragNum;
    ImageView imgDiaryCardBackground,imgDiaryCardForeground;

    public void setCurrFragNum(int currFragNum) {
        this.currFragNum = currFragNum;

    }
    private CardView mCardView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_adapter, container, false);
        mCardView = (CardView) view.findViewById(R.id.cardView);
        mCardView.setMaxCardElevation(mCardView.getCardElevation()
                * CardAdapter.MAX_ELEVATION_FACTOR);
        imgDiaryCardBackground=view.findViewById(R.id.img_diary_card_background);
        imgDiaryCardForeground=view.findViewById(R.id.img_diary_card_foreground);

        switch(currFragNum){
                case 0:
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_my_dairy);
                break;

                case 1:
                    imgDiaryCardBackground.setImageResource(R.drawable.launch_banner);
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_mydiary_cam);
                break;

                case 2:
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_mydiary_calendar);
                break;

                case 3:
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_mydiary_museum);
                break;

                case 4:
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_mydiary_place);
                break;

                case 5:
                    imgDiaryCardForeground.setImageResource(R.drawable.ic_mydiary_book);
                break;

        }
        return view;
    }

    public CardView getCardView() {
        return mCardView;
    }
}
