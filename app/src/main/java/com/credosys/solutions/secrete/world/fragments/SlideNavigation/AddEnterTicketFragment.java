package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.Utility.CommonAssistance;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

/**
 * Created by credosys on 20/2/18.
 */

public class AddEnterTicketFragment extends MainFragment implements View.OnClickListener {
    LinearLayout LlAssistance;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static AddEnterTicketFragment newInstance() {

        Bundle args = new Bundle();

        AddEnterTicketFragment fragment = new AddEnterTicketFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        mainApp.setActionBarTitle("MUSEUMS & CONCERTS");
        mainApp.setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY,false,false,false);
        ViewStub viewStub=v.findViewById(R.id.vs_all);
        viewStub.setLayoutResource(R.layout.view_stub_add_enter_ticket);
        View inflated=viewStub.inflate();

        LlAssistance = inflated.findViewById(R.id.ll_assistance);
        LlAssistance.setOnClickListener(this);
        TextView txtCommonAssistance=inflated.findViewById(R.id.txt_common_assistance);
        txtCommonAssistance.setText("ENTER A TICKET");

        Spinner spinCategory=inflated.findViewById(R.id.spin_category);
        Spinner spinPerUnit=inflated.findViewById(R.id.spin_per_unit);
        Spinner spinCurrency=inflated.findViewById(R.id.spin_currency);

        ArrayAdapter adapterCategory=new ArrayAdapter(getActivity(),R.layout.spin_layout,new String[]{"TICKET FOR SALE","TICKET FOR PURCHASE"});
        ArrayAdapter adapterPerUnit=new ArrayAdapter(getActivity(),R.layout.spin_layout,new String[]{"TICKET FOR SALE PER UNIT OF TIME","TICKET FOR PURCHASE"});
        ArrayAdapter adapterCurrency=new ArrayAdapter(getActivity(),R.layout.spin_layout,new String[]{"CURRENCY","RS.","DOLLAR"});

        spinCategory.setAdapter(adapterCategory);
        spinPerUnit.setAdapter(adapterPerUnit);
        spinCurrency.setAdapter(adapterCurrency);
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_assistance:
                new CommonAssistance(getActivity(),LlAssistance).show();
                break;
        }
    }
}
