package com.traveloka.calenderorg.web.controller;

import com.traveloka.calenderorg.entity.Meeting;
import com.traveloka.calenderorg.service.MeetingService;
import com.traveloka.calenderorg.web.model.MeetingDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author badrikant.soni
 */
@RestController
@RequestMapping("/meeting")
public class MeetingController {

    private final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @PostMapping("/invite")
    public ResponseEntity<Meeting> createMeetingInvite(@RequestBody MeetingDTO meetingDTO) {
        final Meeting savedMeeting = meetingService.createMeeting(meetingDTO);
        return new ResponseEntity<Meeting>(savedMeeting, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public Iterable<Meeting> getListOfMeetings(@RequestParam Long empId) {
        final Iterable<Meeting> meetings = meetingService.getMeetings(empId);
        return meetings;
    }
}
