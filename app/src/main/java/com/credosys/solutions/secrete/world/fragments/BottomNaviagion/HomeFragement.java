package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.CustomItemClickListener;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.HomeAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.HomeContentsPlaces;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by win7 on 21-Dec-17.
 */

public class HomeFragement extends MainFragment {
    // Store instance variables
    RecyclerView rv;
    Context context;
    // newInstance constructor for creating fragment with arguments
    public static HomeFragement newInstance() {
        HomeFragement fragmentFirst = new HomeFragement();
        Bundle args = new Bundle();
        fragmentFirst.setArguments(args);
        return fragmentFirst;
    }


    // Store instance variables based on arguments passed

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv=view.findViewById(R.id.recyclerview_home);
        context=getActivity();


        ((MainActivity)getActivity()).setActionBarTitle("MUMBAI");
        ((MainActivity)getActivity()).setTabLayoutColors(R.color.white, R.color.white, R.color.customBlue, R.color.tab_layout_text, R.color.tab_layout_text);
        ((MainActivity)getActivity()).setUpTopHeader(R.drawable.launch_banner,Gravity.CENTER,true,true,true);
        ((MainActivity)getActivity()).showBackButton(false);

//        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);




        HomeAdapter homeAdapter=new HomeAdapter(tempList(), new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                ((MainActivity)context).setFragments(24);
            }
        });
        rv.setAdapter(homeAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        return view;
    }

    List<HomeContentsPlaces> tempList(){
        List<HomeContentsPlaces> al=new ArrayList<>();
        al.add(new HomeContentsPlaces("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius...",R.drawable.img_sabudana));
        al.add(new HomeContentsPlaces("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger...",R.drawable.img_vadapav));
        al.add(new HomeContentsPlaces("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius...",R.drawable.img_sabudana));
        al.add(new HomeContentsPlaces("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger...",R.drawable.img_vadapav));
        al.add(new HomeContentsPlaces("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius...",R.drawable.img_sabudana));
        al.add(new HomeContentsPlaces("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger...",R.drawable.img_vadapav));
        al.add(new HomeContentsPlaces("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius...",R.drawable.img_sabudana));
        al.add(new HomeContentsPlaces("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger...",R.drawable.img_vadapav));

        return al;
    }
}
