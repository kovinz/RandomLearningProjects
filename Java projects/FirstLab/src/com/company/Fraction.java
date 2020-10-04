package com.company;

public class Fraction implements Cloneable {

    private int top;
    private int bottom;

    public Fraction(int top, int bottom) {
        this.top = top;
        this.bottom = bottom;
    }

    public void add(Fraction sent) {
        this.top = this.top * sent.bottom + sent.top * this.bottom;
        this.bottom *= sent.bottom;
    }

    public int getTop() {
        return top;
    }

    public int getBottom() {
        return bottom;
    }

    public double value() {
        return (double) top / bottom;
    }

    public void simplify() {
        int t;
        int b = bottom;
        int a = top;

        while (b != 0) {
            t = b;
            b = a % b;
            a = t;
        }

        a = Math.abs(a);
        top /= a;
        bottom /= a;
    }

}