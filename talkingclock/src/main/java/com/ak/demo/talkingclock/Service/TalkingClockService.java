package com.ak.demo.talkingclock.Service;

import com.ak.demo.talkingclock.constants.Constants;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Component;

@Component
public class TalkingClockService {

    public String convert(String time) throws IllegalArgumentException{

        if(!validateInput(time)) throw new IllegalArgumentException();

        String descriptiveTime = null;
        int hour = parseTime(time,0);
        int mint = parseTime(time, 1);

        String hourDesc = convertIntoString(hour, false);
        String mintDesc = convertIntoString(mint, true);

        if(mint == 0){
            descriptiveTime = hourDesc + " o'Clock";
        }else if(mint < 30){
            descriptiveTime = mintDesc + " past " + hourDesc;
        }else if(mint == 30){
            descriptiveTime = "Half past " + hourDesc;
        }else if(mint > 30){
            descriptiveTime = convertIntoString(60-mint, true) + " to " + convertIntoString( (hour+1)%12, false) ;
        }

        return descriptiveTime;

    }

    private String convertIntoString(int value, boolean mintFlag){

        String description = null;
        if(value < 20 && mintFlag){
            description = Constants.units[value];
        }else if(value < 60 && mintFlag){
            description = Constants.tens[value/10] + (value % 19 !=0 ?" ": "") + Constants.units[value%10];
        }else if (value <= 24){

            description = Constants.units[value==0 || value==12?12:value%12 ];
        }

        return description;
    }


    private int parseTime(String value, int index){
        int time = Integer.parseInt(value.split(":")[index]);
        return time;
    }


    private boolean validateInput(String input){

        try{
            int hour = parseTime(input,0);
            int mint = parseTime(input,1);
            if(hour >= 0 && hour < 24 && mint >= 0 && mint <60){
                return true;
            }
        }catch (Exception e){
            //in case of exception input is unable to parse.
            return false;
        }
        return false;
    }

}
