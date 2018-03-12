package com.credosys.solutions.secrete.world;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.credosys.solutions.secrete.world.Adapters.NormalScroll.CustomItemClickListener;
import com.credosys.solutions.secrete.world.Adapters.NormalScroll.NavigationAdapter;
import com.credosys.solutions.secrete.world.ApiCall.Presenter.SignUpPresenter;
import com.credosys.solutions.secrete.world.ApiCall.Presenter.SigninPresenter;
import com.credosys.solutions.secrete.world.ApiCall.View.SignUpView;
import com.credosys.solutions.secrete.world.ApiCall.View.SigninView;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.ForgotPwd;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import com.credosys.solutions.secrete.world.Pojos.App.Navigation;
import com.credosys.solutions.secrete.world.ApiCall.Presenter.ForgotPasswordPresenter;
import com.credosys.solutions.secrete.world.Utility.CommonWaitingDialog;
import com.credosys.solutions.secrete.world.ApiCall.View.ForgotPasswordView;

import java.util.ArrayList;
import java.util.List;


public class MainSigninSignupActivity extends AppCompatActivity implements View.OnClickListener, ForgotPasswordView, SigninView, SignUpView {
    EditText etUsername,
            etPassword,
            etForgotEmail,
            etNameSignup,
            etLastSignup,
            etEmailSignup,
            etPwdSignup,
            etPwdConfirmSignup;

    String strNameSignup,
            strLastSignup,
            strEmailSignup,
            strPwdSignup,
            strPwdConfirmSignup;

