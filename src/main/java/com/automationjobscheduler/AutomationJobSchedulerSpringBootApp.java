package com.automationjobscheduler;

import com.automationjobscheduler.domain.Job;
import com.automationjobscheduler.domain.Robots;
import com.automationjobscheduler.domain.Timeslot;
import com.automationjobscheduler.persistence.JobRepository;
import com.automationjobscheduler.persistence.RobotsRepository;
import com.automationjobscheduler.persistence.TimeslotRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

/*
`* @author : Kannappan
 */
@SpringBootApplication
public class AutomationJobSchedulerSpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(AutomationJobSchedulerSpringBootApp.class, args);
    }


    @Value("${timeTable.demoData:SMALL}")
    private DemoData demoData;

    @Bean
    public CommandLineRunner demoData(
            TimeslotRepository timeslotRepository,
            RobotsRepository robotsRepository,
            JobRepository jobRepository) {
        return (args) -> {
            if (demoData == DemoData.NONE) {
                return;
            }

            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 30), LocalTime.of(9, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(9, 30), LocalTime.of(10, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 30), LocalTime.of(11, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 30), LocalTime.of(14, 30)));
            timeslotRepository.save(new Timeslot(DayOfWeek.FRIDAY, LocalTime.of(14, 30), LocalTime.of(15, 30)));

            robotsRepository.save(new Robots("Robots A"));
            robotsRepository.save(new Robots("Robots B"));
            robotsRepository.save(new Robots("Robots C"));
            robotsRepository.save(new Robots("Robots D"));
            robotsRepository.save(new Robots("Robots E"));
            robotsRepository.save(new Robots("Robots F"));


            HashMap<String, LocalTime> jobScheduledTime = new HashMap<>();
            jobScheduledTime.put("startTime",LocalTime.of(8, 30));
            jobScheduledTime.put("endTime",LocalTime.of(9, 30));

            HashMap<String, LocalTime> jobScheduledTime1 = new HashMap<>();
            jobScheduledTime1.put("startTime",LocalTime.of(9, 30));
            jobScheduledTime1.put("endTime",LocalTime.of(10, 30));

            HashMap<String, LocalTime> jobScheduledTime2 = new HashMap<>();
            jobScheduledTime2.put("startTime",LocalTime.of(10, 30));
            jobScheduledTime2.put("endTime",LocalTime.of(11, 30));

            HashMap<String, LocalTime> jobScheduledTime3 = new HashMap<>();
            jobScheduledTime3.put("startTime",LocalTime.of(13, 30));
            jobScheduledTime3.put("endTime",LocalTime.of(14, 30));

            HashMap<String, LocalTime> jobScheduledTime4 = new HashMap<>();
            jobScheduledTime4.put("startTime",LocalTime.of(14, 30));
            jobScheduledTime4.put("endTime",LocalTime.of(15, 15));

            jobRepository.save(new Job(Long.valueOf("1"),"Job 01","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null ));
            jobRepository.save(new Job(Long.valueOf("2"),"Job 02","B",jobScheduledTime1,Long.valueOf("2"),Long.valueOf("1"),null,null ));
            jobRepository.save(new Job(Long.valueOf("3"),"Job 03","A",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("1"),null,null ));
            jobRepository.save(new Job(Long.valueOf("4"),"Job 04","A",jobScheduledTime3,Long.valueOf("2"),Long.valueOf("1"),null,null ));
            jobRepository.save(new Job(Long.valueOf("5"),"Job 05","A",jobScheduledTime4,Long.valueOf("1"),Long.valueOf("1"),null,null ));
            jobRepository.save(new Job(Long.valueOf("5"),"Job 06","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null ));


            Job job = jobRepository.findAll(Sort.by("id")).iterator().next();
            job.setTimeslot(timeslotRepository.findAll(Sort.by("id")).iterator().next());
            job.setRobots(robotsRepository.findAll(Sort.by("id")).iterator().next());

            jobRepository.save(job);
        };
    }

    public enum DemoData {
        NONE,
        SMALL,
        LARGE
    }


}

