package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.TicketAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.Pojos.App.Ticket;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;
import com.vipulasri.ticketview.TicketView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yogesh on 15-Feb-18.
 */

public class TicketFragment extends MainFragment implements View.OnClickListener{
    ImageView imgTicketAdd;
    public static TicketFragment newInstance() {

        Bundle args = new Bundle();

        TicketFragment fragment = new TicketFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ((MainActivity)getActivity()).setActionBarTitle("MUSEUMS & CONCERTS");
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.NO_GRAVITY);
        ((MainActivity)getActivity()).setCollpsingImage(R.drawable.topbg);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);

        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub simpleViewStub = v.findViewById(R.id.vs_all);
        simpleViewStub.setLayoutResource(R.layout.view_stub_museum_add_concert_ticket);
        View inflated = simpleViewStub.inflate();
        imgTicketAdd=inflated.findViewById(R.id.img_ticket_add);
        TextView txtCommonAssistance=inflated.findViewById(R.id.txt_common_assistance);
        txtCommonAssistance.setText("TICKETS");
        RecyclerView rvTicket=inflated.findViewById(R.id.rv_ticket);

        List<Ticket> list=new ArrayList<Ticket>();
        list.add(new Ticket("01","TITLE","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.","69","32"));
        list.add(new Ticket("01","TITLE","It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout.","69","32"));

        TicketAdapter mAdapter = new TicketAdapter(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvTicket.setLayoutManager(mLayoutManager);
        rvTicket.setItemAnimator(new DefaultItemAnimator());
        rvTicket.setAdapter(mAdapter);


        TicketView ticketView=inflated.findViewById(R.id.ticketView);

        imgTicketAdd.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_ticket_add:
                ((MainActivity)getActivity()).setFragments(20);
                break;
        }
    }
}
