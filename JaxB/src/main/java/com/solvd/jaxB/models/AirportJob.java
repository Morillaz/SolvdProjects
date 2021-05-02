package com.solvd.jaxB.models;

public class AirportJob extends AbstractEntity{
    private int airportId;
    private int jobId;

    public AirportJob() {
    }

    public AirportJob(int id, int airportId, int jobId) {
        super(id);
        this.airportId = airportId;
        this.jobId = jobId;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "AirportJob{" +
                "id=" + getId() +
                ", airportId=" + airportId +
                ", jobId=" + jobId +
                '}';
    }
}
