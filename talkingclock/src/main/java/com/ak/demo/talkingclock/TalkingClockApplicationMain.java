package com.ak.demo.talkingclock;

import com.ak.demo.talkingclock.Service.TalkingClockService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class TalkingClockApplicationMain {

    public static void main(String[] args){

        Logger log = Logger.getLogger("TalkingClockApplicationMain.class");
        String vTime = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
        TalkingClockService talkingClockService = new TalkingClockService();

        //Passing current time.
        log.info("Time from talking clock " +  talkingClockService.convert(vTime));

        //in case user passed the input
        for(String input:args)
        log.info("Time from talking clock " + talkingClockService.convert(input));

    }
}
