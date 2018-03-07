package com.credosys.solutions.secrete.world;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
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
import com.credosys.solutions.secrete.world.Pojos.App.Navigation;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.ExploreFragment;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.HomeFragement;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.MyDiaryFragment;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.RequestFragment;
import com.credosys.solutions.secrete.world.fragments.ExploreTab.SearchByCategoryFragment;
import com.credosys.solutions.secrete.world.fragments.MapViewFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ContentsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ExpertFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.FriendsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.InviteFriendsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.MessagesFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.OrderFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.ProfileDetailsFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.RequestProfileFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.SellerFragment;
import com.credosys.solutions.secrete.world.fragments.ProfileNavigation.WallFragment;
import com.credosys.solutions.secrete.world.fragments.More.AddContentFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.AddEnterTicketFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.ExpertUserFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.GetPrimiumFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.MuseumConcertFragment;
import com.credosys.solutions.secrete.world.fragments.BottomNaviagion.ProfileFragment;
import com.credosys.solutions.secrete.world.fragments.More.QuickRequestFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.RecommendedPlacesFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.SellerUserFragment;
import com.credosys.solutions.secrete.world.fragments.More.StrangleAnglesFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.TicketFragment;
import com.credosys.solutions.secrete.world.fragments.SlideNavigation.WhereEatFragment;

