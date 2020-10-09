package com.designPattern.CompositeDesignPattern.adapterDesignPattern;

/**
 * Created by Lindaliu on 2020-07-27.
 */
public class AssignmentWork {
    private Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public Pen getPen() {
        return this.pen;
    }

    public void writeAssignment(String str){
        this.pen.write(str);
    }

}
