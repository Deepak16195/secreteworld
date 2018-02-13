package com.credosys.solutions.secrete.world.fragments.ExploreTab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.CustomItemClickListener;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.SearchByCategoryAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.SearchCategory;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 03-Jan-18.
 */

public class SearchByCategoryFragment extends MainFragment implements View.OnClickListener{
    RecyclerView rvSearchCategory;
    Switch aSwitch;
    ImageView imgBlueArrow;
    List<SearchCategory> sc;
    SearchByCategoryAdapter sbca;
    public static SearchByCategoryFragment newInstance() {

        Bundle args = new Bundle();

        SearchByCategoryFragment fragment = new SearchByCategoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_search_by_categories,container,false);
        rvSearchCategory=v.findViewById(R.id.rv_search_category);
        aSwitch=v.findViewById(R.id.switch_search_category);
        imgBlueArrow=v.findViewById(R.id.img_blue_arrow);
        imgBlueArrow.setOnClickListener(this);

        ((MainActivity)getActivity()).setActionBarTitle("SECRETS AROUND YOU");

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvSearchCategory.setLayoutManager(mLayoutManager);
        rvSearchCategory.setItemAnimator(new DefaultItemAnimator());
        sc=new ArrayList<>();

        sc.add(new SearchCategory("AMAZING VIEW",3,R.drawable.ic_secret_around_me_01));
        sc.add(new SearchCategory("ART, MUSEUM and THEATERS",20,R.drawable.ic_secret_around_me_02));
        sc.add(new SearchCategory("HISTORICAL SITES",0,R.drawable.ic_secret_around_me_03));
        sc.add(new SearchCategory("LIGHT HOUSES",20,R.drawable.ic_secret_around_me_04));
        sc.add(new SearchCategory("AMAZING VIEW",3,R.drawable.ic_secret_around_me_01));
        sc.add(new SearchCategory("ART, MUSEUM and THEATERS",20,R.drawable.ic_secret_around_me_02));
        sc.add(new SearchCategory("HISTORICAL SITES",0,R.drawable.ic_secret_around_me_03));
        sc.add(new SearchCategory("LIGHT HOUSES",20,R.drawable.ic_secret_around_me_04));
        sc.add(new SearchCategory("AMAZING VIEW",3,R.drawable.ic_secret_around_me_01));
        sc.add(new SearchCategory("ART, MUSEUM and THEATERS",20,R.drawable.ic_secret_around_me_02));
        sc.add(new SearchCategory("HISTORICAL SITES",0,R.drawable.ic_secret_around_me_03));
        sc.add(new SearchCategory("LIGHT HOUSES",20,R.drawable.ic_secret_around_me_04));

        sbca=new SearchByCategoryAdapter(getActivity(), sc, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
               SearchCategory scPojo= sc.get(position);
                if(scPojo.isChecked())
                    scPojo.setChecked(false);
                else
                    scPojo.setChecked(true);
                sbca.notifyDataSetChanged();
            }
        });
        rvSearchCategory.setAdapter(sbca);

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    for(int i=0;i<sc.size();i++) {
                        sc.get(i).setChecked(true);
                    }
                }
                if(!isChecked){
                    for(int i=0;i<sc.size();i++) {
                        sc.get(i).setChecked(false);
                    }
                }
                sbca.notifyDataSetChanged();
            }
        });


        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.img_blue_arrow){
            ((MainActivity) getActivity()).onBackPressed();
        }
    }
}
