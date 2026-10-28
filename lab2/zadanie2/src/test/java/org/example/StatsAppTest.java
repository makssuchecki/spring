package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class StatsAppTest {
    private static final double TOLERANCE = 1e-9;

    @Test
    void computeStatsForKnownData() {
        StatsApp.Stats s = StatsApp.computeStats(2, 4, 4, 4, 5, 5, 7, 9);

        assertEquals(5.0, s.getMean(), TOLERANCE);
        assertEquals(32.0 / 7.0, s.getVar(), TOLERANCE);
        assertEquals(Math.sqrt(32.0 / 7.0), s.getSd(), TOLERANCE);
    }
    @Test
    void constantValuesHaveZeroVariance(){
        StatsApp.Stats s = StatsApp.computeStats(5, 5, 5);

        assertEquals(5.0, s.getMean(), TOLERANCE);
        assertEquals(0, s.getSd(), TOLERANCE);
        assertEquals(0, s.getVar(), TOLERANCE);
    }
    @Test
    void emptyInputThrows() {
        assertThrows(IllegalArgumentException.class, StatsApp::computeStats);
    }

    @Test
    void nullInputThrows(){
        assertThrows(IllegalArgumentException.class, () -> StatsApp.computeStats((double[]) null));
    }

}

