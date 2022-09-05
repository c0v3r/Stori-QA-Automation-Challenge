package model;

public class Course {
    private String instructor;
    private String course;
    private int price;

    public Course() {
    }

    public Course(String instructor, String course, int price) {
        this.instructor = instructor;
        this.course = course;
        this.price = price;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getCourse() {
        return course;
    }

    public int getPrice() {
        return price;
    }
}
