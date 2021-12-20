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

package com.automationjobscheduler.solver;

import com.automationjobscheduler.domain.Job;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;

import java.time.Duration;

public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                robotConflict(constraintFactory)
        };
    }

    Constraint robotConflict(ConstraintFactory constraintFactory) {
        // A robot can accommodate at most one job at the same time.
        return constraintFactory
                // Select each pair of 2 different jobs ...
                .forEachUniquePair(Job.class,
                        // ... in the same timeslot ...
                        Joiners.equal(Job::getTimeslot),
                        // ... in the same robot ...
                        Joiners.equal(Job::getRobots))
                // ... and penalize each pair with a hard weight.
                .penalize("Robots conflict", HardSoftScore.ONE_HARD);
    }



}
