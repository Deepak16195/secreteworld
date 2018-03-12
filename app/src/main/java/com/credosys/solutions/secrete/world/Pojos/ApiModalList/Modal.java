package com.credosys.solutions.secrete.world.Pojos.ApiModalList;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by win7 on 22-Jan-18.
 */

public class Modal {
    @Expose
    private String message;
    @Expose
    private String redirect;
    @Expose
    private boolean success;
    @Expose
    private boolean status;
    @Expose
    private boolean registered;
    @Expose
    private boolean emailSent;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isEmailSent() {
        return emailSent;
    }

    public void setEmailSent(boolean emailSent) {
        this.emailSent = emailSent;
    }

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
