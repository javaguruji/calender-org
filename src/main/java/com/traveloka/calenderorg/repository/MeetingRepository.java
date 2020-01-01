package com.traveloka.calenderorg.repository;

import com.traveloka.calenderorg.entity.Meeting;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author badrikant.soni
 */
@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {

    @Query("SELECT m FROM Meeting m WHERE m.empId = :empId")
    List<Meeting> findMeetingByEmpId(@Param("empId") Long empId);
}
