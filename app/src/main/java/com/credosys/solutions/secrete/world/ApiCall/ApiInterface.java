package com.credosys.solutions.secrete.world.ApiCall;

import com.credosys.solutions.secrete.world.Pojos.ApiModalList.ForgotPwd;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;

/**
 * Created by win7 on 22-Jan-18.
 */

public interface ApiInterface {
    @FormUrlEncoded
    @POST("api.php?o=login")
    Call<Modal> login(@Field("email") String uEmail, @Field("password") String password);

    @FormUrlEncoded
    @POST("api.php?o=forgottenPassword")
    Call<ForgotPwd> forgotPassword(@Field("email") String email, @Field("language") String lang);

    @FormUrlEncoded
    @POST("api.php?o=registerUser")
    Call<Modal> signUp(JSONObject jsonObject);
}
