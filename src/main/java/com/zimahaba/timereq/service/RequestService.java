package com.zimahaba.timereq.service;

import com.zimahaba.timereq.entity.*;
import com.zimahaba.timereq.repository.CompanyRepository;
import com.zimahaba.timereq.repository.RequestRepository;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private SituationService situationService;

    public List<Request> findAll() {
        return requestRepository.findAll();
    }

    public Request findById(Long id) {
        return requestRepository.findById(id).get();
    }

    public Request save(Request request) {

        Optional<Project> project = projectService.findById(1L);
        Optional<Situation> situation = situationService.findById(1L);

        Period period = new Period();
        period.setDate(LocalDate.now());
        period.setStartTime(LocalTime.now());
        period.setEndTime(LocalTime.now());

        request.setStartDate(LocalDate.now());
        request.setEndDate(LocalDate.now());
        request.setProject(project.get());
        request.setSituation(situation.get());
        request.addPeriod(period);

        /*Request request = Request.builder().number("1").description("description").observation("obs")
                .startDate(LocalDate.now()).endDate(LocalDate.now())
                .project(project.get()).situation(situation.get()).build();*/
        //request.addPeriod(period);

        /*Request request2 = Request.builder().number("2").description("description").observation("obs")
                .startDate(LocalDate.now()).endDate(LocalDate.now())
                .project(project.get()).situation(situation.get()).build();
        request.addPeriod(period);*/

        return requestRepository.saveAndFlush(request);
    }
}
