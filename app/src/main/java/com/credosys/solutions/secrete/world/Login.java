package com.credosys.solutions.secrete.world;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import com.credosys.solutions.secrete.world.Utility.CommonWaitingDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
    EditText etUsername, etPassword;
    CommonWaitingDialog cwd;
    Button btnLogin, btnCreateAc, btnSigninSignup, btnSignupSignin;
    RelativeLayout rlSignin, rlSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_signin_signup);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnSigninSignup = findViewById(R.id.btn_signin_signup);
        btnSignupSignin = findViewById(R.id.btn_signup_signin);
        btnLogin = findViewById(R.id.btn_login);
        btnCreateAc = findViewById(R.id.btn_create_account);
        rlSignin = findViewById(R.id.rl_signin);
        rlSignup = findViewById(R.id.rl_signup);

        cwd=new CommonWaitingDialog(this);

        btnLogin.setOnClickListener(this);
        btnSigninSignup.setOnClickListener(this);
        btnSignupSignin.setOnClickListener(this);
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
                            Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                            cwd.dismiss();
                            startActivity(new Intent(Login.this, MainActivity.class));
                        } else {
                            cwd.dismiss();
                            Toast.makeText(Login.this, "failed", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Modal> call, Throwable t) {
                        cwd.dismiss();
                        Toast.makeText(Login.this,"Fatal Error Network Failure",Toast.LENGTH_SHORT).show();
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
