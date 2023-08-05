package com.littlepay.javacodingexercise;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CsvTripWriter implements TripWriter {
    private final String filename;

    public CsvTripWriter(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeTrips(List<Trip> trips) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write CSV header
            writer.println("Started, Finished, DurationSecs, FromStopId, ToStopId, ChargeAmount, CompanyId, BusID, PAN, Status");
    
            // Write trips
            for (Trip trip : trips) {
                writer.println(String.format(
                    "%s, %s, %d, %s, %s, %.2f, %s, %s, %s, %s",
                    trip.getStarted(),
                    trip.getFinished(),
                    trip.getDurationSecs(),
                    trip.getFromStopId(),
                    trip.getToStopId(),
                    trip.getChargeAmount(),
                    trip.getCompanyId(),
                    trip.getBusId(),
                    trip.getPan(),
                    trip.getStatus()
                ));
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}