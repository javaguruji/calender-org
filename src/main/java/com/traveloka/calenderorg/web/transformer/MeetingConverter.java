package com.traveloka.calenderorg.web.transformer;

import com.traveloka.calenderorg.entity.Meeting;
import com.traveloka.calenderorg.web.model.MeetingDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author badrikant.soni
 */
@Component
public class MeetingConverter implements Converter<MeetingDTO, Meeting> {

    @Override
    public MeetingDTO toDTO(Meeting meeting) {
        return null;
    }

    @Override
    public Meeting toEntity(MeetingDTO meetingDTO) {
        return null;
    }

    public List<Meeting> toEntityList(MeetingDTO meetingDTO) {
        List<Meeting> meetings = new ArrayList<>();
        final List<Long> empId = meetingDTO.getEmpId();
        for (Long id : empId) {

            final Meeting meeting = Meeting.builder()
                    .empId(id)
                    .meetingRoomName(meetingDTO.getMeetingRoomName())
                    .build();
            meetings.add(meeting);
        }
        return meetings;
    }
}
