package assessments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Read-only fictional assessment data for the Software Engineering OOP test.
 * Java 8 or later. Students must calculate assessment marks themselves.
 * Access raw values with getResult(cid, assessmentName, subAssessmentName).
 * The four assessment type constants are also the assessment name keys.
 */
public final class AssessmentFeed {
    public static final String PROGRAMMING_TEST = "Independent Programming Test";
    public static final String AI_PROJECT = "AI-Assisted Programming Project";
    public static final String DESIGN_VIVA = "Software Design Viva";

    // Sub-assessment keys (the third argument to getResult).
    public static final String PROGRAM_MARK = "Program mark";
    public static final String EXPLAINED_SUCCESSFULLY = "Explained successfully";
    public static final String FUNCTIONALITY_MARK = "Functionality mark";
    public static final String VERIFICATION_MARK = "Verification mark";
    public static final String DESIGN_MARK = "Design mark";
    public static final String EXPLANATION_MARK = "Explanation mark";

    private static final List<StudentData> STUDENTS = new ArrayList<>();

    private AssessmentFeed() { }

    static {
        addStudent("10021", "Amira Shah", "UG");
        addStudent("10022", "Ben Carter", "MSc");
        addStudent("10023", "Chloe Evans", "MSc");
        addStudent("10024", "Daniel Wu", "UG");

        add("10021", PROGRAMMING_TEST, PROGRAMMING_TEST, 55, 1);
        add("10021", AI_PROJECT, AI_PROJECT, 90, 80);
        add("10021", DESIGN_VIVA, DESIGN_VIVA, 58, 62);

        add("10022", PROGRAMMING_TEST, PROGRAMMING_TEST, 85, 0);
        add("10022", AI_PROJECT, AI_PROJECT, 90, 95);
        add("10022", DESIGN_VIVA, DESIGN_VIVA, 50, 60);

        add("10023", DESIGN_VIVA, DESIGN_VIVA, 80, 90);
        add("10023", PROGRAMMING_TEST, PROGRAMMING_TEST, 75, 1);
        add("10023", AI_PROJECT, AI_PROJECT, 78, 80);

        add("10024", AI_PROJECT, AI_PROJECT, 75, 65);
        add("10024", PROGRAMMING_TEST, PROGRAMMING_TEST, 70, 1);
        add("10024", DESIGN_VIVA, DESIGN_VIVA, 72, 78);
    }

    /** Returns every CID in a stable order. */
    public static List<String> getCIDs() {
        List<String> result = new ArrayList<>();
        for (StudentData student : STUDENTS) result.add(student.cid);
        return Collections.unmodifiableList(result);
    }

    public static String getStudentName(String cid) { return student(cid).name; }

    /** Returns "UG" or "MSc". */
    public static String getStudentType(String cid) { return student(cid).type; }


    /**
     * Returns one raw result for the named student, assessment and sub-assessment.
     * Use the public static String constants for assessment and sub-assessment names.
     * All values are doubles; EXPLAINED_SUCCESSFULLY is 1.0 (true) or 0.0 (false).
     * Throws IllegalArgumentException if the student, assessment or sub-assessment
     * is unknown, or if that sub-assessment does not belong to the assessment type.
     */
    public static double getResult(String cid, String assessmentName,
                                   String subAssessmentName) {
        AssessmentData a = assessment(cid, assessmentName);
        switch (a.type) {
            case PROGRAMMING_TEST:
                if (PROGRAM_MARK.equals(subAssessmentName)) return a.first;
                if (EXPLAINED_SUCCESSFULLY.equals(subAssessmentName)) return a.second;
                break;
            case AI_PROJECT:
                if (FUNCTIONALITY_MARK.equals(subAssessmentName)) return a.first;
                if (VERIFICATION_MARK.equals(subAssessmentName)) return a.second;
                break;
            case DESIGN_VIVA:
                if (DESIGN_MARK.equals(subAssessmentName)) return a.first;
                if (EXPLANATION_MARK.equals(subAssessmentName)) return a.second;
                break;
            default:
                throw new IllegalStateException("Unknown assessment type: " + a.type);
        }
        throw new IllegalArgumentException("Unknown or invalid sub-assessment '"
                + subAssessmentName + "' for assessment '" + assessmentName + "'");
    }

    private static StudentData student(String cid) {
        for (StudentData s : STUDENTS) if (s.cid.equals(cid)) return s;
        throw new IllegalArgumentException("Unknown CID: " + cid);
    }

    private static AssessmentData assessment(String cid, String title) {
        for (AssessmentData a : student(cid).assessments)
            if (a.title.equals(title)) return a;
        throw new IllegalArgumentException(
                "Unknown assessment title '" + title + "' for CID " + cid);
    }

    private static void addStudent(String cid, String name, String type) {
        STUDENTS.add(new StudentData(cid, name, type));
    }

    private static void add(String cid, String title, String type,
                            double first, double second) {
        add(cid, title, type, first, second, 0);
    }

    private static void add(String cid, String title, String type,
                            double first, double second, double third) {
        student(cid).assessments.add(new AssessmentData(title, type, first, second, third));
    }

    private static final class StudentData {
        final String cid, name, type;
        final List<AssessmentData> assessments = new ArrayList<>();
        StudentData(String cid, String name, String type) {
            this.cid = cid; this.name = name; this.type = type;
        }
    }

    private static final class AssessmentData {
        final String title, type;
        final double first, second, third;
        AssessmentData(String title, String type, double first, double second, double third) {
            this.title = title; this.type = type;
            this.first = first; this.second = second; this.third = third;
        }
    }
}
