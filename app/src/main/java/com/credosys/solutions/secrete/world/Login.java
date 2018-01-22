package com.credosys.solutions.secrete.world;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity implements View.OnClickListener {
EditText etUsername,etPassword;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername=findViewById(R.id.et_username);
        etPassword=findViewById(R.id.et_password);
        btnLogin=findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Call<Modal> ulogin= Api.getApi().login(etUsername.getText().toString(),etPassword.getText().toString());
        ulogin.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {
                Log.d("loginto",""+response);
                if(response.body().isSuccess()){
                    Toast.makeText(Login.this, "Success", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                }
                else{
                    Toast.makeText(Login.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Modal> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
