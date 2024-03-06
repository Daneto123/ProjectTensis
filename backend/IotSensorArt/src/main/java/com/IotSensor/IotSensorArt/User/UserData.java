package com.IotSensor.IotSensorArt.User;

import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

import java.util.Arrays;
import java.util.List;

@Measurement(name = "user")
public class UserData {
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "serviceName")
    private String[] serviceName;

    public UserData(String username, String password, String email, String[] serviceName) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setServiceName(serviceName);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username != null)
            this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password != null) this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null) this.email = email;
    }

    public String[] getServiceName() {
        return serviceName;
    }

    public void setServiceName(String[] serviceName) {
        if(serviceName != null) this.serviceName = serviceName;
    }

}
