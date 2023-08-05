package com.littlepay.javacodingexercise;

import java.time.LocalDateTime;

public class Tap {
    private final int id;
    private final LocalDateTime dateTime;
    private final TapType tapType;
    private final String stopId;
    private final String companyId;
    private final String busId;
    private final String pan;

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

    public LocalDateTime getDateTime() {
        return this.dateTime;
    }

    public TapType getTapType() {
        return this.tapType;
    }

    public String getStopId() {
        return this.stopId;
    }

    public String getCompanyId() {
        return this.companyId;
    }

    public String getBusId() {
        return this.busId;
    }

    public String getPan() {
        return this.pan;
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
