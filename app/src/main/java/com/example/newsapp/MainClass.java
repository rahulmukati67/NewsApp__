package com.example.newsapp;

import java.util.ArrayList;

public class MainClass {
    private String status ;
    private String totalresults;
    ArrayList<ModelCLass> articles;

    public MainClass(String status, String totalresults, ArrayList<ModelCLass> articles) {
        this.status = status;
        this.totalresults = totalresults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public ArrayList<ModelCLass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelCLass> articles) {
        this.articles = articles;
    }
}
