package models;

public class Blocked {
    private int studentId;
    private int blocked;

    public Blocked(int studentId, int blocked) {
        this.studentId = studentId;
        this.blocked = blocked;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getBlocked() {
        return blocked;
    }
}
