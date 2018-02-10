package com.credosys.solutions.secrete.world;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.CustomItemClickListener;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.NavigationAdapter;
import com.credosys.solutions.secrete.world.Pojos.App.Naviagion;
import com.credosys.solutions.secrete.world.Utility.NonSwipeableViewPager;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.ExploreFragment;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.HomeFragement;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.MyDiaryFragment;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.RequestFragment;
import com.credosys.solutions.secrete.world.fragments.ExploreTab.SearchByCategoryFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ContentsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ExpertFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.FriendsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.MessagesFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.OrderFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.RequestProfileFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.SellerFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.WallFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.AddContentFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.MuseumConcertFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.ProfileFragment;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements  View.OnClickListener {


    FrameLayout frameContainer;
    Typeface tf ;
    ImageView imgHomeBanner, imgPlus, navIconZero ,navIconOne ,navIconTwo ,navIconThree ,navIconFour, imgGradient,imgNavigationCross;
    View viewFixedBottom;
    TextView txtTitle,txtMore,navTextZero,navTextOne,navTextTwo,navTextThree,navTextFour;
    NonSwipeableViewPager viewPager;
    LinearLayout navZero, navOne, navTwo, navThree, navFour,bottomThird,llNav;
    Fragment fragment;
    FragmentTransaction transaction;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private boolean mToolBarNavigationListenerIsRegistered = false;
    Calendar mcurrentTime;
    RelativeLayout rlProfileView;
    RecyclerView rvNavigation;
    MainApplication mainApp;

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("WORKAROUND_FOR_BUG_19917_KEY", "WORKAROUND_FOR_BUG_19917_VALUE");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainApp=MainApplication.getInstance();
        mainApp.setMainActivity(this);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("MUMBAI");

        bindViews();


        drawer = findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       navigationView = findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);


        KeyboardVisibilityEvent.setEventListener(
                this,
                new KeyboardVisibilityEventListener() {
                    @Override
                    public void onVisibilityChanged(boolean isOpen) {
                        viewFixedBottom.setVisibility(isOpen ? View.GONE : View.VISIBLE);
                        llNav.setVisibility(isOpen ? View.GONE : View.VISIBLE);
                        imgGradient.setVisibility(isOpen ? View.GONE : View.VISIBLE);
                    }
                });
