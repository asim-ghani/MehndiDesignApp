package com.ghani.mehndidesign.offline2023.simple.Model;

public class GridModel {

    String Cate_name;
    int Cate_img;

    public GridModel(String cate_name, int cate_img) {
        Cate_name = cate_name;
        Cate_img = cate_img;
    }

    public String getCate_name() {
        return Cate_name;
    }

    public void setCate_name(String cate_name) {
        Cate_name = cate_name;
    }

    public int getCate_img() {
        return Cate_img;
    }

    public void setCate_img(int cate_img) {
        Cate_img = cate_img;
    }
}
