package com.example.restutility.model;

import java.util.List;

public class ProductResponse {
    private int totalRecords;
    private List<DataItem> data;

    public ProductResponse() {
    }

    public ProductResponse(int totalRecords, List<DataItem> data) {
        this.totalRecords = totalRecords;
        this.data = data;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }
}
