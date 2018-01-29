package com.credosys.solutions.secrete.world.fragments.BottomNaviagion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.HomeAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.HomeContents;
import com.credosys.solutions.secrete.world.R;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by win7 on 21-Dec-17.
 */

public class HomeFragement extends Fragment {
    // Store instance variables
    RecyclerView rv;
    // newInstance constructor for creating fragment with arguments
    public static HomeFragement newInstance(int page, String title) {
        HomeFragement fragmentFirst = new HomeFragement();
        Bundle args = new Bundle();
        args.putInt("someInt", page);
        args.putString("someTitle", title);
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


        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);




        HomeAdapter homeAdapter=new HomeAdapter(tempList());
        rv.setAdapter(homeAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        return view;
    }

    List<HomeContents> tempList(){
        List<HomeContents> al=new ArrayList<>();
        al.add(new HomeContents("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new HomeContents("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger..."));
        al.add(new HomeContents("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new HomeContents("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger..."));
        al.add(new HomeContents("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new HomeContents("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger..."));
        al.add(new HomeContents("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new HomeContents("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger..."));

        return al;
    }
}
