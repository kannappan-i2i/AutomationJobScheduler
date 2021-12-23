
package com.automationjobscheduler.solver;

import com.automationjobscheduler.domain.Job;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import org.optaplanner.core.api.score.stream.Joiners;


public class TimeTableConstraintProvider implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[] {
                // Hard constraints
                robotConflict(constraintFactory),
                timeConflict(constraintFactory)

        };
    }

    Constraint robotConflict(ConstraintFactory constraintFactory) {
        // A robot can accommodate at most one job at the same time.
        return constraintFactory
                // Select each pair of 2 different jobs ...
                .forEachUniquePair(Job.class,
                        // ... in the overlapping timeslot
                        Joiners.equal(Job::getTimeslot),
                        Joiners.overlapping(Job::getTimeslotStartTime,Job::getTimeslotEndTime),
                        // ... in the same robot ...
                        Joiners.equal(Job::getRobots),
                        Joiners.filtering((e1, e2) -> (!e1.getExpectedRuntime().toString().equals(e1.getTimeslot().getTimeRange().toString())) || (!e2.getExpectedRuntime().toString().equals(e2.getTimeslot().getTimeRange().toString())) ))

                // ... and penalize each pair with a hard weight.
                .penalize("Robots conflict", HardSoftScore.ONE_HARD);
    }


    Constraint timeConflict(ConstraintFactory constraintFactory) {
        return
                constraintFactory
                        .forEach(Job.class)
                        .filter(e -> (!e.getExpectedRuntime().toString().equals(e.getTimeslot().getTimeRange().toString())))
                        .penalize("time conflict", HardSoftScore.ONE_HARD);

    }



}
