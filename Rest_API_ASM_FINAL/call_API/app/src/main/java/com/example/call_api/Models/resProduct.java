package com.example.call_api.Models;

import java.util.ArrayList;

public class resProduct {
    private int status;
    private String message;
    public ArrayList<product> data;

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<product> getData() {
        return data;
    }

    public void setData(ArrayList<product> data) {
        this.data = data;
    }

    public resProduct(int status, String message, ArrayList<product> data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
