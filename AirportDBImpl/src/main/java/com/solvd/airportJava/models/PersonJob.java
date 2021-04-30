package com.solvd.airportJava.models;

public class PersonJob extends AbstractEntity{
    private int personId;
    private int jobId;

    public PersonJob() {
    }

    public PersonJob(int id, int personId, int jobId) {
        super(id);
        this.personId = personId;
        this.jobId = jobId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "PersonJob{" +
                "id=" + getId() +
                ", personId=" + personId +
                ", jobId=" + jobId +
                '}';
    }
}
