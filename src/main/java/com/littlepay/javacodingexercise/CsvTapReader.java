package com.littlepay.javacodingexercise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CsvTapReader implements TapReader {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    
    private final String filename;

    public CsvTapReader(String filename) {
        this.filename = filename;
    }

    @Override
    public List<Tap> readTaps() throws IOException {
        List<Tap> taps = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int id = Integer.parseInt(values[0].trim());
                LocalDateTime dateTime = LocalDateTime.parse(values[1].trim(), formatter);
                TapType tapType = TapType.valueOf(values[2].trim());
                String stopId = values[3].trim();
                String companyId = values[4].trim();
                String busId = values[5].trim();
                String pan = values[6].trim();

                taps.add(new Tap(id, dateTime, tapType, stopId, companyId, busId, pan));
            }
        }

        return taps;
    }
}