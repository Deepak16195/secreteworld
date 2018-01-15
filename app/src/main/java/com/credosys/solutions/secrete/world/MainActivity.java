package com.credosys.solutions.secrete.world;

import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.credosys.solutions.secrete.world.Adapters.ViewPagers.BottomNavigationViewPagerAdapter;
import com.credosys.solutions.secrete.world.Utility.NonSwipeableViewPager;
import com.credosys.solutions.secrete.world.fragments.ExploreTab.SearchByCategoryFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ContentsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ExpertFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.FriendsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.MessagesFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.OrderFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.RequestProfileFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.WallFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.AddContentFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.ProfileFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
//    private TextView mTextMessage;
    FrameLayout frameContainer;
    Typeface tf ;
    ImageView imgHomeBanner, imgGradient, imgPlus, navIconZero ,navIconOne ,navIconTwo ,navIconThree ,navIconFour;
    TextView txtTitle,txtMore,navTextZero,navTextOne,navTextTwo,navTextThree,navTextFour;
    NonSwipeableViewPager viewPager;
    LinearLayout navZero, navOne, navTwo, navThree, navFour;
    BottomNavigationViewPagerAdapter adapter;
    private TabLayout tabLayout;
    Fragment fragment;
    FragmentTransaction transaction;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    DrawerLayout drawer;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    private boolean mToolBarNavigationListenerIsRegistered = false;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("MUMBAI");
        bindViews();
        setupViewPager();

        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();

         drawer = findViewById(R.id.drawer_layout);
      toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

       navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Log.d("homeNavigationMain",getSupportActionBar().getDisplayOptions()+"");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("Onpageview","onPageScrolled"+position);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("Onpageview","onPageSelected"+position);
                if(position==0){
                    imgHomeBanner.setImageResource(R.drawable.launch_banner);
//                    imgHomeBanner.setImageResource(R.drawable.launch_banner);
                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.CENTER);
                    setFrameLayoutVisiblity();
                    setActionBarTitle("MUMBAI");

                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
                }
                else if(position==1){
//                    imgHomeBanner.setVisibility(View.GONE);
//                    imgHomeBanner.setImageResource(0);
                    imgHomeBanner.setImageResource(R.drawable.topbg);
                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);

                    appBarLayout.setExpanded(false);
                    setFrameLayoutVisiblity();
//                    setActionBarTitle("SECRETS AROUND YOU");
                    setActionBarTitle("SECRETE AROUND YOU");
                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
                }
                else if(position==2){
//                    imgHomeBanner.setVisibility(View.GONE);
//                    imgHomeBanner.setImageResource(0);
                    imgHomeBanner.setImageResource(R.drawable.topbg);
                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
                    appBarLayout.setExpanded(false);
                    setFrameLayoutVisiblity();
                    setActionBarTitle("MORE");
                    getSupportActionBar().setTitle("MORE");
                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
                }
                else if(position==3){
//                    imgHomeBanner.setVisibility(View.GONE);
//                    imgHomeBanner.setImageResource(0);
                    imgHomeBanner.setImageResource(R.drawable.topbg);
                    collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
                    appBarLayout.setExpanded(false);
                    setFrameLayoutVisiblity();
                    setActionBarTitle("MY REQUEST");
                    getSupportActionBar().setTitle("MY REQUEST");
                    setTabLayoutColors(R.color.white,R.color.white,R.color.customBlue,R.color.tab_layout_text,R.color.tab_layout_text);
                }
                else if(position==4){
//                    imgHomeBanner.setVisibility(View.GONE);
//                    imgHomeBanner.setImageResource(0);
                    imgHomeBanner.setImageResource(R.drawable.topbg);
                    appBarLayout.setExpanded(false);
                    setFrameLayoutVisiblity();
                    setActionBarTitle("MY DIARY");
                    setTabLayoutColors(R.color.marineGreen,R.color.gradientColor,R.color.cutomGreen,R.color.white,R.color.white);
                }
                else{setActionBarTitle("NO TITLE");}
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Log.d("Onpageview","onPageScrollStateChanged"+state);
            }
        });

    }

    void setFrameLayoutVisiblity(){
        frameContainer.setVisibility(View.GONE);
        viewPager.setVisibility(View.VISIBLE);
    }


    void setTabLayoutColors(int tabLayoutColor,int gradient,int plusIcon,int icon,int text){
        Resources res=getApplicationContext().getResources();
        tabLayout.setBackgroundColor(getResources().getColor(tabLayoutColor));
        imgGradient.setColorFilter(res.getColor(gradient));
        imgPlus.setColorFilter(res.getColor(plusIcon));
        txtMore.setTextColor(res.getColor(text));

        for(int i=0;i<tabLayout.getTabCount();i++) {
//            if(i!=2) {
//                tabLayout.getTabAt(i).getIcon().setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
//                tabLayout.setTabTextColors(res.getColor(tabUnseleced),res.getColor(tabSelected));
//            }
            switch(i) {
                case 0:
                    navIconZero.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
                    navTextZero.setTextColor(res.getColor(text));
                    break;
                case 1:
                    navIconOne.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
                    navTextOne.setTextColor(res.getColor(text));
                    break;
                case 3:
                    navIconThree.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
                    navTextThree.setTextColor(res.getColor(text));
                    break;
                case 4:
                    navIconFour.setColorFilter(res.getColor(icon), PorterDuff.Mode.SRC_IN);
                    navTextFour.setTextColor(res.getColor(text));
            }

        }
    }
    private void bindViews(){
        imgHomeBanner=findViewById(R.id.img_home_banner);
        viewPager = findViewById(R.id.viewpager);
        frameContainer=findViewById(R.id.frame_container);
        appBarLayout=findViewById(R.id.main_app_bar);
        collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar_layout);

        tf =  Typeface.createFromAsset(getAssets(),"charcoal.ttf");
        collapsingToolbarLayout.setCollapsedTitleTypeface(tf);
        collapsingToolbarLayout.setExpandedTitleTypeface(tf);

