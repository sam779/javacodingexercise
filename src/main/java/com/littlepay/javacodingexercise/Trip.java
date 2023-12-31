package com.littlepay.javacodingexercise;

import java.time.LocalDateTime;

public class Trip {
    private final LocalDateTime started;
    private final LocalDateTime finished;
    private final long durationSecs;
    private final String fromStopId;
    private final String toStopId;
    private final double chargeAmount;
    private final String companyId;
    private final String busId;
    private final String pan;
    private final TripStatus status;

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

    public LocalDateTime getFinished() {
        return this.finished;
    }

    public long getDurationSecs() {
        return this.durationSecs;
    }

    public String getFromStopId() {
        return this.fromStopId;
    }

    public String getToStopId() {
        return this.toStopId;
    }

    public double getChargeAmount() {
        return this.chargeAmount;
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

    public TripStatus getStatus() {
        return this.status;
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
