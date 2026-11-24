package org.example;

public class Test extends Assessment {
    private double mark1;
    private double mark2;
    public Test(double mark1, double mark2) {
        super (mark1, mark2);
    }

    public static double getMark_test(double mark1, double mark2) {
        if (mark2 == 1.0){
            String.format("%.2f", mark1);
            return mark1;
        }
        else {
            double capped = 40.0;
            String.format("%.2f", capped);
            return capped;
        }
    }
}
