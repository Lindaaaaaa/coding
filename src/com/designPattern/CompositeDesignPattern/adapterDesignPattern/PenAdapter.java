package com.designPattern.CompositeDesignPattern.adapterDesignPattern;

/**
 * Created by Lindaliu on 2020-07-27.
 */
public class PenAdapter implements Pen{
    BuiltInPen pen = new BuiltInPen();


    @Override
    public void write(String str) {
        pen.mark(str);
    }
}
