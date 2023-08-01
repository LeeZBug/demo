package com.lizhejie.demo.model.entity;

public class YwDomain {

    private int id;
    private String domain;
    private String recordA;
    private String recordCname;



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getDomain() {
        return domain;
    }

    public void setRecordA(String recordA) {
        this.recordA = recordA;
    }
    public String getRecordA() {
        return recordA;
    }

    public void setRecordCname(String recordCname) {
        this.recordCname = recordCname;
    }
    public String getRecordCname() {
        return recordCname;
    }


}