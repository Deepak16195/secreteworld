package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.SellerAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.OrdersSellers;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 16-Jan-18.
 */

public class SellerFragment extends MainFragment {
    RecyclerView rvSeller;


    public static SellerFragment newInstance() {

        Bundle args = new Bundle();

        SellerFragment fragment = new SellerFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_orders_seller,null,false);
        ((MainActivity)getActivity()).setActionBarTitle("SELLERS");
        ((MainActivity)getActivity()).lockDrawer();
//        ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
//        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);
        ((MainActivity)getActivity()).showBackButton(true);
        rvSeller =v.findViewById(R.id.rv_order);


        List<OrdersSellers> orders=new ArrayList<>();
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));

        SellerAdapter oa=new SellerAdapter(getActivity(),orders, "SELLERS");
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvSeller.setAdapter(oa);
        rvSeller.setLayoutManager(llm);
        rvSeller.setNestedScrollingEnabled(true);
        return v;
    }
}
