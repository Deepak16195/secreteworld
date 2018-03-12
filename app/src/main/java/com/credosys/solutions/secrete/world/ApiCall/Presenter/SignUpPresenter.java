package com.credosys.solutions.secrete.world.ApiCall.Presenter;

import android.util.Log;

import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.ApiCall.View.SignUpView;
import com.credosys.solutions.secrete.world.ApiCall.View.SigninView;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by credosys on 12/3/18.
 */

public class SignUpPresenter extends BasePresenter {
    private SignUpView signUpView;
    private JSONObject jsonObject;
    public SignUpPresenter(SignUpView signUpView) {
        this.signUpView = signUpView;
        if (this.api == null) {
            this.api = new Api();
        }
    }

    public void signUp(String firstName,String lastName,String password,String email) {
            Call<Modal> call=api.getApi().signUp( generateMainJson(firstName,lastName,password,email));
            call.enqueue(new Callback<Modal>() {
                @Override
                public void onResponse(Call<Modal> call, Response<Modal> response) {

                }

                @Override
                public void onFailure(Call<Modal> call, Throwable t) {

                }
            });
    }
    private JSONObject generateMainJson(String firstName,String lastName,String password,String email)  {
         JSONObject mainObject = new JSONObject();

        try {
            mainObject.accumulate("userFields",subObject("first_name", firstName, 2, 15));
            mainObject.accumulate("userFields",subObject("last_name", lastName, 2, 16));
            mainObject.accumulate("userFields",subObject("company_name", "", 2, 24));
            mainObject.accumulate("userFields",subObject("email_uid", email, 2, 17));
            mainObject.accumulate("userFields",subObject("main_photo", "", 1, 14));
            mainObject.accumulate("userFields",subObject("password", password, 1, 0));
            mainObject.accumulate("userFields",subObject("nickname", "", 1, 0));
            mainObject.accumulate("userFields",subObject("active_flag", 0, 1, 0));
            mainObject.accumulate("userFields",subObject("is_seller", 0, 1, 0));
            mainObject.accumulate("userFields",subObject("is_business", 0, 1, 0));
            mainObject.accumulate("userFields",subObject("is_expert", 0, 1, 0));
            mainObject.accumulate("userFields",subObject("is_social_user", 0, 0, 0));
            mainObject.accumulate("userFields",subObject("social", "", 0, 0));
            mainObject.accumulate("userFields",subObject("id_social_user", "", 0, 0));
            mainObject.put("language","en");
            Log.d("signupjson",mainObject.toString());
            Log.d("signupjson1",mainObject.getJSONObject("userFields").toString());
//            mainObject.put("userFields", jobj);

        }
        catch (JSONException e){
            e.printStackTrace();
        }
        return mainObject;
    }

    private JSONObject subObject(String objectName,String value,int privacy,int id_field)throws JSONException{
        jsonObject=new JSONObject();
        JSONObject subObject=new JSONObject();
        subObject.put("value",value);
        subObject.put("privacy",privacy);
        subObject.put("id_field",id_field);
        jsonObject.put(objectName,subObject);
        return jsonObject;
    }
      private JSONObject subObject(String objectName,int value,int privacy,int id_field)throws JSONException{
         jsonObject=new JSONObject();
        JSONObject subObject=new JSONObject();
        subObject.put("value",value);
        subObject.put("privacy",privacy);
        subObject.put("id_field",id_field);
        jsonObject.put(objectName,subObject);
        return jsonObject;
    }

}
