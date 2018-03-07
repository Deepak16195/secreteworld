package com.credosys.solutions.secrete.world.fragments.ExploreTab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.GoogleHorizontalAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.Pojos.App.ExploreGooglePlaces;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 26-Dec-17.
 */

public class SworldPlacesFragment extends MainFragment implements View.OnClickListener,SeekBar.OnSeekBarChangeListener{
    Button btnCategory;
    RecyclerView rvFamous;
    SeekBar seekbarGoogle;
    TextView txtRadius;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static SworldPlacesFragment newInstance() {
        SworldPlacesFragment fragmentFirst = new SworldPlacesFragment();
//        Bundle args = new Bundle();
//        args.putInt("someInt", page);
//        args.putString("someTitle", title);
//        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }
    public SworldPlacesFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_sworld_places, container, false);
        rvFamous=v.findViewById(R.id.rv_famous);
        btnCategory=v.findViewById(R.id.btn_category);
        seekbarGoogle=v.findViewById(R.id.seekbar_google);
        txtRadius=v.findViewById(R.id.txt_radius);

        seekbarGoogle.setOnSeekBarChangeListener(this);
        btnCategory.setOnClickListener(this);
        List<ExploreGooglePlaces> gplaces=new ArrayList<>();
        gplaces.add(new ExploreGooglePlaces("Amazing Views",3,R.color.cutomGreen));
        gplaces.add(new ExploreGooglePlaces("Historical Sites",37,R.color.lable_one));
        gplaces.add(new ExploreGooglePlaces("Others",0,R.color.customBlue));
        gplaces.add(new ExploreGooglePlaces("Art, Muesums and Theaters",20,R.color.lable_two));
        gplaces.add(new ExploreGooglePlaces("Typical Dishes & Food",0,R.color.lable_three));
        gplaces.add(new ExploreGooglePlaces("Music World",0,R.color.lable_four));
        GoogleHorizontalAdapter gha=new GoogleHorizontalAdapter(gplaces);
        rvFamous.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL));
        rvFamous.setAdapter(gha);
        return v;
    }
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_category){
            mainApp.setFragments(5);
            mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        Log.d("seekprogress",""+progress);
        txtRadius.setText(progress+" KM");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