import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEvent;
import net.yslibrary.android.keyboardvisibilityevent.KeyboardVisibilityEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {


    FrameLayout frameContainer;
    Typeface tf;
    ImageView imgHomeBanner, imgPlus, navIconZero, navIconOne, navIconTwo, navIconThree, navIconFour, imgGradient/*, imgNavigationCross*/;
    View viewFixedBottom;
    TextView txtTitle, txtMore, navTextZero, navTextOne, navTextTwo, navTextThree, navTextFour, txtToolbar;
    LinearLayout navZero, navOne, navTwo, navThree, navFour, bottomThird, llNav;
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
        mainApp = MainApplication.getInstance();
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


        List<Navigation> list = new ArrayList<Navigation>();
        list.add(new Navigation("MY CONTENT", R.drawable.ic_my_content));
        list.add(new Navigation("SELL TICKET", R.drawable.ic_ticket));
        list.add(new Navigation("CHANGE LOCATIONS", R.drawable.ic_nav_location));
        list.add(new Navigation("SELECT LANGUAGE", R.drawable.ic_nav_language));
//        list.add(new Navigation("SELECT RATE THE APP", R.drawable.ic_nav_star));
        list.add(new Navigation("TERMS & CONDITIONS", R.drawable.ic_nav_terms_conditions));
        list.add(new Navigation("PRIVACY POLICY", R.drawable.ic_nav_privacy_policy));
        list.add(new Navigation("SETTINGS", R.drawable.ic_nav_settings));
        list.add(new Navigation("LOGOUT", R.drawable.ic_nav_logout));

        NavigationAdapter navigationAdapter = new NavigationAdapter(list, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {
                    case 0:
                      Handler handler=new Handler();
                      handler.postDelayed(new Runnable() {
                          @Override
                          public void run() {
                              openMore();
                          }
                      },500);
                        break;
                    case 1:
                        setFragments(17);
                        break;
                    case 2:

                        break;
                    case 3:

                        break;
                }
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvNavigation.setLayoutManager(mLayoutManager);
        rvNavigation.setItemAnimator(new DefaultItemAnimator());
        rvNavigation.setAdapter(navigationAdapter);
        setFragments(0);

        setUpTopHeader(R.drawable.launch_banner, Gravity.CENTER, true, true, true);
    }


    public void setConfigToolbar(int gradient) {
        toolbar.setBackgroundResource(gradient);
    }

    public void lockDrawer() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }
    public void unlockDrawer(){
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    public void setOverlap(int dimen) {
        CoordinatorLayout.LayoutParams params =
                (CoordinatorLayout.LayoutParams) frameContainer.getLayoutParams();
        AppBarLayout.ScrollingViewBehavior behavior =
                (AppBarLayout.ScrollingViewBehavior) params.getBehavior();
        behavior.setOverlayTop((int) getResources().getDimension(dimen));
    }

    public void setTabLayoutColors(int tabLayoutColor, int gradient, int plusIcon, int icon, int text) {
        Resources res = getApplicationContext().getResources();
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

    private void bindViews() {
        llNav = findViewById(R.id.ll_nav);
        viewFixedBottom = findViewById(R.id.img_fixed_bottom);
        drawer = findViewById(R.id.drawer_layout);
        rlProfileView = findViewById(R.id.rl_profile_view);
//        imgNavigationCross = findViewById(R.id.img_navigation_cross);
//        imgNavigationCross.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_IN);
        rvNavigation = findViewById(R.id.rv_navigation);
        imgGradient = findViewById(R.id.iv_gradient);
        imgHomeBanner = findViewById(R.id.img_home_banner);
        frameContainer = findViewById(R.id.frame_container);
        appBarLayout = findViewById(R.id.main_app_bar);
        collapsingToolbarLayout = findViewById(R.id.collapsing_toolbar_layout);
        txtToolbar = findViewById(R.id.txt_toolbar);


        tf = Typeface.createFromAsset(getAssets(), "charcoal.ttf");
        collapsingToolbarLayout.setCollapsedTitleTypeface(tf);
        collapsingToolbarLayout.setExpandedTitleTypeface(tf);
        imgPlus = findViewById(R.id.img_plus);
        txtMore = findViewById(R.id.txt_more);
        navZero = findViewById(R.id.nav_zero);
        navOne = findViewById(R.id.nav_one);
        navTwo = findViewById(R.id.nav_two);
        navThree = findViewById(R.id.nav_three);
        navFour = findViewById(R.id.nav_four);

        navIconZero = findViewById(R.id.nav_icon_zero);
        navIconOne = findViewById(R.id.nav_icon_one);
        navIconThree = findViewById(R.id.nav_icon_three);
        navIconFour = findViewById(R.id.nav_icon_four);

        navTextZero = findViewById(R.id.nav_text_zero);
        navTextOne = findViewById(R.id.nav_text_one);
        navTextThree = findViewById(R.id.nav_text_three);
        navTextFour = findViewById(R.id.nav_text_four);

        rlProfileView.setOnClickListener(this);
        navZero.setOnClickListener(this);
        navOne.setOnClickListener(this);
        navTwo.setOnClickListener(this);
        navThree.setOnClickListener(this);
        navFour.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            frameContainer.setNestedScrollingEnabled(true);
        }

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (fragment != null) {
            if (fragment instanceof HomeFragement || fragment instanceof ExploreFragment || fragment instanceof RequestFragment || fragment instanceof MyDiaryFragment)
                finish();
        } else if (fragment != null && fragment.getTag().equalsIgnoreCase("wall")) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        } else {
            super.onBackPressed();
        }

    }

    public void setActionBarTitle(String title) {
        collapsingToolbarLayout.setTitle(title);
    }

    public void setExpandableTitle(int gravity) {
        collapsingToolbarLayout.setExpandedTitleGravity(gravity);
    }

    public void setAppBarLayoutExpand(boolean expanded, boolean animate) {
        appBarLayout.setExpanded(expanded, animate);
    }

    public void setCollpsingImage(int drawableImage) {
        imgHomeBanner.setImageResource(drawableImage);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void setUpTxtToolbar(int visiblity, String txt) {
        txtToolbar.setVisibility(visiblity);
        txtToolbar.setText(txt);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void showBackButton(boolean enable) {

        if (enable) {
            // Remove hamburger
            toggle.setDrawerIndicatorEnabled(false);
            // Show back button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            if (!mToolBarNavigationListenerIsRegistered) {
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


    public void setFragments(int loc) {
        transaction = getSupportFragmentManager().beginTransaction();
        if (loc < 6) {
            switch (loc) {
                case 0:
                    transaction.replace(R.id.frame_container, HomeFragement.newInstance(), "home");
                    break;

                case 1:
                    transaction.replace(R.id.frame_container, ExploreFragment.newInstance(), "explore");
                    break;

                case 3:
                    transaction.replace(R.id.frame_container, QuickRequestFragment.newInstance(), "request");
                    break;

                case 4:
                    transaction.replace(R.id.frame_container, ProfileFragment.newInstance(), "diary");
                    break;

                case 5:
                    transaction.replace(R.id.frame_container, SearchByCategoryFragment.newInstance(), "searchbycat");
                    break;

            }
        } else if (loc > 5 && loc <= 10) {
            switch (loc) {

                case 6:
                    transaction.replace(R.id.frame_container, ContentsFragment.newInstance(), "contents");
                    break;
                case 7:
                    transaction.replace(R.id.frame_container, WallFragment.newInstance(), "wall");
                    break;
                case 8:
                    transaction.replace(R.id.frame_container, FriendsFragment.newInstance(), "friends");
                    break;
                case 9:
                    transaction.replace(R.id.frame_container, MessagesFragment.newInstance(), "msg");
                    break;
            }
        } else if (loc >= 11 && loc < 15) {
            switch (loc) {
                case 11:
                    transaction.replace(R.id.frame_container, RequestProfileFragment.newInstance(), "profilerequest");
                    break;
                case 12:
                    transaction.replace(R.id.frame_container, OrderFragment.newInstance(), "ordersprofile");
                    break;
                case 13:
                    transaction.replace(R.id.frame_container, SellerFragment.newInstance(), "sellerprofile");
                    break;
                case 14:
                    transaction.replace(R.id.frame_container, ExpertFragment.newInstance(), "expert");
                    break;
            }


        } else if (loc >= 15 && loc < 20) {
            switch (loc) {
                case 15:
                    transaction.replace(R.id.frame_container, ProfileDetailsFragment.newInstance(), "profiledetails");
                    break;
                case 16:
                    transaction.replace(R.id.frame_container, MuseumConcertFragment.newInstance(), "museumconcert");
                    break;
                case 17:
                    transaction.replace(R.id.frame_container, TicketFragment.newInstance(), "ticket");
                    break;
                case 18:
                    transaction.replace(R.id.frame_container, ExpertUserFragment.newInstance(), "expertuser");
                    break;
                case 19:
                    transaction.replace(R.id.frame_container, SellerUserFragment.newInstance(), "selleruser");
                    break;
            }
        } else if (loc >= 20 && loc < 25) {
            switch (loc) {
                case 20:
                    transaction.replace(R.id.frame_container, AddEnterTicketFragment.newInstance(), "addticket");
                    break;
                case 21:
                    transaction.replace(R.id.frame_container, InviteFriendsFragment.newInstance(), "invitefriends");
                    break;
                case 22:
                    transaction.replace(R.id.frame_container, RecommendedPlacesFragment.newInstance(), "recommplace");
                    break;
                case 23:
                    transaction.replace(R.id.frame_container, GetPrimiumFragment.newInstance(), "getprimium");
                    break;
                case 24:
                    transaction.replace(R.id.frame_container, WhereEatFragment.newInstance(), "whereeat");
                    break;
            }

        } else if (loc >= 25 && loc < 30) {
            switch (loc) {
                case 25:
                    transaction.replace(R.id.frame_container, MapViewFragment.newInstance(), "mapview");
                    break;
                case 26:
                    transaction.replace(R.id.frame_container, QuickRequestFragment.newInstance(), "quickrequest");
                    break;
                case 27:
                    transaction.replace(R.id.frame_container, StrangleAnglesFragment.newInstance(), "strangeangle");
                    break;
            }
        }
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void setMuseumConcerts() {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, MuseumConcertFragment.newInstance(), "museumconcert");
        fragment = getSupportFragmentManager().findFragmentByTag("museumconcert");
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public void setFragmentsCommitAllowing(int loc) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (loc) {
            case 1:
                break;
            case 2:
                setActionBarTitle("PROFILE");
                transaction.replace(R.id.frame_container, ProfileFragment.newInstance());
                fragment = getSupportFragmentManager().findFragmentByTag("profile");
                break;
            case 3:
                transaction.replace(R.id.frame_container, StrangleAnglesFragment.newInstance());
                break;
            case 4:
                transaction.replace(R.id.frame_container, QuickRequestFragment.newInstance());
                break;
            case 5:
                transaction.replace(R.id.frame_container, TicketFragment.newInstance(), "ticket");
                break;
        }
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void setFragmentsCommitAllowing(int loc, int titleIndex) {
        transaction = getSupportFragmentManager().beginTransaction();
        switch (loc) {
            case 1:
                transaction.replace(R.id.frame_container, AddContentFragment.newInstance(titleIndex), "addcontent");
                fragment = getSupportFragmentManager().findFragmentByTag("addcontent");
                break;
            case 2:
                setActionBarTitle("PROFILE");
                transaction.replace(R.id.frame_container, ProfileFragment.newInstance());
                fragment = getSupportFragmentManager().findFragmentByTag("profile");
                break;
        }
        transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    public void setTimePickerDialog(Context context, final TextView txtStartEndTime) {
        mcurrentTime = Calendar.getInstance();
        int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
        int minute = mcurrentTime.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                mcurrentTime.set(Calendar.YEAR, Calendar.MONTH, Calendar.DATE, hourOfDay, minutes, Calendar.SECOND);
                txtStartEndTime.setText(new SimpleDateFormat("hh:mm a", Locale.US).format(mcurrentTime.getTime()));
            }
        }, hour, minute, false);
        timePickerDialog.setTitle(getString(R.string.mc_select_time));
        timePickerDialog.show();
    }


    public void setUpTopHeader(int imgTitleBgBanner, int gravity, boolean isToolbarScroll, boolean isExpanded, boolean isExpandedAnimate) {
        imgHomeBanner.setImageResource(imgTitleBgBanner);
        collapsingToolbarLayout.setExpandedTitleGravity(gravity);
        collapsingToolbarLayout.setScrollContainer(isToolbarScroll);
        appBarLayout.setExpanded(isExpanded, isExpandedAnimate);
    }

    public void openMore(){
        Intent i2 = new Intent(MainActivity.this, ProfileStuffActivity.class);
        startActivity(i2);
        overridePendingTransition(R.anim.slide_up_info, R.anim.no_change);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.nav_zero:
                setFragments(0);
                setUpTopHeader(R.drawable.launch_banner, Gravity.CENTER, true, true, true);
                break;
            case R.id.nav_one:
                setFragments(1);
                setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);
                break;
            case R.id.nav_two:
                openMore();
//                Intent i2 = new Intent(MainActivity.this, ProfileStuffActivity.class);
//                startActivity(i2);
//                overridePendingTransition(R.anim.slide_up_info, R.anim.no_change);
                break;
            case R.id.nav_three:
                setFragments(3);
                setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);
                break;
            case R.id.nav_four:
                setFragments(4);
                setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);
                break;

            case R.id.rl_profile_view:
                setUpTopHeader(R.drawable.topbg, Gravity.NO_GRAVITY, false, false, false);
                setActionBarTitle("PROFILE");
                transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frame_container, ProfileFragment.newInstance());
                transaction.addToBackStack(null);
                transaction.commit();
                drawer.closeDrawer(GravityCompat.START);
                break;
        }
    }
}
