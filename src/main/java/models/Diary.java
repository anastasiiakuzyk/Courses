package models;

public class Diary {
    private int course_id;
    private int student_id;
    private int points;

    public Diary() {
    }

    public Diary(int course_id, int student_id, int points) {
        this.course_id = course_id;
        this.student_id = student_id;
        this.points = points;
    }
}
