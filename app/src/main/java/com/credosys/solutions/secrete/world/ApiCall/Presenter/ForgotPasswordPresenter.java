package com.credosys.solutions.secrete.world.ApiCall.Presenter;

import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.ForgotPwd;
import com.credosys.solutions.secrete.world.ApiCall.View.ForgotPasswordView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by credosys on 10/3/18.
 */

public class ForgotPasswordPresenter extends BasePresenter {
    private ForgotPasswordView forgotPasswordView;
    public ForgotPasswordPresenter(ForgotPasswordView forgotPasswordView) {
        this.forgotPasswordView = forgotPasswordView;
        if (this.api == null) {
            this.api = new Api();
        }
    }
    public void sendEmail(String etEmail,String language){
        Call<ForgotPwd> call=new Api().getApi().forgotPassword(etEmail,language);
        call.enqueue(new Callback<ForgotPwd>() {
            @Override
            public void onResponse(Call<ForgotPwd> call, Response<ForgotPwd> response) {
                forgotPasswordView.forgotPass(response.body());
            }

            @Override
            public void onFailure(Call<ForgotPwd> call, Throwable t) {
                t.printStackTrace();

            }
        });
    }
}
