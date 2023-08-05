package com.littlepay.javacodingexercise;

import java.io.IOException;
import java.util.List;

public interface TripWriter {
    void writeTrips(List<Trip> trips) throws IOException;
}
