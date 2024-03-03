package com.IotSensor.IotSensorArt.TempSensor;

import java.sql.Timestamp;

public class ResponseData {

    private String rootype;
    private double temp;
    private String namepi;
    private Timestamp currDate;

    public ResponseData(String rootype, double temp, String namepi, Timestamp currDate) {
        this.rootype = rootype;
        this.temp = temp;
        this.namepi = namepi;
        this.currDate = currDate;
    }

    public String getRootype() {
        return rootype;
    }

    public void setRootype(String rootype) {
        this.rootype = rootype;
    }

    public double getTemp() {
        return temp;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public String getNamepi() {
        return namepi;
    }

    public void setNamepi(String namepi) {
        this.namepi = namepi;
    }

    public Timestamp getCurrDate() {
        return currDate;
    }

    public void setCurrDate(Timestamp currDate) {
        this.currDate = currDate;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "rootype='" + rootype + '\'' +
                ", temp=" + temp +
                ", namepi='" + namepi + '\'' +
                ", currDate=" + currDate +
                '}';
    }
}
