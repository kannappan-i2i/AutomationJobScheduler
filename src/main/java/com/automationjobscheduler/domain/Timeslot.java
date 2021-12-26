

package com.automationjobscheduler.domain;

import org.optaplanner.core.api.domain.lookup.PlanningId;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Timeslot {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private DayOfWeek startDayOfWeek;
    private DayOfWeek endDayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer timeRange;


    public Integer getTimeRange() {
        return timeRange;
    }

    public void setTimeRange(Integer timeRange) {
        this.timeRange = timeRange;
    }

    // No-arg constructor required for Hibernate
    public Timeslot() {
    }

    public Timeslot(DayOfWeek startDayOfWeek, LocalTime startTime, LocalTime endTime, Integer timeRange, DayOfWeek endDayOfWeek) {
        this.startDayOfWeek = startDayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeRange = timeRange;
        this.endDayOfWeek = endDayOfWeek;
    }


    @Override
    public String toString() {
        return startDayOfWeek + " " + startTime;
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public Long getId() {
        return id;
    }

    public DayOfWeek getStartDayOfWeek() {
        return startDayOfWeek;
    }

    public DayOfWeek getEndDayOfWeek() {
        return endDayOfWeek;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public boolean overlapsTime(Timeslot other){
        if(this == other){
            return true;
        }
        return startTime.compareTo(other.endTime) < 0 && other.startTime.compareTo(endTime)<0;
    }

}