    CommonWaitingDialog cwd;
    Button btnLogin, btnCreateAc, btnSigninSignup, btnSignupSignin;
    RelativeLayout rlSignin, rlSignup;
    RecyclerView rvNavigation;
    DrawerLayout drawer;
    TextView txtForgotPassword;
    Dialog dlg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_signin_signup);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.app_name);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        etNameSignup = findViewById(R.id.et_name_signup);
        etLastSignup = findViewById(R.id.et_last_signup);
        etEmailSignup = findViewById(R.id.et_email_signup);
        etPwdSignup = findViewById(R.id.et_pwd_signup);
        etPwdConfirmSignup = findViewById(R.id.et_pwd_confirm_signup);
        btnSigninSignup = findViewById(R.id.btn_signin_signup);
        btnSignupSignin = findViewById(R.id.btn_signup_signin);
        btnLogin = findViewById(R.id.btn_login);
        btnCreateAc = findViewById(R.id.btn_create_account);
        rlSignin = findViewById(R.id.rl_signin);
        rlSignup = findViewById(R.id.rl_signup);
        rvNavigation = findViewById(R.id.rv_navigation);
        drawer = findViewById(R.id.drawer_layout);
        txtForgotPassword = findViewById(R.id.txt_forgot_password);

        cwd = new CommonWaitingDialog(this);
        btnLogin.setOnClickListener(this);
        btnSigninSignup.setOnClickListener(this);
        btnSignupSignin.setOnClickListener(this);
        txtForgotPassword.setOnClickListener(this);
        btnCreateAc.setOnClickListener(this);

        List<Navigation> list = new ArrayList<Navigation>();
        list.add(new Navigation("CHANGE LOCATIONS", R.drawable.ic_nav_location));
        list.add(new Navigation("SELECT LANGUAGE", R.drawable.ic_nav_language));
        list.add(new Navigation("SELECT RATE THE APP", R.drawable.ic_nav_star));
        list.add(new Navigation("TERMS & CONDITIONS", R.drawable.ic_nav_terms_conditions));
        list.add(new Navigation("PRIVACY POLICY", R.drawable.ic_nav_privacy_policy));
        list.add(new Navigation("SETTINGS", R.drawable.ic_nav_settings));
        list.add(new Navigation("LOGOUT", R.drawable.ic_nav_logout));

        NavigationAdapter navigationAdapter = new NavigationAdapter(list, new CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                switch (position) {

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
        drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    private void validateSignin() {
        String strUsername = etUsername.getText().toString();
        String strpassword = etPassword.getText().toString();
        if ("".equals(strUsername))
            etUsername.setError("Mandatory Field");
        else if ("".equals(strpassword))
            etPassword.setError("Mandatory Field");
        else
            gotoHome();
    }

    private void validateSignUp() {
        strNameSignup = etNameSignup.getText().toString();
        strLastSignup = etLastSignup.getText().toString();
        strEmailSignup = etEmailSignup.getText().toString();
        strPwdSignup = etPwdSignup.getText().toString();
        strPwdConfirmSignup = etPwdConfirmSignup.getText().toString();

        if ("".equalsIgnoreCase(strNameSignup))
            etNameSignup.setError("Mandatory Field");
        else if ("".equalsIgnoreCase(strLastSignup))
            etLastSignup.setError("Mandatory Field");
        else if ("".equalsIgnoreCase(strPwdSignup))
            etPwdSignup.setError("Mandatory Field");
        else if ("".equalsIgnoreCase(strPwdConfirmSignup))
            etPwdConfirmSignup.setError("Mandatory Field");
        else if (android.util.Patterns.EMAIL_ADDRESS.matcher(strEmailSignup).matches())
            if (strPwdSignup.equals(strPwdConfirmSignup))
                new SignUpPresenter(this).signUp(strNameSignup, strLastSignup,strPwdConfirmSignup, strEmailSignup);
            else
                etPwdConfirmSignup.setError("Password Not matched");
            else
                etEmailSignup.setError("Not a Valid Email");


    }

    private void gotoHome() {
        cwd.show();
        new SigninPresenter(this).signin(etUsername.getText().toString(), etPassword.getText().toString());
//        Call<Modal> ulogin = new Api().getApi().login(etUsername.getText().toString(), etPassword.getText().toString());
//        ulogin.enqueue(new Callback<Modal>() {
//            @Override
//            public void onResponse(Call<Modal> call, Response<Modal> response) {
//                Log.d("loginto", "" + response);
//                if (response.body().isSuccess()) {
//                    Toast.makeText(MainSigninSignupActivity.this, "Success", Toast.LENGTH_SHORT).show();
//                    cwd.dismiss();
//                    startActivity(new Intent(MainSigninSignupActivity.this, MainActivity.class));
//                    finish();
//                } else {
//                    cwd.dismiss();
//                    Toast.makeText(MainSigninSignupActivity.this, "failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(@NonNull Call<Modal> call, @NonNull Throwable t) {
//                cwd.dismiss();
//                Toast.makeText(MainSigninSignupActivity.this, "Fatal Error Network Failure", Toast.LENGTH_SHORT).show();
//                t.printStackTrace();
//            }
//        });
    }

    void showDialogForgotPwd() {
        dlg = new Dialog(this);
        dlg.setContentView(R.layout.dialog_forgot_password);
        ImageView imgCross = dlg.findViewById(R.id.img_cross);
        etForgotEmail = dlg.findViewById(R.id.et_email);
        dlg.findViewById(R.id.btn_send_mail).setOnClickListener(this);
        imgCross.setColorFilter(getResources().getColor(R.color.customRed), PorterDuff.Mode.SRC_ATOP);
        imgCross.setOnClickListener(this);
        dlg.setCancelable(false);
        dlg.setTitle("Forgot Password");
        dlg.show();
    }

    //    private void sendEmail(){
//        Call<ForgotPwd> call=new Api().getApi().forgotPassword(etForgotEmail.getText().toString(),"english");
//        call.enqueue(new Callback<ForgotPwd>() {
//            @Override
//            public void onResponse(Call<ForgotPwd> call, Response<ForgotPwd> response) {
//                Toast.makeText(MainSigninSignupActivity.this,"response",Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<ForgotPwd> call, Throwable t) {
//                t.printStackTrace();
//                Toast.makeText(MainSigninSignupActivity.this,"failure",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                validateSignin();
                break;

            case R.id.btn_create_account:
                validateSignUp();
                break;

            case R.id.btn_signin_signup: // button will change sign in to signup
                rlSignup.setVisibility(View.VISIBLE);
                rlSignin.setVisibility(View.GONE);
                break;

            case R.id.btn_signup_signin:// button will change signup to signin
                rlSignin.setVisibility(View.VISIBLE);
                rlSignup.setVisibility(View.GONE);
                break;
            case R.id.txt_forgot_password:
                showDialogForgotPwd();
                break;
            case R.id.img_cross:
                dlg.dismiss();
                break;
            case R.id.btn_send_mail:
                new ForgotPasswordPresenter(this).sendEmail(etForgotEmail.getText().toString(), "english");
                cwd.show();
                break;


        }
    }

    @Override
    public void forgotPass(ForgotPwd forgotPwd) {
        cwd.dismiss();
        dlg.dismiss();
        Log.d("forgottnpass", forgotPwd.getStatus());
        if (Boolean.valueOf(forgotPwd.getStatus())) {
            MainApplication.getInstance().show(this, "Email Has been sent\n please Reset password");
        } else {
            MainApplication.getInstance().show(this, "Email Has been Failed\n try Sign up");
        }
    }

    @Override
    public void signin(Modal modal) {
        Log.d("loginto", "" + modal);
        if (modal.isSuccess()) {
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
    public void SignUp(Modal modal) {

    }
}
