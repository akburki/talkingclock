package com.ak.demo.talkingclock.controller;


import com.ak.demo.talkingclock.Service.TalkingClockService;
import com.ak.demo.talkingclock.model.ErrorMessage;
import com.ak.demo.talkingclock.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class TalkingClockController {


    @Autowired
    TalkingClockService talkingClockService;

    @GetMapping("/talkingclock/{timeInput}")
    public Response talkingClock(@PathVariable String timeInput){
        try {
            String message = talkingClockService.convert(timeInput);
            return new Response(message);
        }catch (IllegalArgumentException ex){
            return new ErrorMessage("Given time is not valid. Time should be in hh:mm format and in the rang of 00 to 23 for hours and 00 to 59 for minutes.");
        }catch (Exception ex){
            return new ErrorMessage("Something else went wrong " + ex.getMessage());
        }
    }



}
