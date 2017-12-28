package com.credosys.solutions.secrect.world;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.credosys.solutions.secrect.world.Adapters.ViewPagerAdapter;
import com.credosys.solutions.secrect.world.Utility.NonSwipeableViewPager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
//    private TextView mTextMessage;
    ImageView imgHomeBanner,imgGradient,imgPlus;
    TextView txtTitle,txtMore;
NonSwipeableViewPager viewPager;
    private TabLayout tabLayout;
    int[] tabIcons={
            R.drawable.ic_home,
            R.drawable.ic_explore,
            R.drawable.ic_more,
            R.drawable.ic_request,
            R.drawable.ic_diary
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        bindViews();

        setupViewPager();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Onpageview","onPageScrolled"+position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Onpageview","onPageSelected"+position);
                if(position==0){
                    imgHomeBanner.setVisibility(View.VISIBLE);
                    setActionBarTitle("MUMBAI");}
                else if(position==1){
                    imgHomeBanner.setVisibility(View.GONE);
                    setActionBarTitle("SECRETS AROUND YOU");
                }
                else if(position==2){
                    imgHomeBanner.setVisibility(View.GONE);
                    setActionBarTitle("MORE");}
                else if(position==3){
                    imgHomeBanner.setVisibility(View.GONE);
                    setActionBarTitle("MY REQUEST");}
                else if(position==4){
                    imgHomeBanner.setVisibility(View.GONE);
                    setActionBarTitle("MY DIARY");
                    tabLayout.setBackgroundColor(getResources().getColor(R.color.marineGreen));
                    Resources res=getApplicationContext().getResources();
                    imgGradient.setColorFilter(res.getColor(R.color.gradientColor));
                    imgPlus.setColorFilter(res.getColor(R.color.cutomGreen));
                    txtMore.setTextColor(Color.WHITE);

                    for(int i=0;i<tabLayout.getTabCount();i++) {
                        if(i!=2) {
                            tabLayout.getTabAt(i).getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
                            tabLayout.setTabTextColors(Color.WHITE,Color.WHITE);
                        }

                    }
                }
                else{setActionBarTitle("NO TITLE");}
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("Onpageview","onPageScrollStateChanged"+state);
            }
        });

    }
    private void bindViews(){
        imgHomeBanner=findViewById(R.id.img_home_banner);
        viewPager = findViewById(R.id.viewpager);
        txtTitle=findViewById(R.id.txt_title);
        imgGradient=findViewById(R.id.iv_gradient);
        imgPlus=findViewById(R.id.img_plus);
        txtMore=findViewById(R.id.txt_more);
    }
    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(3).setIcon(tabIcons[3]);
        tabLayout.getTabAt(4).setIcon(tabIcons[4]);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    public void setActionBarTitle(String title) {
        Log.d("checktitle",title);
//        getSupportActionBar().setTitle(title);
        txtTitle.setText(title);
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
