package com.traveloka.calenderorg.web.model;

import lombok.Data;

import java.util.List;

/**
 * @author badrikant.soni
 */
@Data
public class MeetingDTO {

    private String meetingRoomName;

    private List<Long> empId;

}