package org.example;

import assessments.AssessmentFeed;

import java.util.ArrayList;
import java.util.List;

import static org.example.Project.getMark_project;
import static org.example.Report.report_MSc;
import static org.example.Report.report_UG;
import static org.example.Test.getMark_test;

public class GetMark {
    private List<Student> students = new ArrayList<>();

    public void addStudent(){
        List<String> CID= AssessmentFeed.getCIDs();
        int number_student = CID.size();
        for (int i=0;i<number_student;i++){
            String name = AssessmentFeed.getStudentName(CID.get(i));
            String type = AssessmentFeed.getStudentType(CID.get(i));
            if (type.equals("UG")){
                double program = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.PROGRAM_MARK);
                double explained = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.EXPLAINED_SUCCESSFULLY);
                double function = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.AI_PROJECT,AssessmentFeed.FUNCTIONALITY_MARK);
                double verification = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.AI_PROJECT,AssessmentFeed.VERIFICATION_MARK);
                double mark1= getMark_test(program,explained);
                double mark2= getMark_project(function,verification);
                Student student= new Student(name, type, CID.get(i),mark1, mark2, 0);
                boolean discrepancy = students.get(i).isOut();
                students.add(student);
                report_UG(name, CID.get(i),  type,  mark1,  mark2,  program,  explained,  function, verification, discrepancy);

            }
            else {
                double program = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.PROGRAM_MARK);
                double explained = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.PROGRAMMING_TEST,AssessmentFeed.EXPLAINED_SUCCESSFULLY);
                double function = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.AI_PROJECT,AssessmentFeed.FUNCTIONALITY_MARK);
                double verification = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.AI_PROJECT,AssessmentFeed.VERIFICATION_MARK);
                double design = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.DESIGN_VIVA,AssessmentFeed.DESIGN_MARK);
                double design_2 = AssessmentFeed.getResult(CID.get(i),AssessmentFeed.DESIGN_VIVA,AssessmentFeed.EXPLANATION_MARK);
                double mark1= getMark_test(program,explained);
                double mark2= getMark_project(function,verification);
                double mark3= getMark_project(design,design_2);
                Student student= new Student(name, type, CID.get(i),mark1, mark2, mark3);
                boolean discrepancy = students.get(i).isOut();
                report_MSc(name, CID.get(i),  type,  mark1,  mark2, mark3, program,  explained,  function, verification, design, design_2, discrepancy);
                students.add(student);
            }
        }
    }

    public List<Student> getStudent(){
        return students;
    }

}
