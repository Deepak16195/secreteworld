package com.credosys.solutions.secrete.world.Pojos.ApiModalList;

import com.google.gson.annotations.SerializedName;

/**
 * Created by win7 on 22-Jan-18.
 */

public class Modal {

    private String message;
    private String redirect;
    private boolean success;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
