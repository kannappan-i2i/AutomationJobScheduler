/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.automationjobscheduler.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.lookup.PlanningId;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalTime;
import java.util.HashMap;

@PlanningEntity
@Entity
public class Job {

    @PlanningId
    @Id @GeneratedValue
    private Long id;

    private String jobName;
    private String robotsGroup;
    private HashMap<String, LocalTime> scheduleWindow;
    private Long maxParallelization;
    private Long expectedRuntime; //expected Runtime in hours
    private enum frequency{
        NONE,
        HOURLY,
        DAILY,
        WEEKLY
    }

    public Job(Long id, String jobName, String robotsGroup, HashMap<String, LocalTime> scheduleWindow, Long maxParallelization, Long expectedRuntime, Timeslot timeslot, Robots robots) {
        this.id = id;
        this.jobName = jobName;
        this.robotsGroup = robotsGroup;
        this.scheduleWindow = scheduleWindow;
        this.maxParallelization = maxParallelization;
        this.expectedRuntime = expectedRuntime;
        this.timeslot = timeslot;
        this.robots = robots;
    }

    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    @ManyToOne
    private Timeslot timeslot;

    @PlanningVariable(valueRangeProviderRefs = "robotsRange")
    @ManyToOne
    private Robots robots;



    // No-arg constructor required for Hibernate and OptaPlanner
    public Job() {
    }

    public Job(String jobName, String robotsGroup) {
        this.jobName = jobName.trim();
        this.robotsGroup = robotsGroup.trim();
    }

    public Job(long id, String jobName,String robotsGroup, Timeslot timeslot, Robots robots) {
        this(jobName, robotsGroup);
        this.id = id;
        this.timeslot = timeslot;
        this.robots = robots;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public void setRobotsGroup(String robotsGroup) {
        this.robotsGroup = robotsGroup;
    }

    public HashMap<String, LocalTime> getScheduleWindow() {
        return scheduleWindow;
    }

    public void setScheduleWindow(HashMap<String, LocalTime> scheduleWindow) {
        this.scheduleWindow = scheduleWindow;
    }

    public Long getMaxParallelization() {
        return maxParallelization;
    }

    public void setMaxParallelization(Long maxParallelization) {
        this.maxParallelization = maxParallelization;
    }

    public Long getExpectedRuntime() {
        return expectedRuntime;
    }

    public void setExpectedRuntime(Long expectedRuntime) {
        this.expectedRuntime = expectedRuntime;
    }


    public Robots getRobots() {
        return robots;
    }

    public void setRobots(Robots robots) {
        this.robots = robots;
    }

    @Override
    public String toString() {
        return jobName + "(" + id + ")";
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public Long getId() {
        return id;
    }

    public String getJobName() {
        return jobName;
    }



    public String getRobotsGroup() {
        return robotsGroup;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }



}
