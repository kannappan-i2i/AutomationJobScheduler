
package com.automationjobscheduler.solver;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.toList;
import com.automationjobscheduler.domain.Job;
import com.automationjobscheduler.domain.Timeslot;
import org.optaplanner.core.api.score.buildin.hardmediumsoft.HardMediumSoftScore;
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
                overLappingTimeWindowConflict(constraintFactory),
                rewardExpectedTimeWindowConflict(constraintFactory),
                penalizeMismatchTimeWindowConflict(constraintFactory),
                rewardBoundScheduleWindowConflict(constraintFactory),
                penalizeOutofBoundScheduleWindowConflict(constraintFactory)

        };
    }

    Constraint robotConflict(ConstraintFactory constraintFactory) {
        // A robot can accommodate at most one job at the same time.
        return constraintFactory
                // Select  pair of 2 different jobs ...
                .forEachUniquePair(Job.class,
                        // ... in the overlapping timeslot
                        Joiners.equal(Job::getTimeslot),
                        // ... in the same robot ...
                        Joiners.equal(Job::getRobots),
                        // ... in the same day ...
                        Joiners.filtering((leftJob,rightJob) -> leftJob.getStartDayOfWeek().equals(rightJob.getStartDayOfWeek())  ))
                // ... and penalize each pair with a hard weight.
                .penalize("Robots conflict", HardSoftScore.ONE_HARD);
    }

    Constraint overLappingTimeWindowConflict(ConstraintFactory constraintFactory) {
        // Same robots overlapping eachother in same day
        return constraintFactory
                // Select each pair of 2 different jobs ...
                .forEachUniquePair(Job.class,
                        // ... in the overlapping timeslot
                        Joiners.equal(Job::getRobots),
                        Joiners.filtering((leftJob,rightJob) -> leftJob.getStartDayOfWeek().equals(rightJob.getStartDayOfWeek()) ),
                        Joiners.filtering((leftJob, rightJob) ->
                                        ( (leftJob.getEndDateTime().compareTo(rightJob.getEndDateTime()) <= 0) &&
                                        (leftJob.getStartDateTime().compareTo(rightJob.getStartDateTime()) >= 0) )  ||
                                                ( (rightJob.getEndDateTime().compareTo(leftJob.getEndDateTime()) <= 0 &&
                                                        (rightJob.getStartDateTime().compareTo(leftJob.getStartDateTime()) >= 0))) ||
                                                ((leftJob.getStartDateTime().compareTo(rightJob.getEndDateTime()) <=0 && leftJob.getStartDateTime().compareTo(rightJob.getStartDateTime()) >= 0)) ||
                                                ((rightJob.getStartDateTime().compareTo(leftJob.getEndDateTime()) <= 0 && rightJob.getStartDateTime().compareTo(leftJob.getStartDateTime()) >= 0)) ||
                                                ((leftJob.getScheduleWindow().get("endTime").compareTo(leftJob.getScheduleWindow().get("startTime")) <0 || (rightJob.getScheduleWindow().get("endTime").compareTo(rightJob.getScheduleWindow().get("startTime")) < 0 ) ) &&
                                                        (leftJob.getStartDateTime().compareTo(rightJob.getStartDateTime()) == 0 ||
                                                                leftJob.getEndDateTime().compareTo(rightJob.getEndDateTime()) == 0))
                                ))
                // ... and penalize each pair with a hard weight.
                .penalize("overlapping time window conflict", HardSoftScore.ONE_HARD );
    }

    Constraint rewardExpectedTimeWindowConflict(ConstraintFactory constraintFactory) {
        return
                constraintFactory
                        .forEach(Job.class)
                        .filter(e -> (e.getExpectedRuntime().toString().equals(e.getTimeslot().getTimeRange().toString())))
                        .reward("expected time window match found", HardSoftScore.ONE_SOFT);

    }

    Constraint penalizeMismatchTimeWindowConflict(ConstraintFactory constraintFactory) {
        return
                constraintFactory
                        .forEach(Job.class)
                        .filter(e -> (!(e.getExpectedRuntime().toString().equals(e.getTimeslot().getTimeRange().toString()))))
                        .penalize(" expected time window conflict", HardSoftScore.ONE_HARD);

    }

    Constraint rewardBoundScheduleWindowConflict(ConstraintFactory constraintFactory){
        return
                constraintFactory
                        .forEach(Job.class)
                        .filter(e -> (e.getEndDateTime().compareTo(e.getScheduleWindow().get("endTime")) <=0 ) && e.getStartDateTime().compareTo(e.getScheduleWindow().get("startTime")) >= 0  )
                        .reward("Bounded schedule window", HardSoftScore.ONE_SOFT);
    }

    Constraint penalizeOutofBoundScheduleWindowConflict(ConstraintFactory constraintFactory){
        return
                constraintFactory
                        .forEach(Job.class)
                        .filter(e -> (!((e.getEndDateTime().compareTo(e.getScheduleWindow().get("endTime")) <=0 ) && (e.getStartDateTime().compareTo(e.getScheduleWindow().get("startTime")) >= 0 ) ) ))
                        .penalize("Out of bound schedule window", HardSoftScore.ONE_HARD);
    }



     /*

    Constraint overLappingTimeWindowConflict(ConstraintFactory constraintFactory) {
        // Same robots overlapping eachother in same day
        return constraintFactory
                // Select each pair of 2 different jobs ...
                .forEachUniquePair(Job.class,
                        // ... in the overlapping timeslot
                        Joiners.equal(Job::getRobots),
                        Joiners.filtering((leftJob, rightJob) ->  (leftJob.getTimeslot() != null && rightJob.getTimeslot() != null ) ? leftJob.getTimeslot().getDayOfWeek().equals(rightJob.getTimeslot().getDayOfWeek()) : false),
                        Joiners.filtering((leftJob, rightJob) -> (leftJob.getTimeslot() != null && rightJob.getTimeslot() != null ) ? leftJob.getTimeslot().overlapsTime(rightJob.getTimeslot()) : false))
                // ... and penalize each pair with a hard weight.
                .penalize("overlapping time window conflict", HardSoftScore.ofHard(10) );
    }




    Constraint overlappingWindowTimeConflict(ConstraintFactory constraintFactory){
        return constraintFactory.forEachUniquePair(Job.class,
                Joiners.overlapping(Job::getStartDateTime,Job::getEndDateTime),
                Joiners.equal(Job::getRobots))
                .penalize("overlapping window time conflict",HardSoftScore.ofHard(10));
    }



    Constraint newTimeRangeConflict(ConstraintFactory constraintFactory){
        return constraintFactory.forEach(Job.class)
                .groupBy(Job::getTimeslot, toList())
                .filter((timeSlot, jobList) -> jobList.stream().)
                .penalize("new time rangeconflict",HardSoftScore.ofHard(10));
    }


     */



}
