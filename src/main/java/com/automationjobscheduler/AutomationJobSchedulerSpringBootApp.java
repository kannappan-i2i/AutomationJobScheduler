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
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(1, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(2, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(3, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(4, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(5, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(6, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(7, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(8, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(9, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(10, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(11, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(12, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(13, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(14, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(15, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(16, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(17, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(18, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(19, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(20, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(21, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(22, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(22, 0), LocalTime.of(23, 0),1));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(23, 0), LocalTime.of(0, 0),1));

            //2 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(2, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(3, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(4, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(5, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(6, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(7, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(8, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(9, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(10, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(11, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(12, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(13, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(14, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(15, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(16, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(17, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(18, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(19, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(20, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(21, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(22, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(23, 0),2));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(22, 0), LocalTime.of(0, 0),2));

            //3 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(3, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(4, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(5, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(6, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(7, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(8, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(9, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(10, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(11, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(12, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(13, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(14, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(15, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(16, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(17, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(18, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(19, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(20, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(21, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(22, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(20, 0), LocalTime.of(23, 0),3));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(21, 0), LocalTime.of(0, 0),3));

            //5 hour time slot
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(0, 0), LocalTime.of(5, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(1, 0), LocalTime.of(6, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(2, 0), LocalTime.of(7, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(3, 0), LocalTime.of(8, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(4, 0), LocalTime.of(9, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(5, 0), LocalTime.of(10, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(6, 0), LocalTime.of(11, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(7, 0), LocalTime.of(12, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(8, 0), LocalTime.of(13, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(9, 0), LocalTime.of(14, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(10, 0), LocalTime.of(15, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(11, 0), LocalTime.of(16, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(12, 0), LocalTime.of(17, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(13, 0), LocalTime.of(18, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(14, 0), LocalTime.of(19, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(15, 0), LocalTime.of(20, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(16, 0), LocalTime.of(21, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(17, 0), LocalTime.of(22, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(18, 0), LocalTime.of(23, 0),5));
            timeslotRepository.save(new Timeslot(DayOfWeek.MONDAY, LocalTime.of(19, 0), LocalTime.of(0, 0),5));


            robotsRepository.save(new Robots("Robots A"));
            robotsRepository.save(new Robots("Robots B"));
            robotsRepository.save(new Robots("Robots C"));
            robotsRepository.save(new Robots("Robots D"));
            robotsRepository.save(new Robots("Robots E"));
            robotsRepository.save(new Robots("Robots F"));


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


            jobRepository.save(new Job(Long.valueOf("1000"),"Job 1001","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1002"),"Job 1002","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1003"),"Job 1003","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1004"),"Job 1004","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1005"),"Job 1005","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1006"),"Job 1006","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1007"),"Job 1007","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1008"),"Job 1008","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1009"),"Job 1009","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1010"),"Job 1010","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1011"),"Job 1011","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1012"),"Job 1012","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1013"),"Job 1013","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1014"),"Job 1014","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1015"),"Job 1015","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1016"),"Job 1016","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1017"),"Job 1017","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1018"),"Job 1018","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1019"),"Job 1019","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1020"),"Job 1020","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1021"),"Job 1021","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1022"),"Job 1022","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1023"),"Job 1023","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1024"),"Job 1024","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1025"),"Job 1025","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1026"),"Job 1026","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1027"),"Job 1027","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1028"),"Job 1028","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1029"),"Job 1029","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null , "Job A"));
            jobRepository.save(new Job(Long.valueOf("1030"),"Job 1030","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1031"),"Job 1031","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1032"),"Job 1032","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1033"),"Job 1033","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1034"),"Job 1034","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1035"),"Job 1035","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1036"),"Job 1036","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1037"),"Job 1037","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1038"),"Job 1038","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1039"),"Job 1039","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1040"),"Job 1040","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1041"),"Job 1041","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1042"),"Job 1042","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1043"),"Job 1043","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1044"),"Job 1044","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1045"),"Job 1045","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1046"),"Job 1046","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1047"),"Job 1047","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1048"),"Job 1048","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1049"),"Job 1049","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1050"),"Job 1050","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1051"),"Job 1051","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1052"),"Job 1052","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1053"),"Job 1053","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1054"),"Job 1054","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1055"),"Job 1055","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1056"),"Job 1056","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1057"),"Job 1057","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1058"),"Job 1058","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1059"),"Job 1059","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1060"),"Job 1060","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1061"),"Job 1061","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1062"),"Job 1062","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1063"),"Job 1063","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1064"),"Job 1064","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1065"),"Job 1065","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1066"),"Job 1066","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1067"),"Job 1067","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1068"),"Job 1068","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1069"),"Job 1069","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1070"),"Job 1070","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1071"),"Job 1071","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1072"),"Job 1072","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null , "Job A"));
            jobRepository.save(new Job(Long.valueOf("1073"),"Job 1073","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1074"),"Job 1074","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1075"),"Job 1075","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1076"),"Job 1076","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null , "Job A"));
            jobRepository.save(new Job(Long.valueOf("1077"),"Job 1077","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1078"),"Job 1078","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1079"),"Job 1079","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1080"),"Job 1080","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1081"),"Job 1081","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1082"),"Job 1082","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1083"),"Job 1083","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1084"),"Job 1084","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1085"),"Job 1085","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1086"),"Job 1086","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1087"),"Job 1087","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1088"),"Job 1088","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1089"),"Job 1089","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1090"),"Job 1090","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1091"),"Job 1091","A",jobScheduledTime,Long.valueOf("5"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1092"),"Job 1092","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1093"),"Job 1093","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1094"),"Job 1094","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1095"),"Job 1095","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1096"),"Job 1096","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1097"),"Job 1097","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1098"),"Job 1098","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1099"),"Job 1099","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1100"),"Job 1100","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1101"),"Job 1101","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1102"),"Job 1102","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1103"),"Job 1103","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1104"),"Job 1104","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1105"),"Job 1105","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1106"),"Job 1106","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1107"),"Job 1107","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1108"),"Job 1108","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1109"),"Job 1109","A",jobScheduledTime,Long.valueOf("2"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1110"),"Job 1110","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1111"),"Job 1111","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1112"),"Job 1112","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1113"),"Job 1113","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1114"),"Job 1114","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1115"),"Job 1115","A",jobScheduledTime,Long.valueOf("1"),Long.valueOf("1"),null,null, "Job A" ));
            jobRepository.save(new Job(Long.valueOf("1116"),"Job 1116","B",jobScheduledTime1,Long.valueOf("1"),Long.valueOf("5"),null,null, "Job B" ));
            jobRepository.save(new Job(Long.valueOf("1117"),"Job 1117","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null, "Job C" ));
            jobRepository.save(new Job(Long.valueOf("1118"),"Job 1118","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null,"Job C" ));
            jobRepository.save(new Job(Long.valueOf("1119"),"Job 1119","C",jobScheduledTime2,Long.valueOf("1"),Long.valueOf("3"),null,null,"Job C" ));
            jobRepository.save(new Job(Long.valueOf("1120"),"Job 1120","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1121"),"Job 1121","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1122"),"Job 1122","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1123"),"Job 1123","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1124"),"Job 1124","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1125"),"Job 1125","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1126"),"Job 1126","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1127"),"Job 1127","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1128"),"Job 1128","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1129"),"Job 1129","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1130"),"Job 1130","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1131"),"Job 1131","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1132"),"Job 1132","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1133"),"Job 1133","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1134"),"Job 1134","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1135"),"Job 1135","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1136"),"Job 1136","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1137"),"Job 1137","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1138"),"Job 1138","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1139"),"Job 1139","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1140"),"Job 1140","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1141"),"Job 1141","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1142"),"Job 1142","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1143"),"Job 1143","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1144"),"Job 1144","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1145"),"Job 1145","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1146"),"Job 1146","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1147"),"Job 1147","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null ,"Job D"));
            jobRepository.save(new Job(Long.valueOf("1148"),"Job 1148","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1149"),"Job 1149","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1150"),"Job 1150","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1151"),"Job 1151","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1152"),"Job 1152","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1153"),"Job 1153","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1154"),"Job 1154","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1155"),"Job 1155","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1156"),"Job 1156","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1157"),"Job 1157","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1158"),"Job 1158","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1159"),"Job 1159","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1160"),"Job 1160","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1161"),"Job 1161","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1162"),"Job 1162","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1163"),"Job 1163","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1164"),"Job 1164","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1165"),"Job 1165","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1166"),"Job 1166","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1167"),"Job 1167","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1168"),"Job 1168","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1169"),"Job 1169","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1170"),"Job 1170","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1171"),"Job 1171","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1172"),"Job 1172","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1173"),"Job 1173","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));
            jobRepository.save(new Job(Long.valueOf("1174"),"Job 1174","D",jobScheduledTime3,Long.valueOf("1"),Long.valueOf("2"),null,null,"Job D" ));


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



