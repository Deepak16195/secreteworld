package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.OrderAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.Pojos.App.OrdersSellers;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 12-Jan-18.
 */

public class OrderFragment extends MainFragment {
    RecyclerView rvOrder;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static OrderFragment newInstance() {

        Bundle args = new Bundle();

        OrderFragment fragment = new OrderFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainApp.lockDrawer();
        View v=inflater.inflate(R.layout.fragment_orders_seller,null,false);
        mainApp.setActionBarTitle("MY ORDER");
//        mainApp.setExpandableTitle(Gravity.CENTER);
//        mainApp.setAppBarLayoutExpand(true,true);
        mainApp.showBackButton(true);

        rvOrder=v.findViewById(R.id.rv_order);


        List<OrdersSellers> orders=new ArrayList<>();
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));
        orders.add(new OrdersSellers(true));

        OrderAdapter oa=new OrderAdapter(getActivity(),orders);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrder.setAdapter(oa);
        rvOrder.setLayoutManager(llm);
        rvOrder.setNestedScrollingEnabled(true);
        return v;
    }

}
