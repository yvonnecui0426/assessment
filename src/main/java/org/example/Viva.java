package org.example;

public class Viva extends Assessment {
    private double mark1;
    private double mark2;
    public Viva(double mark1, double mark2) {
        super (mark1, mark2);
    }
    public static double getMark_viva(double mark1, double mark2) {
        double mark = mark1*0.5+mark2*0.5;
        String.format("%.2f", mark);
        return mark;
    }
}
