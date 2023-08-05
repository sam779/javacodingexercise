package com.littlepay.javacodingexercise;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.io.IOException;
import java.util.Arrays;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

public class MainTest {
    private TapReader mockTapReader;
    private TripWriter mockTripWriter;
    private Main main;

    @BeforeEach
    public void setUp() {
        mockTapReader = mock(TapReader.class);
        mockTripWriter = mock(TripWriter.class);
        main = new Main(mockTapReader, mockTripWriter);
    }

    @Test
    public void testExecute_CompletedTrip() throws IOException {
        Tap tap1 = new Tap(
                1,
                LocalDateTime.parse("22-01-2023 13:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                TapType.ON,
                "Stop1",
                "Company1",
                "Bus37",
                "5454545454545454"
        );

        Tap tap2 = new Tap(
                2,
                LocalDateTime.parse("22-01-2023 13:05:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                TapType.OFF,
                "Stop2",
                "Company1",
                "Bus37",
                "5454545454545454"
        );

        when(mockTapReader.readTaps()).thenReturn(Arrays.asList(tap1, tap2));

        main.execute();

        verify(mockTapReader, times(1)).readTaps();
        verify(mockTripWriter, times(1)).writeTrips(anyList());
    }

    @Test
    public void testExecute_IncompleteTrip() throws IOException {
        Tap tap1 = new Tap(
                1,
                LocalDateTime.parse("22-01-2023 13:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                TapType.ON,
                "Stop1",
                "Company1",
                "Bus37",
                "5454545454545454"
        );

        // No corresponding OFF tap
        when(mockTapReader.readTaps()).thenReturn(Collections.singletonList(tap1));

        main.execute();

        verify(mockTapReader, times(1)).readTaps();
        verify(mockTripWriter, times(1)).writeTrips(argThat(trips ->
                trips.size() == 1 &&
                        trips.get(0).getStatus().equals(TripStatus.INCOMPLETE)
        ));
    }

    @Test
    public void testExecute_CancelledTrip() throws IOException {
        Tap tap1 = new Tap(
                1,
                LocalDateTime.parse("22-01-2023 13:00:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                TapType.ON,
                "Stop1",
                "Company1",
                "Bus37",
                "4444333322221111"
        );

        Tap tap2 = new Tap(
                2,
                LocalDateTime.parse("22-01-2023 13:02:00", DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")),
                TapType.OFF,
                "Stop1",
                "Company1",
                "Bus37",
                "4444333322221111"
        );

        when(mockTapReader.readTaps()).thenReturn(Arrays.asList(tap1, tap2));

        main.execute();

        verify(mockTapReader, times(1)).readTaps();
        verify(mockTripWriter, times(1)).writeTrips(argThat(trips ->
                trips.size() == 1 &&
                        trips.get(0).getStatus().equals(TripStatus.CANCELLED)
        ));
    }
}