//        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                Log.d("Onpageview","onPageScrolled"+position);
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                Log.d("Onpageview","onPageSelected"+position);
//                if(position==0){
//                    imgHomeBanner.setImageResource(R.drawable.launch_banner);
////                    imgHomeBanner.setImageResource(R.drawable.launch_banner);
//                    appBarLayout.setExpanded(true);
//                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);
//                    setFrameLayoutVisiblity();
//                    setActionBarTitle("MUMBAI");
//                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
//                }
//                else if(position==1){
////                    imgHomeBanner.setVisibility(View.GONE);
////                    imgHomeBanner.setImageResource(0);
//                    imgHomeBanner.setImageResource(R.drawable.topbg);
//                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
//
//                    appBarLayout.setExpanded(false);
//                    setFrameLayoutVisiblity();
////                    setActionBarTitle("SECRETS AROUND YOU");
//                    setActionBarTitle("SECRET AROUND YOU");
//                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
//                }
//                else if(position==2){
////                    imgHomeBanner.setVisibility(View.GONE);
////                    imgHomeBanner.setImageResource(0);
//                    imgHomeBanner.setImageResource(R.drawable.topbg);
//                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
//                    appBarLayout.setExpanded(false);
//                    setFrameLayoutVisiblity();
//                    setActionBarTitle("MORE");
//                    getSupportActionBar().setTitle("MORE");
//                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
//                }
//                else if(position==3){
////                    imgHomeBanner.setVisibility(View.GONE);
////                    imgHomeBanner.setImageResource(0);
//                    imgHomeBanner.setImageResource(R.drawable.topbg);
//                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
//                    appBarLayout.setExpanded(false);
//                    setFrameLayoutVisiblity();
//                    setActionBarTitle("MY REQUEST");
//                    getSupportActionBar().setTitle("MY REQUEST");
//                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
//                }
//                else if(position==4){
////                    imgHomeBanner.setVisibility(View.GONE);
////                    imgHomeBanner.setImageResource(0);
//                    imgHomeBanner.setImageResource(R.drawable.topbg);
//                    appBarLayout.setExpanded(false);
//                    setFrameLayoutVisiblity();
//                    setActionBarTitle("MY DIARY");
//                    setTabLayoutColors(R.color.marineGreen,R.color.gradientColor,R.color.cutomGreen,R.color.white,R.color.white);
//                }
//                else{setActionBarTitle("NO TITLE");}
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//                Log.d("Onpageview","onPageScrollStateChanged"+state);
//            }
//        });


        List<Naviagion> list=new ArrayList<Naviagion>();
        list.add(new Naviagion("CHANGE LOCATIONS",R.drawable.ic_nav_location));
        list.add(new Naviagion("SELECT LANGUAGE",R.drawable.ic_nav_language));
        list.add(new Naviagion("SELECT RATE THE APP",R.drawable.ic_nav_star));
        list.add(new Naviagion("TERMS & CONDITIONS",R.drawable.ic_nav_terms_conditions));
        list.add(new Naviagion("PRIVACY POLICY",R.drawable.ic_nav_privacy_policy));
        list.add(new Naviagion("SETTINGS",R.drawable.ic_nav_settings));
        list.add(new Naviagion("LOGOUT",R.drawable.ic_nav_logout));

        NavigationAdapter navigationAdapter = new NavigationAdapter(list, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch(position) {
                    case 0:
//                        viewPager.setVisibility(View.GONE);
//                        frameContainer.setVisibility(View.VISIBLE);
//                        setMuseumConcerts();
//                        break;
                    case 1:
//                        viewPager.setVisibility(View.GONE);
//                        frameContainer.setVisibility(View.VISIBLE);
//                        setAddContent();
                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvNavigation.setLayoutManager(mLayoutManager);
        rvNavigation.setItemAnimator(new DefaultItemAnimator());
        rvNavigation.setAdapter(navigationAdapter);
        setFragments(0,R.drawable.launch_banner,Gravity.CENTER,true,true,true);
    }



    void setFrameLayoutVisiblity(){
        frameContainer.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
    }


    void setTabLayoutColors(int tabLayoutColor,int gradient,int plusIcon,int icon,int text){
        Resources res=getApplicationContext().getResources();
//        tabLayout.setBackgroundColor(getResources().getColor(tabLayoutColor));
        viewFixedBottom.setBackgroundColor(res.getColor(tabLayoutColor));
        imgGradient.setColorFilter(res.getColor(gradient));
        imgPlus.setColorFilter(res.getColor(plusIcon));
        txtMore.setTextColor(res.getColor(text));

        navIconZero.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
        navIconOne.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
        navIconThree.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
        navIconFour.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);

        navTextZero.setTextColor(res.getColor(text));
        navTextOne.setTextColor(res.getColor(text));
        navTextThree.setTextColor(res.getColor(text));
        navTextFour.setTextColor(res.getColor(text));

    }

    private void bindViews(){
        llNav=findViewById(R.id.ll_nav);
        viewFixedBottom =findViewById(R.id.img_fixed_bottom);
        drawer = findViewById(R.id.drawer_layout);
        rlProfileView=findViewById(R.id.rl_profile_view);
        imgNavigationCross=findViewById(R.id.img_navigation_cross);
        imgNavigationCross.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        rvNavigation=findViewById(R.id.rv_navigation);
        imgGradient =findViewById(R.id.iv_gradient);
        imgHomeBanner=findViewById(R.id.img_home_banner);
        frameContainer=findViewById(R.id.frame_container);
        appBarLayout=findViewById(R.id.main_app_bar);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar_layout);

        tf =  Typeface.createFromAsset(getAssets(),"charcoal.ttf");
        collapsingToolbarLayout.setCollapsedTitleTypeface(tf);
        collapsingToolbarLayout.setExpandedTitleTypeface(tf);
        imgPlus=findViewById(R.id.img_plus);
        txtMore=findViewById(R.id.txt_more);
        navZero =findViewById(R.id.nav_zero);
        navOne =findViewById(R.id.nav_one);
        navTwo =findViewById(R.id.nav_two);
        navThree =findViewById(R.id.nav_three);
        navFour =findViewById(R.id.nav_four);

        navIconZero=findViewById(R.id.nav_icon_zero);
        navIconOne=findViewById(R.id.nav_icon_one);
        navIconThree=findViewById(R.id.nav_icon_three);
        navIconFour=findViewById(R.id.nav_icon_four);

        navTextZero=findViewById(R.id.nav_text_zero);
        navTextOne=findViewById(R.id.nav_text_one);
        navTextThree=findViewById(R.id.nav_text_three);
        navTextFour=findViewById(R.id.nav_text_four);

        rlProfileView.setOnClickListener(this);
        navZero.setOnClickListener(this);
        navOne.setOnClickListener(this);
        navTwo.setOnClickListener(this);
        navThree.setOnClickListener(this);
        navFour.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
