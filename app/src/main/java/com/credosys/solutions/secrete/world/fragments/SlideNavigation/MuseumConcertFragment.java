package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.SplitAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by win7 on 18-Jan-18.
 */

public class MuseumConcertFragment extends MainFragment implements View.OnClickListener {
    RecyclerView rvMuseumConcert;
    TextView txtCommonAssistance;
    TextView txtStartDate, txtEndDate;
    DatePickerDialog datePickerDialog;
    Calendar calendar = Calendar.getInstance();
    int mYear, mMonth, mDay;
    List<Date> dateList;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();

    public static MuseumConcertFragment newInstance() {
        Bundle args = new Bundle();
        MuseumConcertFragment fragment = new MuseumConcertFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_meuseum_concert, container, false);

        txtStartDate = v.findViewById(R.id.txt_start_date);
        txtEndDate = v.findViewById(R.id.txt_end_date);
        rvMuseumConcert = v.findViewById(R.id.rv_museum_concert);
        txtCommonAssistance = v.findViewById(R.id.txt_common_assistance);
        txtCommonAssistance.setText(R.string.mc_txt_assistance_title);

        txtStartDate.setOnClickListener(this);
        txtEndDate.setOnClickListener(this);

        mainApp.setActionBarTitle("MUSEUMS & CONCERTS");
        mainApp.setExpandableTitle(Gravity.NO_GRAVITY);
        mainApp.setCollpsingImage(R.drawable.topbg);
        mainApp.setAppBarLayoutExpand(false, false);
        mainApp.showBackButton(false);

        rvMuseumConcert.setNestedScrollingEnabled(true);

        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.txt_start_date:
                setDatePickerDialog(txtStartDate);
                break;
            case R.id.txt_end_date:
                setDatePickerDialog(txtEndDate);
                break;
        }
    }

    public void setDatePickerDialog(final TextView txtView) {
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtView.setText(getString(R.string.mc_start_date_set, dayOfMonth, month + 1, year));
                if (txtView.getId() == R.id.txt_end_date)
                    gotoSplit();
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void gotoSplit() {
        dateDifferenceAndDateList();
//        View inflate=LayoutInflater.from(getActivity()).inflate(R.layout.single_common_start_end_time,null,false);
        SplitAdapter sa=new SplitAdapter(getActivity(),dateList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rvMuseumConcert.setLayoutManager(mLayoutManager);
        rvMuseumConcert.setItemAnimator(new DefaultItemAnimator());
        rvMuseumConcert.setAdapter(sa);
        sa.notifyDataSetChanged();
    }

    private void dateDifferenceAndDateList() {
        long diffDays = 0;
        try {
            Date d1 = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(txtStartDate.getText()));
            Date d2 = new SimpleDateFormat("dd/MM/yyyy").parse(String.valueOf(txtEndDate.getText()));
            long diff = Math.abs(d1.getTime() - d2.getTime());
            diffDays = diff / (24 * 60 * 60 * 1000);
           prepareDaysList(d1,d2,diffDays);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("dateDiff", "" + diffDays);

    }
    private void prepareDaysList(Date d1,Date d2,long diffDays){

        Calendar calendar=Calendar.getInstance();
        calendar.setTime(d1);
        Log.d("newIncrementDate",calendar.getTime()+"");
        dateList=new ArrayList<>();
        dateList.add(d1);
        for(long i=0;i<diffDays;i++){
            calendar.add(Calendar.DATE, 1);
            dateList.add(calendar.getTime());
            Log.d("newIncrementDate", calendar.getTime()+"");
        }
        Log.d("newIncrementDate", "list start");
//        for(int i=0;i<dateList.size();i++){
//            calendar.setTime(dateList.get(i));
//            Log.d("newIncrementDate",calendar.getTime()+"");
//        }
    }
}


