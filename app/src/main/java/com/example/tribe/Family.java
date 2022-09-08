package com.example.tribe;

import android.text.Editable;

public class Family {
    private String familyhead;
    private String familyid;
    private String familyaddress;
    private String famtribename;
    private String familysize;
    private String familytype;

    public Family(String familyhead, String familyid, String familyaddress, String famtribename, String familysize, String familytype) {
        this.familyhead = familyhead;
        this.familyid = familyid;
        this.familyaddress = familyaddress;
        this.famtribename = famtribename;
        this.familysize = familysize;
        this.familytype = familytype;
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
