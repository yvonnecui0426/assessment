package org.example;

import assessments.AssessmentFeed;

import javax.swing.*;
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GetMark mark = new GetMark();

        JFrame frame = new JFrame("Student Result");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(750, 400);

        int number_student = AssessmentFeed.getCIDs().size();

        JPanel grid = new JPanel(new GridLayout(number_student, 1, 5, 5));

        // Arrays keep the panels and labels after the loop ends, so the timer can use them.
        JPanel[] panels = new JPanel[number_student];
        JLabel[] labels = new JLabel[number_student];

        for (int i = 0; i < number_student; i++) {
            panels[i] = new JPanel();
            labels[i] = new JLabel();
            panels[i].add(labels[i]);   // label into its panel
            grid.add(panels[i]);        // panel into the grid
        }

        frame.add(grid);                // grid into the frame
        frame.setVisible(true);

        mark.addStudent();
        for (int i=0;i<number_student;i++){
            labels[i].setText(mark.getStudent().get(i).report());
            if (mark.getStudent().get(i).isOut()){
                panels[i].setBackground(Color.RED);
            }
        }
    }
}