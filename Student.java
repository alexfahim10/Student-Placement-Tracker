package model;

public class Student {
    private String name;
    private String email;
    private String rollNo;

    public Student(String name, String email, String rollNo) {
        this.name = name;
        this.email = email;
        this.rollNo = rollNo;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRollNo() {
        return rollNo;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
