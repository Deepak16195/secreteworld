package com.credosys.solutions.secrete.world.ApiCall.Presenter;

import android.support.annotation.NonNull;
import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.ApiCall.View.SigninView;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by credosys on 10/3/18.
 */

public class SigninPresenter extends BasePresenter {
    private SigninView signinView;
    public SigninPresenter(SigninView signinView) {
        this.signinView = signinView;
        if (this.api == null) {
            this.api = new Api();
        }
    }
    public void signin(String username,String password){
        Call<Modal> ulogin = api.getApi().login(username,password);
        ulogin.enqueue(new Callback<Modal>() {
            @Override
            public void onResponse(Call<Modal> call, Response<Modal> response) {
            signinView.signin(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<Modal> call, @NonNull Throwable t) {

            }
        });
    }
}

