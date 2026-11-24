package org.example;

public class Student {
    private String name;
    private String type;
    private String CID;
    private double assess1;
    private double assess2;
    private double assess3;
    private double overall;
    private boolean out;

    public Student(String name, String type, String CID, double assess1, double assess2, double assess3) {
        this.name = name;
        this.type = type;
        this.CID = CID;
        this.assess1 = assess1;
        this.assess2 = assess2;
        this.assess3 = assess3;
        if (this.type.equals("UG")){
            overall=0.3*assess1+0.7*assess2;
            this.assess3 = 0;
        }
        else if (this.type.equals("MSc")){
            overall=0.25*assess1+0.45*assess2+0.3*assess3;
        }
        double permitted = assess2;
        double not = (assess1+assess2)/2;
        if ((permitted-not)>=20){
            out = true;
        }
        else{
            out=false;
        }
    }

    public String report() {
        String text = "name: " + name + " CID: " + CID + " type: " + type + " programming: " + assess1 + " AI: " + assess2 + " Viva: " + assess3 + " overall: " + overall;
        return text;
    }

    public boolean isOut (){
        if (out==true){
            return true;
        }
        return false;
    }

}
