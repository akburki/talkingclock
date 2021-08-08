package com.ak.demo.talkingclock.Service;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.jupiter.api.Assertions.*;

class TalkingClockServiceTest {
    TalkingClockService talkingClockService;

    @BeforeEach
    void setUp() {
        talkingClockService = new TalkingClockService();
    }

    @Test
    void convert2000() {

        assertEquals("Eight o'Clock",talkingClockService.convert("20:00"));

    }
    @Test
    void convert0000() {

        assertEquals("Twelve o'Clock",talkingClockService.convert("00:00"));

    }
    @Test
    void convert1200() {

        assertEquals("Twelve o'Clock",talkingClockService.convert("12:00"));

    }
    @Test
    void convert2045() {

        assertEquals("Fifteen to Nine",talkingClockService.convert("20:45"));

    }
    @Test
    void convert0325() {

        assertEquals("Twenty Five past Three",talkingClockService.convert("03:25"));

    }
    @Test
    void convert2359() {

        assertEquals("One to Twelve",talkingClockService.convert("23:59"));

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void convert2370() {

        assertThrows(IllegalArgumentException.class, ()-> talkingClockService.convert("23:70"));

    }
}