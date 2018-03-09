package com.credosys.solutions.secrete.world.Pojos.ApiModalList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by credosys on 9/3/18.
 */

public class ForgotPwd implements Serializable {
    @Expose
    String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
