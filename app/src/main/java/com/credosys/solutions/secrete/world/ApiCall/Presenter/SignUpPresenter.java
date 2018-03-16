package com.credosys.solutions.secrete.world.ApiCall.Presenter;

import android.util.Log;

import com.credosys.solutions.secrete.world.ApiCall.Api;
import com.credosys.solutions.secrete.world.ApiCall.View.SignUpView;
import com.credosys.solutions.secrete.world.ApiCall.View.SigninView;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.Modal;
import com.credosys.solutions.secrete.world.Pojos.ApiModalList.UserFields;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.annotations.Expose;

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
//            Call<Modal> call=api.getApi().signUp( generateMainJson(firstName,lastName,password,email));
//            call.enqueue(new Callback<Modal>() {
//                @Override
//                public void onResponse(Call<Modal> call, Response<Modal> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<Modal> call, Throwable t) {
//
//                }
//            });
    }
    private JSONObject generateMainJson(String firstName,String lastName,String password,String email)  {
         JSONObject mainObject = new JSONObject();
        try {
//            mainObject.accumulate("userFields",subObject("first_name", firstName, 2, 15));
//            mainObject.accumulate("userFields",subObject("last_name", lastName, 2, 16));
//            mainObject.accumulate("userFields",subObject("company_name", "", 2, 24));
//            mainObject.accumulate("userFields",subObject("email_uid", email, 2, 17));
//            mainObject.accumulate("userFields",subObject("main_photo", "", 1, 14));
//            mainObject.accumulate("userFields",subObject("password", password, 1, 0));
//            mainObject.accumulate("userFields",subObject("nickname", "", 1, 0));
//            mainObject.accumulate("userFields",subObject("active_flag", 0, 1, 0));
//            mainObject.accumulate("userFields",subObject("is_seller", 0, 1, 0));
//            mainObject.accumulate("userFields",subObject("is_business", 0, 1, 0));
//            mainObject.accumulate("userFields",subObject("is_expert", 0, 1, 0));
//            mainObject.accumulate("userFields",subObject("is_social_user", 0, 0, 0));
//            mainObject.accumulate("userFields",subObject("social", "", 0, 0));
//            mainObject.accumulate("userFields",subObject("id_social_user", "", 0, 0));
            String[] t={
            subObject("first_name", firstName, 2, 15),
            subObject("last_name", lastName, 2, 16),
            subObject("company_name", "", 2, 24) ,
            subObject("email_uid", email, 2, 17),
            subObject("main_photo", "", 1, 14) ,
            subObject("password", password, 1, 0),
            subObject("nickname", "", 1, 0) ,
            subObject("active_flag", 0, 1, 0),
            subObject("is_seller", 0, 1, 0),
            subObject("is_business", 0, 1, 0),
            subObject("is_expert", 0, 1, 0),
            subObject("is_social_user", 0, 0, 0),
            subObject("social", "", 0, 0) ,
            subObject("id_social_user", "", 0, 0)
            };



            String s="{"+t[0]+","
                        +t[1]+","
                        +t[2]+","
                        +t[3]+","
                        +t[4]+","
                        +t[5]+","
                        +t[6]+","
                        +t[7]+","
                        +t[8]+","
                        +t[9]+","
                        +t[10]+","
                        +t[11]+","
                        +t[12]+","
                        +t[13]+"}";
              mainObject.put("userFields",s);
              mainObject.put("language","en");
            Log.d("signupjson",s);
                  return mainObject;
        }
        catch (JSONException e){
            e.printStackTrace();
        }


        return new JSONObject();
    }

    private String subObject(String objectName,String value,int privacy,int id_field)throws JSONException{
        jsonObject=new JSONObject();
        JSONObject subObject=new JSONObject();
        subObject.put("value",value);
        subObject.put("privacy",privacy);
        subObject.put("id_field",id_field);
        jsonObject.put(objectName,subObject);

        return  change(jsonObject.toString());
    }
      private String subObject(String objectName,int value,int privacy,int id_field)throws JSONException{
         jsonObject=new JSONObject();
        JSONObject subObject=new JSONObject();
        subObject.put("value",value);
        subObject.put("privacy",privacy);
        subObject.put("id_field",id_field);
        jsonObject.put(objectName,subObject);
        return  change(jsonObject.toString());
    }
    private String change(String s){
        s=s.substring(1,s.length()-1);
        return s;
    }

}
