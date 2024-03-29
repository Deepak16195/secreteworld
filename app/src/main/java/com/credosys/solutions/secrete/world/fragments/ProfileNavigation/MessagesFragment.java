package com.credosys.solutions.secrete.world.fragments.ProfileNavigation;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.MessagesAdapter;
import com.credosys.solutions.secrete.world.MainActivity;
import com.credosys.solutions.secrete.world.MainApplication;
import com.credosys.solutions.secrete.world.Pojos.App.Messages;
import com.credosys.solutions.secrete.world.R;
import com.credosys.solutions.secrete.world.fragments.MainFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by win7 on 11-Jan-18.
 */

public class MessagesFragment extends MainFragment {
    ListView LvMessages;
    MainActivity mainApp = MainApplication.getInstance().getMainActivity();
    public static MessagesFragment newInstance() {

        Bundle args = new Bundle();

        MessagesFragment fragment = new MessagesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainApp.lockDrawer();
        View v=inflater.inflate(R.layout.fragment_messages,null,false);
        mainApp.setActionBarTitle("MY MESSAGE");
        mainApp.setUpTopHeader(R.drawable.topbg,Gravity.CENTER,true,true,true);
//        mainApp.setExpandableTitle(Gravity.CENTER);
//        mainApp.setAppBarLayoutExpand(true,true);
        mainApp.showBackButton(true);

        LvMessages=v.findViewById(R.id.lv_message);
        MessagesAdapter ma=new MessagesAdapter(getActivity(),getTemp());
        LvMessages.setAdapter(ma);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            LvMessages.setNestedScrollingEnabled(true);
        }
        return v;
    }
    List<Messages> getTemp() {
        List<Messages> list=new ArrayList<>();
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p1));
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p2));
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p3));
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p4));
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p5));
        list.add(new Messages("MARCO ALENSSANDO","its long establish fact its long establish fact",R.drawable.p6));



        return  list;
    }
}