//        else if(fragment !=null && fragment.getTag().equalsIgnoreCase("category")){
//            viewPager.setVisibility(View.VISIBLE);
//            frameContainer.setVisibility(View.GONE);
//        }
        else if(fragment !=null && fragment.getTag().equalsIgnoreCase("wall")){
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        else {
            super.onBackPressed();
        }

    }
    public void setActionBarTitle(String title) {
        collapsingToolbarLayout.setTitle(title);
    }
    public void setExpandableTitle(int gravity){
        collapsingToolbarLayout.setExpandedTitleGravity(gravity);
    }
    public void setAppBarLayoutExpand(boolean expanded,boolean animate){
        appBarLayout.setExpanded(expanded,animate);
    }

    public void setCollpsingImage(int drawableImage){
        imgHomeBanner.setImageResource(drawableImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

//    @SuppressWarnings("StatementWithEmptyBody")
//    @Override
//    public boolean onNavigationItemSelected(MenuItem item) {
//        // Handle navigation view item clicks here.
//        int id = item.getItemId();
//
//        if (id == R.id.nav_profile) {
//            viewPager.setVisibility(View.GONE);
//            frameContainer.setVisibility(View.VISIBLE);
//            setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
////            imgHomeBanner.setImageResource(R.drawable.topbg);
////            collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
////            collapsingToolbarLayout.setScrollContainer(false);
////            appBarLayout.setExpanded(false,false);
//
//            setActionBarTitle("PROFILE");
//            transaction= getSupportFragmentManager().beginTransaction();
//            transaction.replace(R.id.frame_container,ProfileFragment.newInstance());
//            transaction.addToBackStack(null);
//            transaction.commit();
//        } else if (id == R.id.nav_gallery) {
//            viewPager.setVisibility(View.GONE);
//            frameContainer.setVisibility(View.VISIBLE);
//            setAddContent();
//
//        } else if (id == R.id.nav_slideshow) {
//            viewPager.setVisibility(View.GONE);
//            frameContainer.setVisibility(View.VISIBLE);
//            setMuseumConcerts();
//        } else if (id == R.id.nav_manage) {
//            startActivity(new Intent(MainActivity.this,ProfileStuffActivity.class));
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }

    public void showBackButton(boolean enable) {

        if(enable) {
            // Remove hamburger
            toggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if(!mToolBarNavigationListenerIsRegistered) {
                toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });

                mToolBarNavigationListenerIsRegistered = true;
            }

        } else {
            // Remove back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            // Show hamburger
            toggle.setDrawerIndicatorEnabled(true);
            // Remove the/any drawer toggle listener
            toggle.setToolbarNavigationClickListener(null);
            mToolBarNavigationListenerIsRegistered = false;
        }

    }


    public void setFragments(int loc,int imgTitleBgBanner,int gravity,boolean isToolbarScroll,boolean isExpanded,boolean isExpandedAnimate){
        transaction= getSupportFragmentManager().beginTransaction();
        if(loc>=0 && loc<6) {
            setTabLayoutColors(R.color.white, R.color.white, R.color.customBlue, R.color.tab_layout_text, R.color.tab_layout_text);
            if(mainApp.isDiary()) {

                mainApp.setDiary(false);
            }
            switch (loc) {
                case 0:
                    transaction.replace(R.id.frame_container, HomeFragement.newInstance(), "home");
                    fragment = getSupportFragmentManager().findFragmentByTag("home");
                    break;

                case 1:
                    transaction.replace(R.id.frame_container, ExploreFragment.newInstance(), "explore");
                    fragment = getSupportFragmentManager().findFragmentByTag("explore");
                    break;

                case 3:
                    transaction.replace(R.id.frame_container, RequestFragment.newInstance(), "request");
                    fragment = getSupportFragmentManager().findFragmentByTag("request");
                    break;

                case 4:
                    if(!mainApp.isDiary()) {
                        setTabLayoutColors(R.color.marineGreen, R.color.gradientColor, R.color.cutomGreen, R.color.white, R.color.white);
                        mainApp.setDiary(true);
                    }
                    transaction.replace(R.id.frame_container, MyDiaryFragment.newInstance(), "diary");
                    fragment = getSupportFragmentManager().findFragmentByTag("diary");
                    break;

                case 5:
                    transaction.replace(R.id.frame_container, SearchByCategoryFragment.newInstance(), "category");
                    fragment = getSupportFragmentManager().findFragmentByTag("category");
                    break;

            }
        }


       else if(loc>5 && loc<=10){
            switch (loc){

                case 6:
                    transaction.replace(R.id.frame_container, ContentsFragment.newInstance(), "contents");
                    fragment = getSupportFragmentManager().findFragmentByTag("contents");
                    break;
                case 7:
                    transaction.replace(R.id.frame_container, WallFragment.newInstance(), "wall");
                    fragment = getSupportFragmentManager().findFragmentByTag("wall");
                    break;
                case 8:
                    transaction.replace(R.id.frame_container, FriendsFragment.newInstance(), "friends");
                    fragment = getSupportFragmentManager().findFragmentByTag("friends");
                    break;
                case 9:
                    transaction.replace(R.id.frame_container, MessagesFragment.newInstance(), "messages");
                    fragment = getSupportFragmentManager().findFragmentByTag("messages");
                    break;
            }
        }

      else if(loc>=11 && loc<16){
            switch (loc){


                case 11:
                    transaction.replace(R.id.frame_container, RequestProfileFragment.newInstance(), "proflieRequest");
                    fragment = getSupportFragmentManager().findFragmentByTag("proflieRequest");
                    break;
                case 12:
                    transaction.replace(R.id.frame_container, OrderFragment.newInstance(), "orders");
                    fragment = getSupportFragmentManager().findFragmentByTag("orders");
                    break;
                case 13:
                    transaction.replace(R.id.frame_container, SellerFragment.newInstance(), "sellers");
                    fragment = getSupportFragmentManager().findFragmentByTag("sellers");
                    break;
                case 14:
                    transaction.replace(R.id.frame_container, ExpertFragment.newInstance(), "expert");
                    fragment = getSupportFragmentManager().findFragmentByTag("expert");
                    break;
            }
        }
        transaction.commit();
        setUpTopHeader(imgTitleBgBanner,gravity,isToolbarScroll,isExpanded,isExpandedAnimate);

    }

    public void setAddContent(){// called from ProfileStuff activity
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, AddContentFragment.newInstance(), "addcontent");
        fragment = getSupportFragmentManager().findFragmentByTag("addcontent");
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }


    public void setMuseumConcerts(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, MuseumConcertFragment.newInstance(), "museumconcert");
        fragment = getSupportFragmentManager().findFragmentByTag("museumconcert");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setTimePickerDialog(Context context, final TextView txtStartEndTime){
        mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                mcurrentTime.set(Calendar.YEAR,Calendar.MONTH,Calendar.DATE,hourOfDay,minutes,Calendar.SECOND);
                txtStartEndTime.setText(new SimpleDateFormat("hh:mm a", Locale.US).format(mcurrentTime.getTime()));
            }
        },hour,minute,false);
        timePickerDialog.setTitle(getString(R.string.mc_select_time));
        timePickerDialog.show();
    }



    public void setProfile(){
//        setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
        setActionBarTitle("PROFILE");
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container,ProfileFragment.newInstance());
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void setUpTopHeader(int imgTitleBgBanner,int gravity,boolean isToolbarScroll,boolean isExpanded,boolean isExpandedAnimate){
        imgHomeBanner.setImageResource(imgTitleBgBanner);
        collapsingToolbarLayout.setExpandedTitleGravity(gravity);
        collapsingToolbarLayout.setScrollContainer(isToolbarScroll);
        appBarLayout.setExpanded(isExpanded,isExpandedAnimate);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nav_zero:
                setFragments(0,R.drawable.launch_banner,Gravity.CENTER,true,true,true);
                break;
            case R.id.nav_one:
                setFragments(1,R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
                break;
            case R.id.nav_two:
                Intent i2 = new Intent(MainActivity.this, ProfileStuffActivity.class);
                startActivity(i2);
                overridePendingTransition(R.anim.slide_up_info, R.anim.no_change);
                break;
            case R.id.nav_three:
                setFragments(3,R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
                break;
            case R.id.nav_four:
                setFragments(4,R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
                break;

            case R.id.rl_profile_view:
                setUpTopHeader(R.drawable.topbg,Gravity.NO_GRAVITY,false,false,false);
                setActionBarTitle("PROFILE");
                transaction= getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container,ProfileFragment.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
