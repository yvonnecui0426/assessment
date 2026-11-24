package org.example;

public class Project extends Assessment {
    private double mark1;
    private double mark2;
    public Project(double mark1, double mark2) {
        super (mark1, mark2);
    }

    public static double getMark_project(double mark1, double mark2) {
        double mark = mark1*0.4+mark2*0.6;
        String.format("%.2f", mark);
        return mark;
    }
}
