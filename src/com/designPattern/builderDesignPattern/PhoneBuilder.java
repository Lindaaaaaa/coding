package com.designPattern.builderDesignPattern;

/**
 * Created by Lindaliu on 2020-07-27.
 * Do not need to pass all fields, do not need to remember the order and name of the field
 */

public class PhoneBuilder {
    private String os;
    private int ram;
    private String processer;
    private double screenSize;
    private int battary;


    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setProcessor (String processer) {
        this.processer = processer;
        return this;
    }

    public PhoneBuilder setScreenSize(int screenSize) {
        this.screenSize = screenSize;
        return this;
    }

    public PhoneBuilder setBattery(int battary) {
        this.battary = battary;
        return this;
    }

    public Phone getPhone() {
        return new Phone(os, ram, processer, screenSize, battary);
    }

}

