package com.traveloka.calenderorg.service;

import com.traveloka.calenderorg.entity.Meeting;
import com.traveloka.calenderorg.repository.MeetingRepository;
import com.traveloka.calenderorg.web.model.MeetingDTO;
import com.traveloka.calenderorg.web.transformer.MeetingConverter;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author badrikant.soni
 */
@Service
public class MeetingService {

    private final MeetingRepository meetingRepository;
    private final MeetingConverter meetingConverter;

    public MeetingService(MeetingRepository meetingRepository, MeetingConverter meetingConverter) {
        this.meetingRepository = meetingRepository;
        this.meetingConverter = meetingConverter;
    }

    public Meeting createMeeting(MeetingDTO meetingDTO) {
        final List<Meeting> meetings = meetingConverter.toEntityList(meetingDTO);
        Meeting saveMeeting = null;
        for(Meeting meeting : meetings){
            saveMeeting = meetingRepository.save(meeting);
        }
        return saveMeeting;
    }

    public Iterable<Meeting> getMeetings(Long empId) {
        final List<Meeting> meetings = meetingRepository.findMeetingByEmpId(empId);
        return meetings;
    }
}
