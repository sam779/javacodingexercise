package com.littlepay.javacodingexercise;

import java.time.LocalDateTime;

public class Tap {
    private int id;
    private LocalDateTime dateTime;
    private TapType tapType;
    private String stopId;
    private String companyId;
    private String busId;
    private String pan;

    public Tap(int id, LocalDateTime dateTime, TapType tapType, String stopId, String companyId, String busId, String pan) {
        this.id = id;
        this.dateTime = dateTime;
        this.tapType = tapType;
        this.stopId = stopId;
        this.companyId = companyId;
        this.busId = busId;
        this.pan = pan;
    }

    // getters and setters

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TapType getTapType() {
        return this.tapType;
    }

    public void setTapType(TapType tapType) {
        this.tapType = tapType;
    }

    public String getStopId() {
        return this.stopId;
    }

    public void setStopId(String stopTd) {
        this.stopId = stopTd;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getBusId() {
        return this.busId;
    }

    public void setBusId(String busId) {
        this.busId = busId;
    }

    public String getPan() {
        return this.pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }



    @Override
    public String toString() {
        return "Tap{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", tapType='" + tapType + '\'' +
                ", stopId='" + stopId + '\'' +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                ", pan=" + pan +
                '}';
    }
}
