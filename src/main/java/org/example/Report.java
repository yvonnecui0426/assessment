package org.example;

public class Report {
    public static void report_UG(String name, String CID, String type, double mark1, double mark2, double program, double explained, double function, double verification, boolean discrepancy) {
        System.out.println(" Name: " + name + " CID: " + CID + " type: " + type + " Progamming_Test: " + mark1 + " AI_project " + mark2 + " Program_mark: " + program + " Explained_successful: " + explained + " Functionality: " + function + " verification: " + verification + " if out of range: " + discrepancy);
    }

    public static void report_MSc(String name, String CID, String type, double mark1, double mark2, double mark3, double program, double explained, double function, double verificaiton, double design, double design_2, boolean discrepancy) {
        System.out.println(" Name: " + name + " CID: " + CID + " type: " + type + " Progamming_Test: " + mark1 + " AI_project " + mark2 + " Design_viva: " + mark3 + " Program_mark: " + program + " Explained_successful: " + explained + " Functionality: " + function + " verification: " + verificaiton + " design mark: " + design + " explanation mark: " + design_2 + "if out of range: " + discrepancy);

    }
}
