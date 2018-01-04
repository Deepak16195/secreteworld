package com.credosys.solutions.secrect.world.fragments.ExploreTab;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrect.world.R;

/**
 * Created by win7 on 03-Jan-18.
 */

public class SearchByCategoryFragment extends Fragment {
    RecyclerView rvSearchCategory;
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
        return v;
    }
}
