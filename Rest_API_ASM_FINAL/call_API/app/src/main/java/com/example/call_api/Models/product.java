package com.example.call_api.Models;

import com.google.gson.annotations.SerializedName;

public class product {
    @SerializedName("_id")
    private String _id;
    @SerializedName("voucherType")
    private String voucherType;
    @SerializedName("voucherCon")
    private String voucherCon;
    @SerializedName("dateAvai")
    private  String dateAvai;
    @SerializedName("dateUnVai")
    private String dateUnVai;
    @SerializedName("amount")
    private int amount;
    @SerializedName("trang_thai")
    private boolean trang_thai;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("__v")
    private int __v;

    public product(String _id, int __v, String user_id, boolean trang_thai, int amount, String dateUnVai, String dateAvai, String voucherCon, String voucherType) {
        this._id = _id;
        this.__v = __v;
        this.user_id = user_id;
        this.trang_thai = trang_thai;
        this.amount = amount;
        this.dateUnVai = dateUnVai;
        this.dateAvai = dateAvai;
        this.voucherCon = voucherCon;
        this.voucherType = voucherType;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getVoucherType() {
        return voucherType;
    }

    public void setVoucherType(String voucherType) {
        this.voucherType = voucherType;
    }

    public String getVoucherCon() {
        return voucherCon;
    }

    public void setVoucherCon(String voucherCon) {
        this.voucherCon = voucherCon;
    }

    public String getDateAvai() {
        return dateAvai;
    }

    public void setDateAvai(String dateAvai) {
        this.dateAvai = dateAvai;
    }

    public String getDateUnVai() {
        return dateUnVai;
    }

    public void setDateUnVai(String dateUnVai) {
        this.dateUnVai = dateUnVai;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }

    public int get__v() {
        return __v;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }
}
