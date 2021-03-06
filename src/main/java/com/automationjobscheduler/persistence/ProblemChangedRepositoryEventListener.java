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

package com.automationjobscheduler.persistence;

import com.automationjobscheduler.domain.Job;
import com.automationjobscheduler.domain.Robots;
import com.automationjobscheduler.domain.Timeslot;
import org.optaplanner.core.api.solver.SolverStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeDelete;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.automationjobscheduler.rest.TimeTableController;

/**
 * This class ensures that during solving, no CRUD operations are allowed.
 */
@Component
@RepositoryEventHandler
public class ProblemChangedRepositoryEventListener {

    @Autowired
    private TimeTableController timeTableController;

    // TODO Future work: Give the CRUD operations "right of way", by calling something like this:
    // before: solverManager.freeze(TIME_TABLE_ID);
    // after: reloadProblem(TIME_TABLE_ID, timeTableRepository::findById);

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void timeslotCreateSaveDelete(Timeslot timeslot) {
        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void robotsCreateSaveDelete(Robots robots) {

        assertNotSolving();
    }

    @HandleBeforeCreate
    @HandleBeforeSave
    @HandleBeforeDelete
    private void lessonCreateSaveDelete(Job job) {
        assertNotSolving();
    }

    public void assertNotSolving() {
        // TODO Race condition: if a timeTableSolverService.solve() call arrives concurrently,
        // the com.automationjobscheduler.solver might start before the CRUD transaction completes. That's not very harmful, though.
        if (timeTableController.getSolverStatus() != SolverStatus.NOT_SOLVING) {
            throw new IllegalStateException("The com.automationjobscheduler.solver is solving. Please stop solving first.");
        }
    }

}
