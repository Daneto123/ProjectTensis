package com.IotSensor.IotSensorArt.User;

import java.util.Arrays;

public class UserData {
    private String username;
    private String password;
    private String email;
    private String[] serviceName;

    public UserData(String username, String password, String email, String[] serviceName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.serviceName = serviceName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String[] getServiceName() {
        return serviceName;
    }

    public void setServiceName(String[] serviceName) {
        this.serviceName = serviceName;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", serviceName=" + Arrays.toString(serviceName) +
                '}';
    }
}
