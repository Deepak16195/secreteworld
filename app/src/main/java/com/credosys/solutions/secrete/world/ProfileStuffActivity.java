package com.credosys.solutions.secrete.world;

import android.app.Activity;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.FriendsAdapter;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.ProfileStuffAdapter;
import com.credosys.solutions.secrete.world.Pojos.App.ProfileStuff;

import java.util.ArrayList;
import java.util.List;

public class ProfileStuffActivity extends Activity implements View.OnClickListener {
ImageView cross;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
//        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile_stuff);

        cross=findViewById(R.id.img_cross_profile_stuff);

        cross.setColorFilter(getResources().getColor(R.color.cutomGreen), PorterDuff.Mode.SRC_IN);

        Animation startRotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.android_rotate_animation);
        cross.startAnimation(startRotateAnimation);
        cross.setOnClickListener(this);
        RecyclerView rvProfileStuff=findViewById(R.id.rv_profile_stuff);
        List<ProfileStuff> list= new ArrayList<>();
        list.add(new ProfileStuff(R.drawable.profile_stuff_pencil,"ADD\nCONTENT"));
        list.add(new ProfileStuff(R.drawable.profile_stuff_cam,"ADD TRIP \n ALBUM"));
        list.add(new ProfileStuff(R.drawable.profile_stuff_trip,"ADD TRIP \n DIARY"));
        list.add(new ProfileStuff(R.drawable.profile_stuff_location,"ADD \n ITIEARY"));
        list.add(new ProfileStuff(R.drawable.profile_stuff_calendar,"ADD \n EVENT"));
        list.add(new ProfileStuff(R.drawable.profile_stuff_drama,"MUSEUMS &\nCONCERTS"));
        list.add(new ProfileStuff(R.drawable.main_screens_23,"STRANGER\nANDGELS"));
        list.add(new ProfileStuff(R.drawable.main_screens_22,"QUICK\nREQUEST"));
        list.add(new ProfileStuff(R.drawable.profle_stuff_qrcode,"QR CODE\nSCANNER"));

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,3);
        rvProfileStuff.setLayoutManager(mLayoutManager);
        ProfileStuffAdapter fa=new ProfileStuffAdapter(list);
        rvProfileStuff.setAdapter(fa);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.no_change,R.anim.slide_down_info);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_cross_profile_stuff:
                onBackPressed();
                break;
        }
    }
}
