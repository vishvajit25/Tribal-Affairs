package com.example.tribe;

import android.text.Editable;

public class Family {
    private String familyhead;
    private String familyid;
    private String familyaddress;
    private String famtribename;
    private String familysize;
    private String familytype;
    private String familystate;
    private String familydistrict;
    private String familyblock;
    private String familytaluk;
    private String familypanchayat;
    private String familytribename;

    public Family(String familyhead, String familyid, String familyaddress, String familysize, String familytype, String familystate, String familydistrict, String familyblock, String familytaluk, String familypanchayat, String familytribename) {
        this.familyhead = familyhead;
        this.familyid = familyid;
        this.familyaddress = familyaddress;
        this.famtribename = famtribename;
        this.familysize = familysize;
        this.familytype = familytype;
        this.familystate = familystate;
        this.familydistrict = familydistrict;
        this.familyblock = familyblock;
        this.familytaluk = familytaluk;
        this.familypanchayat = familypanchayat;
        this.familytribename = familytribename;
    }

    public String getFamilystate() {
        return familystate;
    }

    public void setFamilystate(String familystate) {
        this.familystate = familystate;
    }

    public String getFamilydistrict() {
        return familydistrict;
    }

    public void setFamilydistrict(String familydistrict) {
        this.familydistrict = familydistrict;
    }

    public String getFamilyblock() {
        return familyblock;
    }

    public void setFamilyblock(String familyblock) {
        this.familyblock = familyblock;
    }

    public String getFamilytaluk() {
        return familytaluk;
    }

    public void setFamilytaluk(String familytaluk) {
        this.familytaluk = familytaluk;
    }

    public String getFamilypanchayat() {
        return familypanchayat;
    }

    public void setFamilypanchayat(String familypanchayat) {
        this.familypanchayat = familypanchayat;
    }

    public String getFamilytribename() {
        return familytribename;
    }

    public void setFamilytribename(String familytribename) {
        this.familytribename = familytribename;
    }


    public String getFamilyhead() {
        return familyhead;
    }

    public void setFamilyhead(String familyhead) {
        this.familyhead = familyhead;
    }

    public String getFamilyid() {
        return familyid;
    }

    public void setFamilyid(String familyid) {
        this.familyid = familyid;
    }

    public String getFamilyaddress() {
        return familyaddress;
    }

    public void setFamilyaddress(String familyaddress) {
        this.familyaddress = familyaddress;
    }

    public String getFamtribename() {
        return famtribename;
    }

    public void setFamtribename(String famtribename) {
        this.famtribename = famtribename;
    }

    public String getFamilysize() {
        return familysize;
    }

    public void setFamilysize(String familysize) {
        this.familysize = familysize;
    }

    public String getFamilytype() {
        return familytype;
    }

    public void setFamilytype(String familytype) {
        this.familytype = familytype;
    }
}
