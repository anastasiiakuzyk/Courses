package models;

import java.util.Date;

public class Course {
    private int id;
    private String name;
    private String theme;
    private Date start;
    private Date end;
    private int teacher_id;
    private String description;
    private User teacher;

    public Course() {
    }

    public Course(int id, String name, String theme, Date start, Date end, User teacher, String description) {
        this.id = id;
        this.name = name;
        this.theme = theme;
        this.start = start;
        this.end = end;
        this.teacher = teacher;
        this.description = description;
    }

    public Course(String name, String theme, Date start, Date end, int teacher_id, String description) {
        this.name = name;
        this.theme = theme;
        this.start = start;
        this.end = end;
        this.teacher_id = teacher_id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTheme() {
        return theme;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public String getDescription() {
        return description;
    }

    public User getTeacher() {
        return teacher;
    }
}
