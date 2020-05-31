package com.zimahaba.timereq.service;

import com.zimahaba.timereq.entity.Project;
import com.zimahaba.timereq.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }
}
