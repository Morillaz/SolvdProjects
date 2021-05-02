package com.solvd.jaxB.models;

public class Job extends AbstractEntity{
    private String area;
    private String role;

    public Job() {
    }

    public Job(int id, String area, String role) {
        super(id);
        this.area = area;
        this.role = role;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + getId() +
                ", area='" + area + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
