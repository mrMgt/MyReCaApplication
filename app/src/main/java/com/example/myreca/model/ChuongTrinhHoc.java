package com.example.myreca.model;

/**
 * Created by mr on 12/31/2016.
 */

public class ChuongTrinhHoc {
    private int id;
    private String baihocso;
    private String debaihoc;
    private String noidungkhaiquat;

    public ChuongTrinhHoc() {
    }

    public ChuongTrinhHoc(int id, String baihocso) {
        this.id = id;
        this.baihocso = baihocso;
    }

    public ChuongTrinhHoc(int id, String baihocso, String debaihoc, String noidungkhaiquat) {
        this.id = id;
        this.baihocso = baihocso;
        this.debaihoc = debaihoc;
        this.noidungkhaiquat = noidungkhaiquat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBaihocso() {
        return baihocso;
    }

    public void setBaihocso(String baihocso) {
        this.baihocso = baihocso;
    }

    public String getDebaihoc() {
        return debaihoc;
    }

    public void setDebaihoc(String debaihoc) {
        this.debaihoc = debaihoc;
    }

    public String getNoidungkhaiquat() {
        return noidungkhaiquat;
    }

    public void setNoidungkhaiquat(String noidungkhaiquat) {
        this.noidungkhaiquat = noidungkhaiquat;
    }
}
