package com.example.myreca.model;

/**
 * Created by linhnd on 2016/12/26.
 */

public class TuVung {
    private String tuvung_kanji;
    private String tuvung_hira;
    private String tuvung_vidu;
    private int id;
    private String tuvung_baihocso;
    private String tuvung_nghia;


    public TuVung() {
    }

    public TuVung(String tuvung_kanji, String tuvung_hira, String tuvung_vidu) {
        this.tuvung_kanji = tuvung_kanji;
        this.tuvung_hira = tuvung_hira;
        this.tuvung_vidu = tuvung_vidu;
    }

    public TuVung(String tuvung_kanji, String tuvung_hira, String tuvung_vidu, int id, Kanji kanji) {

        this.tuvung_kanji = tuvung_kanji;
        this.tuvung_hira = tuvung_hira;
        this.tuvung_vidu = tuvung_vidu;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTuvung_kanji() {
        return tuvung_kanji;
    }

    public void setTuvung_kanji(String tuvung_kanji) {
        this.tuvung_kanji = tuvung_kanji;
    }

    public String getTuvung_hira() {
        return tuvung_hira;
    }

    public void setTuvung_hira(String tuvung_hira) {
        this.tuvung_hira = tuvung_hira;
    }

    public String getTuvung_vidu() {
        return tuvung_vidu;
    }

    public void setTuvung_vidu(String tuvung_vidu) {
        this.tuvung_vidu = tuvung_vidu;
    }

    public String getTuvung_baihocso() {
        return tuvung_baihocso;
    }

    public void setTuvung_baihocso(String tuvung_baihocso) {
        this.tuvung_baihocso = tuvung_baihocso;
    }

    public String getTuvung_nghia() {
        return tuvung_nghia;
    }

    public void setTuvung_nghia(String tuvung_nghia) {
        this.tuvung_nghia = tuvung_nghia;
    }
}
