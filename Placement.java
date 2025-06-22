package model;

public class Placement {
    private String company;
    private String role;
    private double packageOffered;
    private String status;
    private String interviewDate;

    public Placement(String company, String role, double packageOffered, String status, String interviewDate) {
        this.company = company;
        this.role = role;
        this.packageOffered = packageOffered;
        this.status = status;
        this.interviewDate = interviewDate;
    }

    // Getters
    public String getCompany() {
        return company;
    }

    public String getRole() {
        return role;
    }

    public double getPackageOffered() {
        return packageOffered;
    }

    public String getStatus() {
        return status;
    }

    public String getInterviewDate() {
        return interviewDate;
    }

    // Setters
    public void setStatus(String status) {
        this.status = status;
    }
}
