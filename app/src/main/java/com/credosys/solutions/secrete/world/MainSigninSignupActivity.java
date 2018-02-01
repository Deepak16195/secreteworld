package com.credosys.solutions.secrete.world;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.CustomItemClickListener;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.NavigationAdapter;
import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import com.credosys.solutions.secrete.world.Pojos.App.Naviagion;
import com.credosys.solutions.secrete.world.Utility.CommonWaitingDialog;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainSigninSignupActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    EditText etUsername, etPassword;
    CommonWaitingDialog cwd;
    Button btnLogin, btnCreateAc, btnSigninSignup, btnSignupSignin;
    RelativeLayout rlSignin, rlSignup;
    RecyclerView rvNavigation;
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_signin_signup);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("SECRETE WORLD");
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSigninSignup = findViewById(R.id.btn_signin_signup);
        btnSignupSignin = findViewById(R.id.btn_signup_signin);
        btnLogin = findViewById(R.id.btn_login);
        btnCreateAc = findViewById(R.id.btn_create_account);
        rlSignin = findViewById(R.id.rl_signin);
        rlSignup = findViewById(R.id.rl_signup);
        rvNavigation=findViewById(R.id.rv_navigation);
        drawer = findViewById(R.id.drawer_layout);
        cwd=new CommonWaitingDialog(this);

        btnLogin.setOnClickListener(this);
        btnSigninSignup.setOnClickListener(this);
        btnSignupSignin.setOnClickListener(this);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



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

                }
                drawer.closeDrawer(GravityCompat.START);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvNavigation.setLayoutManager(mLayoutManager);
        rvNavigation.setItemAnimator(new DefaultItemAnimator());
        rvNavigation.setAdapter(navigationAdapter);
    }

    @Override
    public void onBackPressed() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                cwd.show();
                Call<Modal> ulogin = Api.getApi().login(etUsername.getText().toString(), etPassword.getText().toString());
                ulogin.enqueue(new Callback<Modal>() {
                    @Override
                    public void onResponse(Call<Modal> call, Response<Modal> response) {
                        Log.d("loginto", "" + response);
                        if (response.body().isSuccess()) {
                            Toast.makeText(MainSigninSignupActivity.this, "Success", Toast.LENGTH_SHORT).show();
                            cwd.dismiss();
                            startActivity(new Intent(MainSigninSignupActivity.this, MainActivity.class));
                            finish();
                        } else {
                            cwd.dismiss();
                            Toast.makeText(MainSigninSignupActivity.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Modal> call, Throwable t) {
                        cwd.dismiss();
                        Toast.makeText(MainSigninSignupActivity.this,"Fatal Error Network Failure",Toast.LENGTH_SHORT).show();
                        t.printStackTrace();
                    }
                });
                break;

            case R.id.btn_create_account:
                break;

            case R.id.btn_signin_signup: // button will change sign in to signup
                rlSignup.setVisibility(View.VISIBLE);
                rlSignin.setVisibility(View.GONE);
                break;

            case R.id.btn_signup_signin:// button will change signup to signin
                rlSignin.setVisibility(View.VISIBLE);
                rlSignup.setVisibility(View.GONE);
                break;

        }
    }
}
