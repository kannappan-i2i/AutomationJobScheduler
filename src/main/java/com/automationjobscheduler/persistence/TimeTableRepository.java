

package com.automationjobscheduler.persistence;

import com.automationjobscheduler.domain.Job;
import com.automationjobscheduler.domain.TimeTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TimeTableRepository {

    // There is only one time table, so there is only timeTableId (= problemId).
    public static final Long SINGLETON_TIME_TABLE_ID = 1L;

    @Autowired
    private TimeslotRepository timeslotRepository;
    @Autowired
    private RobotsRepository robotsRepository;
    @Autowired
    private JobRepository jobRepository;

    public TimeTable findById(Long id) {
        if (!SINGLETON_TIME_TABLE_ID.equals(id)) {
            throw new IllegalStateException("There is no timeTable with id (" + id + ").");
        }
        // Occurs in a single transaction, so each initialized lesson references the same timeslot/room instance
        // that is contained by the timeTable's timeslotList/roomList.
        return new TimeTable(
                timeslotRepository.findAll(),
                robotsRepository.findAll(),
                jobRepository.findAll());
    }

    public void save(TimeTable timeTable) {
        for (Job job : timeTable.getJobList()) {
            // TODO this is awfully naive: optimistic locking causes issues if called by the SolverManager
                jobRepository.save(job);
        }
    }

}
