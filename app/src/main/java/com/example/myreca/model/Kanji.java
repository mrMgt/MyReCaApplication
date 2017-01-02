package com.example.myreca.model;

/**
 * Created by mr on 12/31/2016.
 */

public class Kanji {
    private int id;
    private String chuHan;
    private String hanViet;
    private int cachviet;
    private String[] vidu;

    public Kanji(int id, String chuHan, String hanViet) {
        this.id = id;
        this.chuHan = chuHan;
        this.hanViet = hanViet;
    }

    public Kanji(int id, String chuHan, String hanViet, int cachviet, String[] vidu) {
        this.id = id;
        this.chuHan = chuHan;
        this.hanViet = hanViet;
        this.cachviet = cachviet;
        this.vidu = vidu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChuHan() {
        return chuHan;
    }

    public void setChuHan(String chuHan) {
        this.chuHan = chuHan;
    }

    public String getHanViet() {
        return hanViet;
    }

    public void setHanViet(String hanViet) {
        this.hanViet = hanViet;
    }

    public int getCachviet() {
        return cachviet;
    }

    public void setCachviet(int cachviet) {
        this.cachviet = cachviet;
    }

    public String[] getVidu() {
        return vidu;
    }

    public void setVidu(String[] vidu) {
        this.vidu = vidu;
    }
}
