package com.littlepay.javacodingexercise;

import java.time.LocalDateTime;

public class Trip {
    private LocalDateTime started;
    private LocalDateTime finished;
    private long durationSecs;
    private String fromStopId;
    private String toStopId;
    private double chargeAmount;
    private String companyId;
    private String busId;
    private String pan;
    private TripStatus status;

    public Trip(LocalDateTime started, LocalDateTime finished, long durationSecs, String fromStopId, String toStopId, double chargeAmount, String companyId, String busId, String pan, TripStatus status) {
        this.started = started;
        this.finished = finished;
        this.durationSecs = durationSecs;
        this.fromStopId = fromStopId;
        this.toStopId = toStopId;
        this.chargeAmount = chargeAmount;
        this.companyId = companyId;
        this.busId = busId;
        this.pan = pan;
        this.status = status;
    }

    // getters and setters

    public LocalDateTime getStarted() {
        return this.started;
    }

    public void setStarted(LocalDateTime started) {
        this.started = started;
    }

    public LocalDateTime getFinished() {
        return this.finished;
    }

    public void setFinished(LocalDateTime finished) {
        this.finished = finished;
    }

    public long getDurationSecs() {
        return this.durationSecs;
    }

    public void setDurationSecs(long durationSecs) {
        this.durationSecs = durationSecs;
    }

    public String getFromStopId() {
        return this.fromStopId;
    }

    public void setFromStopId(String fromStopId) {
        this.fromStopId = fromStopId;
    }

    public String getToStopId() {
        return this.toStopId;
    }

    public void setToStopId(String toStopId) {
        this.toStopId = toStopId;
    }

    public double getChargeAmount() {
        return this.chargeAmount;
    }

    public void setChargeAmount(double chargeAmount) {
        this.chargeAmount = chargeAmount;
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

    public TripStatus getStatus() {
        return this.status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "started=" + started +
                ", finished=" + finished +
                ", durationSecs=" + durationSecs +
                ", fromStopId='" + fromStopId + '\'' +
                ", toStopId='" + toStopId + '\'' +
                ", chargeAmount=" + chargeAmount +
                ", companyId='" + companyId + '\'' +
                ", busId='" + busId + '\'' +
                ", pan=" + pan +
                ", status='" + status + '\'' +
                '}';
    }
}
