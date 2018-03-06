package com.credosys.solutions.secrete.world.fragments.SlideNavigation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.Utility.CommonAssistance;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.Calendar;


/**
 * Created by SONY on 14-01-18.
 */

public class AddContentFragment extends MainFragment implements View.OnClickListener {
    LinearLayout llMain,rlPicExpand,LlAssistance;
    RelativeLayout llTitle,llCategory,llDesc,llExtdesc,llTag,llPic,llLocation;
    RelativeLayout rlTitleExpand,rlCategoryExpand,rlDescExpand,rlExtdescExpand,rlTagExpand,rlLocationExpand;
    ScrollView svMain;
    LinearLayout llDate,llTime;
    Animation slide_down;
    Calendar calendar = Calendar.getInstance();
    int mYear, mMonth, mDay,hour,minute;
    DatePickerDialog datePickerDialog;
    TimePickerDialog timePickerDialog;
    TextView txtDate,txtTime;
    ImageView[] l;
    ImageView[] a;
    String[] colors={"FF422B","EC1660","0055AE","007CEE","008E80","82BB51","CAD441"};

//   ExpandableRelativeLayout rlTitleExpand;
    public static AddContentFragment newInstance(int titleIndex) {

        Bundle args = new Bundle();
        args.putInt("position",titleIndex);
        AddContentFragment fragment = new AddContentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_common_content,container,false);
        ViewStub simpleViewStub = v.findViewById(R.id.vs_all);
        simpleViewStub.setLayoutResource(R.layout.view_stub_and_content);
        View inflated = simpleViewStub.inflate();
        TextView txtCommonAssistance=inflated.findViewById(R.id.txt_common_assistance);

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int myInt = bundle.getInt("position", 0);
            switch (myInt){
                case 1:
                    ((MainActivity)getActivity()).setActionBarTitle("ADD CONTENT");
                    txtCommonAssistance.setText("MY CONTENT");

//                    ((MainActivity)getActivity()).setCollpsingImage(R.drawable.topbg);
//                    ((MainActivity)getActivity()).setExpandableTitle(Gravity.CENTER);
//                    ((MainActivity)getActivity()).setAppBarLayoutExpand(true,true);

                    break;
                case 2:
                    ((MainActivity)getActivity()).setActionBarTitle("ADD TRIP ALBUM");
                    txtCommonAssistance.setText("MY ALBUM");
                    break;
                case 3:
                    ((MainActivity)getActivity()).setActionBarTitle("ADD TRIP DIARY");
                    txtCommonAssistance.setText("MY DIARY");
                    break;
                case 4:
                    ((MainActivity)getActivity()).setActionBarTitle("ADD ITINERARY");
                    txtCommonAssistance.setText("MY ITINERARY");
                    break;
                case 5:
                    ((MainActivity)getActivity()).setActionBarTitle("ADD EVENT");
                    txtCommonAssistance.setText("MY EVENT");
                    break;

            }
            ((MainActivity)getActivity()).setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
            ((MainActivity)getActivity()).showBackButton(false);
        }


        llMain=inflated.findViewById(R.id.ll_main_addcontent);
        llTitle=inflated.findViewById(R.id.ll_addcontent_title);
        rlTitleExpand=inflated.findViewById(R.id.rl_title_expand);
        svMain=inflated.findViewById(R.id.sv_main);
        llCategory=inflated.findViewById(R.id.ll_addcontent_category);
        rlCategoryExpand=inflated.findViewById(R.id.rl_category_expand);
        llDesc=inflated.findViewById(R.id.ll_addcontent_description);
        rlDescExpand=inflated.findViewById(R.id.rl_description_expand);
        llExtdesc=inflated.findViewById(R.id.ll_addcontent_extdesc);
        rlExtdescExpand=inflated.findViewById(R.id.rl_extdesc_expand);
        llTag=inflated.findViewById(R.id.ll_addcontent_tag);
        rlTagExpand=inflated.findViewById(R.id.rl_tag_expand);
        llPic=inflated.findViewById(R.id.ll_addcontent_pic);
        rlPicExpand=inflated.findViewById(R.id.rl_pic_expand);
        llLocation=inflated.findViewById(R.id.ll_addcontent_location);
        rlLocationExpand=inflated.findViewById(R.id.rl_location_expand);
        llDate=inflated.findViewById(R.id.ll_date);
        llTime=inflated.findViewById(R.id.ll_time);
        txtDate=inflated.findViewById(R.id.txt_date);
        txtTime=inflated.findViewById(R.id.txt_time);
        LlAssistance = inflated.findViewById(R.id.ll_assistance);


        l=new ImageView[7];
        a=new ImageView[7];
        l[0]=inflated.findViewById(R.id.l1);
        l[1]=inflated.findViewById(R.id.l2);
        l[2]=inflated.findViewById(R.id.l3);
        l[3]=inflated.findViewById(R.id.l4);
        l[4]=inflated.findViewById(R.id.l5);
        l[5]=inflated.findViewById(R.id.l6);
        l[6]=inflated.findViewById(R.id.l7);

        a[0]=inflated.findViewById(R.id.a1);
        a[1]=inflated.findViewById(R.id.a2);
        a[2]=inflated.findViewById(R.id.a3);
        a[3]=inflated.findViewById(R.id.a4);
        a[4]=inflated.findViewById(R.id.a5);
        a[5]=inflated.findViewById(R.id.a6);
        a[6]=inflated.findViewById(R.id.a7);

        llTitle.setOnClickListener(this);
        llCategory.setOnClickListener(this);
        llDesc.setOnClickListener(this);
        llExtdesc.setOnClickListener(this);
        llTag.setOnClickListener(this);
        llPic.setOnClickListener(this);
        llLocation.setOnClickListener(this);
        llDate.setOnClickListener(this);
        llTime.setOnClickListener(this);
        LlAssistance.setOnClickListener(this);

        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDay = calendar.get(Calendar.DAY_OF_MONTH);
        hour= calendar.get(Calendar.HOUR_OF_DAY);
        minute=calendar.get(Calendar.MINUTE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            svMain.setNestedScrollingEnabled(true);
        }
        for(int i=0;i<7;i++) {
            int myColor = Color.parseColor("#" + colors[i]);
            l[i].setColorFilter(myColor, android.graphics.PorterDuff.Mode.SRC_IN);
            a[i].setColorFilter(myColor, android.graphics.PorterDuff.Mode.SRC_IN);
        }
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_addcontent_title:
                 rlTitleExpand.setVisibility(View.VISIBLE);
                 rlCategoryExpand.setVisibility(View.GONE);
                 rlDescExpand.setVisibility(View.GONE);
                 rlExtdescExpand.setVisibility(View.GONE);
                 rlTagExpand.setVisibility(View.GONE);
                 rlPicExpand.setVisibility(View.GONE);
                  rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_category:
                rlCategoryExpand.setVisibility(View.VISIBLE);
                rlTitleExpand.setVisibility(View.GONE);
                rlDescExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_description:
                rlDescExpand.setVisibility(View.VISIBLE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_extdesc:
                rlExtdescExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_tag:
                rlTagExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_pic:
                rlPicExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlLocationExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_addcontent_location:
                rlLocationExpand.setVisibility(View.VISIBLE);
                rlDescExpand.setVisibility(View.GONE);
                rlCategoryExpand.setVisibility(View.GONE);
                rlTitleExpand.setVisibility(View.GONE);
                rlExtdescExpand.setVisibility(View.GONE);
                rlTagExpand.setVisibility(View.GONE);
                rlPicExpand.setVisibility(View.GONE);
                break;
            case R.id.ll_date:
                setDatePickerDialog();
                break;
            case R.id.ll_time:
                setTime();
                break;
            case R.id.ll_assistance:
                new CommonAssistance(getActivity(),LlAssistance).show();
                break;

        }
    }

    private void setTime(){
        timePickerDialog= new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                txtTime.setText(hourOfDay+" "+minute);
            }
        },hour, minute, false);
        timePickerDialog.show();
    }

    private void setDatePickerDialog() {
        datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                txtDate.setText(getString(R.string.mc_start_date_set, dayOfMonth, month + 1, year));
            }
        }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
