package com.builderDesignPattern;

/**
 * Created by Lindaliu on 2020-07-27.
 */
// Builder pattern
public class Phone {
    private String os;
    private int ram;
    private String processor;
    private double screenSize;
    private int battary;

    public Phone(String os, int ram, String processor, double screenSize, int battery){
        this.os = os;
        this.ram = ram;
        this.processor = processor;
        this.screenSize = screenSize;
        this.battary = battery;
    }

    @Override
    public String toString() {
        return "Phone [os=]" +os + ", ram=" + ram + ", processor=" + processor + ", screenSize=" + screenSize
                + ", battery=" + battary + "]";
    }

    /**
     * Created by Lindaliu on 2020-07-27.
     */
    public static class Shop {
        public static void main(String args[]) {
            Phone p = new PhoneBuilder().setOs("Andriod").setRam(2).getPhone();
            System.out.println(p);
        }
    }
}
