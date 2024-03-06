package com.IotSensor.IotSensorArt.TempSensor;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.sql.Timestamp;
@Measurement(name = "temp")
public class TempResponseData {
    @Column(name = "roomtype")
    private String roomtype;
    @Column(name = "temp")
    private double temp;
    @Column(name = "namepi")
    private String namepi;

    public TempResponseData(String roomtype, double temp, String namepi) {
        this.roomtype = roomtype;
        this.temp = temp;
        this.namepi = namepi;
    }

    public String getroomtype() {
        return roomtype;
    }

    public void setroomtype(String roomtype) {
        if(roomtype != null)
            this.roomtype = roomtype;
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
        if(namepi != null) this.namepi = namepi;
    }

}
