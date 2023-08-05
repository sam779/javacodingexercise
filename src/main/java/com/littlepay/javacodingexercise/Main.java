package com.littlepay.javacodingexercise;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    private final TapReader tapReader;
    private final TripWriter tripWriter;

    public Main(TapReader tapReader, TripWriter tripWriter) {
        this.tapReader = tapReader;
        this.tripWriter = tripWriter;
    }

    public void execute() throws IOException {
        List<Tap> taps = tapReader.readTaps();
        List<Trip> trips = generateTrips(taps);
        tripWriter.writeTrips(trips);
    }  
    
    public static void main(String[] args) throws IOException{
        TapReader tapReader = new CsvTapReader("src/main/resources/taps.csv");
        TripWriter tripWriter = new CsvTripWriter("src/main/resources/trips.csv");
        Main main = new Main(tapReader, tripWriter);
        main.execute();
    }

    private static List<Trip> generateTrips(List<Tap> taps) {
        List<Trip> trips = new ArrayList<>();
        Map<String, Tap> ongoingTrips = new HashMap<>();
    
        double price12 = 3.25;
        double price23 = 5.50;
        double price13 = 7.30;
    
        for (Tap tap : taps) {
            String pan = tap.getPan();
    
            if (tap.getTapType().equals(TapType.ON)) {
                // Start a new trip
                ongoingTrips.put(pan, tap);
            } else {
                // Complete an ongoing trip
                Tap startTap = ongoingTrips.remove(pan);
    
                if (startTap == null) {
                    // Missing start tap, ignoring for simplicity
                    continue;
                }
    
                LocalDateTime started = startTap.getDateTime();
                LocalDateTime finished = tap.getDateTime();
                long durationSecs = ChronoUnit.SECONDS.between(started, finished);
                String fromStopId = startTap.getStopId();
                String toStopId = tap.getStopId();
                String companyId = tap.getCompanyId();
                String busId = tap.getBusId();
                TripStatus status = TripStatus.COMPLETED;
                double chargeAmount;
    
                if (fromStopId.equals(toStopId)) {
                    // Cancelled trip
                    chargeAmount = 0;
                    status = TripStatus.CANCELLED;
                } else if ((fromStopId.equals("Stop1") && toStopId.equals("Stop2")) ||
                           (fromStopId.equals("Stop2") && toStopId.equals("Stop1"))) {
                    chargeAmount = price12;
                } else if ((fromStopId.equals("Stop2") && toStopId.equals("Stop3")) ||
                           (fromStopId.equals("Stop3") && toStopId.equals("Stop2"))) {
                    chargeAmount = price23;
                } else if ((fromStopId.equals("Stop1") && toStopId.equals("Stop3")) ||
                           (fromStopId.equals("Stop3") && toStopId.equals("Stop1"))) {
                    chargeAmount = price13;
                } else {
                    // This should not happen if data is correct
                    chargeAmount = 0;
                }
    
                trips.add(new Trip(started, finished, durationSecs, fromStopId, toStopId, chargeAmount, companyId, busId, pan, status));
            }
        }
    
        for (Tap tap : ongoingTrips.values()) {
            // Handle incomplete trips
            LocalDateTime started = tap.getDateTime();
            LocalDateTime finished = null;
            long durationSecs = 0;
            String fromStopId = tap.getStopId();
            String toStopId = null;
            String companyId = tap.getCompanyId();
            String busId = tap.getBusId();
            TripStatus status = TripStatus.INCOMPLETE;
            String pan = tap.getPan();
            double chargeAmount;
    
            if (fromStopId.equals("Stop1")) {
                chargeAmount = price13; // max(Stop1-Stop2, Stop1-Stop3)
            } else if (fromStopId.equals("Stop2")) {
                chargeAmount = price23; // max(Stop2-Stop1, Stop2-Stop3)
            } else { // Stop3
                chargeAmount = price13; // max(Stop3-Stop1, Stop3-Stop2)
            }
    
            trips.add(new Trip(started, finished, durationSecs, fromStopId, toStopId, chargeAmount, companyId, busId, pan, status));
        }
    
        return trips;
    }
}
