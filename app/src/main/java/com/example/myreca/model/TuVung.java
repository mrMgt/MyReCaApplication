package com.example.myreca.model;

/**
 * Created by linhnd on 2016/12/26.
 */

public class TuVung {
    private String tuvung_kanji;
    private String tuvung_hira;
    private String tuvung_vidu;

    public TuVung(String tuvung_kanji, String tuvung_hira, String tuvung_vidu) {
        this.tuvung_kanji = tuvung_kanji;
        this.tuvung_hira = tuvung_hira;
        this.tuvung_vidu = tuvung_vidu;
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
}
