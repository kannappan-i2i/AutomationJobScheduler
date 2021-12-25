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
import java.time.LocalTime;
import java.util.HashMap;

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

            // 1hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(0, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(1, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(2, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(3, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(4, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(5, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(6, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(7, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(8, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(9, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(10, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(11, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(12, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(13, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(14, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(15, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(16, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(17, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(18, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(19, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(20, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(21, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(22, 0), LocalTime.of(22, 59,59),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(23, 0), LocalTime.of(23, 59, 59),1));

            //2 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(1, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(2, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(3, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(4, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(5, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(6, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(7, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(8, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(9, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(10, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(12, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(13, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(14, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(15, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(16, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(17, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(18, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(19, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(20, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(21, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(22, 59,59),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(22, 0), LocalTime.of(23, 59, 59),2));

            //3 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(2, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(3, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(4, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(5, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(6, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(7, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(8, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(9, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(10, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(13, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(14, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(15, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(16, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(17, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(18, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(19, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(20, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(21, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(22, 59,59),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(23, 59,59),3));

            //5 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(4, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(5, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(6, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(7, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(8, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(9, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(10, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(11, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(12, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(13, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(14, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(15, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(16, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(17, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(18, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(19, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(20, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(21, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(22, 59,59),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(23, 59,59),5));


            robotsRepository.save(new Robots("Robots A"));
            robotsRepository.save(new Robots("Robots B"));



            HashMap<String, LocalTime> jobScheduledTime = new HashMap<>();
            jobScheduledTime.put("startTime",LocalTime.of(0, 0));
            jobScheduledTime.put("endTime",LocalTime.of(23, 0));

            HashMap<String, LocalTime> jobScheduledTime1 = new HashMap<>();
            jobScheduledTime1.put("startTime",LocalTime.of(1, 0));
            jobScheduledTime1.put("endTime",LocalTime.of(11, 0));

            HashMap<String, LocalTime> jobScheduledTime2 = new HashMap<>();
            jobScheduledTime1.put("startTime",LocalTime.of(18, 0));
            jobScheduledTime1.put("endTime",LocalTime.of(6, 0));

            HashMap<String, LocalTime> jobScheduledTime3 = new HashMap<>();
            jobScheduledTime1.put("startTime",LocalTime.of(0, 0));
            jobScheduledTime1.put("endTime",LocalTime.of(22, 0));




            jobRepository.save(new Job(Long.valueOf("1115"),"Job 1115","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("5"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1116"),"Job 1116","B",jobScheduledTime1,Long.valueOf("1"),Long.valueOf("5"),null,null, "Job B" ));
            jobRepository.save(new Job(Long.valueOf("1117"),"Job 1117","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null, "Job C" ));
            jobRepository.save(new Job(Long.valueOf("1118"),"Job 1118","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null,"Job C" ));
            jobRepository.save(new Job(Long.valueOf("1119"),"Job 1119","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null,"Job C" ));
            jobRepository.save(new Job(Long.valueOf("1120"),"Job 1120","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1121"),"Job 1121","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1122"),"Job 1122","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1123"),"Job 1123","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1124"),"Job 1124","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1125"),"Job 1125","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("5"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1126"),"Job 1126","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1127"),"Job 1127","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));



            Job job = jobRepository.findAll(Sort.by("id")).iterator().next();
            job.setTimeslot(timeslotRepository.findAll(Sort.by("id")).iterator().next().getTimeRange().toString().equals(job.getExpectedRuntime().toString()) ? timeslotRepository.findAll(Sort.by("id")).iterator().next() : null);
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



