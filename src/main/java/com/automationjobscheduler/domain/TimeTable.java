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

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.solver.SolverStatus;

import java.util.List;

@PlanningSolution
public class TimeTable {

    @ValueRangeProvider(id = "timeslotRange")
    @ProblemFactCollectionProperty
    private List<Timeslot> timeslotList;

    @ValueRangeProvider(id = "robotsRange")
    @ProblemFactCollectionProperty
    private List<Robots> robotsList;

    @PlanningEntityCollectionProperty
    private List<Job> jobList;

    @PlanningScore
    private HardSoftScore score;

    // Ignored by OptaPlanner, used by the UI to display solve or stop solving button
    private SolverStatus solverStatus;

    // No-arg constructor required for OptaPlanner
    public TimeTable() {
    }

    public TimeTable(List<Timeslot> timeslotList, List<Robots> robotsList,
            List<Job> jobList) {
        this.timeslotList = timeslotList;
        this.robotsList = robotsList;
        this.jobList = jobList;
    }

    // ************************************************************************
    // Getters and setters
    // ************************************************************************

    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    public List<Robots> getRobotsList() {
        return robotsList;
    }

    public List<Job> getLessonList() {
        return jobList;
    }

    public HardSoftScore getScore() {
        return score;
    }

    public SolverStatus getSolverStatus() {
        return solverStatus;
    }

    public void setSolverStatus(SolverStatus solverStatus) {
        this.solverStatus = solverStatus;
    }

}
