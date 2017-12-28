package com.credosys.solutions.secrect.world.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.credosys.solutions.secrect.world.Adapters.HomeAdapter;
import com.credosys.solutions.secrect.world.MainActivity;
import com.credosys.solutions.secrect.world.Pojos.Home;
import com.credosys.solutions.secrect.world.R;

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
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv=view.findViewById(R.id.recyclerview_home);
        HomeAdapter homeAdapter=new HomeAdapter(tempList());
        rv.setAdapter(homeAdapter);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        return view;
    }

    List<Home> tempList(){
        List<Home> al=new ArrayList<>();
        al.add(new Home("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new Home("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger..."));
        al.add(new Home("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new Home("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger..."));
        al.add(new Home("Kim Gomaz","SAGO OR SABUDANA KHICHDI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new Home("Kim Gomaz","VADA PAO","VADA PAO  is the indian version of burger..."));
        al.add(new Home("Kim Gomaz","PAO BHAJI","Sabudana is one of those recipes that is made during religius..."));
        al.add(new Home("Kim Gomaz","SHEV PURI","VADA PAO  is the indian version of burger..."));


        return al;
    }
}
