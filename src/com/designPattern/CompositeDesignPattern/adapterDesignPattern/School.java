package com.designPattern.CompositeDesignPattern.adapterDesignPattern;

/**
 * Created by Lindaliu on 2020-07-27.
 */
public class School {
    public static void main(String args[]){
        AssignmentWork aw = new AssignmentWork();
        aw.setPen(new PenAdapter());
        aw.writeAssignment("I write this");
    }
}
