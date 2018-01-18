package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;

import org.w3c.dom.Text;

/**
 * Created by win7 on 18-Jan-18.
 */

public class MuseumConcertFragment extends Fragment {
    RecyclerView rvMuseumConcert;
    TextView txtCommonAssistance;
    EditText etStartDate;
    public static MuseumConcertFragment newInstance() {
        Bundle args = new Bundle();
        MuseumConcertFragment fragment = new MuseumConcertFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_meuseum_concert,container,false);

        etStartDate=v.findViewById(R.id.et_start_date);
        rvMuseumConcert=v.findViewById(R.id.rv_museum_concert);
        txtCommonAssistance=v.findViewById(R.id.txt_common_assistance);

        txtCommonAssistance.setText("DATE & TIME");
        ((MainActivity)getActivity()).setActionBarTitle("MUSEUMS & CONCERTS");
        ((MainActivity)getActivity()).setExpandableTitle(Gravity.NO_GRAVITY);
        ((MainActivity)getActivity()).setCollpsingImage(R.drawable.topbg);
        ((MainActivity)getActivity()).setAppBarLayoutExpand(false,false);
        ((MainActivity)getActivity()).showBackButton(false);

        rvMuseumConcert.setNestedScrollingEnabled(true);
        etStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DatePickerDialog datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
//                    @Override
//                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
//
//                    }
//                },);
            }
        });
        return v;
    }
}