//        txtTitle=findViewById(R.id.txt_title);
        imgGradient=findViewById(R.id.iv_gradient);
        imgPlus=findViewById(R.id.img_plus);
        txtMore=findViewById(R.id.txt_more);

        View navView= LayoutInflater.from(this).inflate(R.layout.navigation,null,false);
        navZero =navView.findViewById(R.id.nav_zero);
        navOne =navView.findViewById(R.id.nav_one);
        navTwo =navView.findViewById(R.id.nav_two);
        navThree =navView.findViewById(R.id.nav_three);
        navFour =navView.findViewById(R.id.nav_four);

        navIconZero=navView.findViewById(R.id.nav_icon_zero);
        navIconOne=navView.findViewById(R.id.nav_icon_one);
        navIconThree=navView.findViewById(R.id.nav_icon_three);
        navIconFour=navView.findViewById(R.id.nav_icon_four);

        navTextZero=navView.findViewById(R.id.nav_text_zero);
        navTextOne=navView.findViewById(R.id.nav_text_one);
        navTextThree=navView.findViewById(R.id.nav_text_three);
        navTextFour=navView.findViewById(R.id.nav_text_four);

        imgPlus.setOnClickListener(this);
    }
    private void setupViewPager() {
        adapter = new BottomNavigationViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }
    private void setupTabIcons(){
        tabLayout.getTabAt(0).setCustomView(navZero);
        tabLayout.getTabAt(1).setCustomView(navOne);
        tabLayout.getTabAt(2).setCustomView(navTwo);
        tabLayout.getTabAt(3).setCustomView(navThree);
        tabLayout.getTabAt(4).setCustomView(navFour);
    }
    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(fragment !=null && fragment.getTag().equalsIgnoreCase("category")){
            viewPager.setVisibility(View.VISIBLE);
            frameContainer.setVisibility(View.GONE);
        }
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
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            viewPager.setVisibility(View.GONE);
            frameContainer.setVisibility(View.VISIBLE);
//            imgHomeBanner.setImageResource(R.drawable.topbg);
//            collapsingToolbarLayout.setExpandedTitleGravity(Gravity.NO_GRAVITY);
//            collapsingToolbarLayout.setScrollContainer(false);
//            appBarLayout.setExpanded(false,false);

            setActionBarTitle("PROFILE");
            transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container,ProfileFragment.newInstance());
            transaction.addToBackStack(null);
            transaction.commit();
        } else if (id == R.id.nav_gallery) {
            viewPager.setVisibility(View.GONE);
            frameContainer.setVisibility(View.VISIBLE);
            setAddContent();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

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
    public void setCategoryFragment(){
            viewPager.setVisibility(View.GONE);
            frameContainer.setVisibility(View.VISIBLE);
            transaction= getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.frame_container, SearchByCategoryFragment.newInstance(), "category");
            fragment = getSupportFragmentManager().findFragmentByTag("category");
            transaction.addToBackStack(null);
            transaction.commit();
    }

    public void setContents(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, ContentsFragment.newInstance(), "contents");
        fragment = getSupportFragmentManager().findFragmentByTag("contents");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setWall(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, WallFragment.newInstance(), "wall");
        fragment = getSupportFragmentManager().findFragmentByTag("wall");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void setFriends(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, FriendsFragment.newInstance(), "friends");
        fragment = getSupportFragmentManager().findFragmentByTag("friends");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setMessages(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, MessagesFragment.newInstance(), "messages");
        fragment = getSupportFragmentManager().findFragmentByTag("messages");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    public void setProfileRequest(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, RequestProfileFragment.newInstance(), "proflieRequest");
        fragment = getSupportFragmentManager().findFragmentByTag("proflieRequest");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setOrders(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, OrderFragment.newInstance(), "orders");
        fragment = getSupportFragmentManager().findFragmentByTag("orders");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setExpert(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, ExpertFragment.newInstance(), "expert");
        fragment = getSupportFragmentManager().findFragmentByTag("expert");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setAddContent(){
        transaction= getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, AddContentFragment.newInstance(), "addcontent");
        fragment = getSupportFragmentManager().findFragmentByTag("addcontent");
        transaction.addToBackStack(null);
        transaction.commit();
    }
    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.img_plus){
            viewPager.setCurrentItem(2,true);
        }
    }
}
