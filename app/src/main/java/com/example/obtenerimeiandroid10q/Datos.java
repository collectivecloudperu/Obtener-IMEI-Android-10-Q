package com.example.obtenerimeiandroid10q;

public class Datos {

    private String androidID;
    private String serialID;
    private String uuID;

    public Datos(String androidID, String serialID, String uuid) {
        this.androidID = androidID;
        this.serialID = serialID;
        this.uuID = uuid;
    }

    public Datos() {
    }

    public String getAndroidID() {
        return androidID;
    }
    public void setAndroidID(String androidID) {
        this.androidID = androidID;
    }

    public String getSerialID() {
        return serialID;
    }
    public void setSerialID(String serialID) {
        this.serialID = serialID;
    }

    public String getUuidID() {
        return uuID;
    }
    public void setUuuID(String uuID) {
        this.uuID = uuID;
    }

}
