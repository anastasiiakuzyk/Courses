package models;

public class Diary {
    private int course_id;
    private int student_id;
    private int points;
    private String studentName;
    private String studentEmail;

    public Diary() {
    }

    public Diary(int course_id, int student_id, int points) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.points = points;
    }

    public Diary(int student_id, String studentName, String studentEmail, int course_id, int points) {
        this.course_id = course_id;
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.student_id = student_id;
        this.points = points;
    }

    public int getCourse_id() {
        return course_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getPoints() {
        return points;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }
}
