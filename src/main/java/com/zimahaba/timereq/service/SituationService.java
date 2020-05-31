package com.zimahaba.timereq.service;

import com.zimahaba.timereq.entity.Situation;
import com.zimahaba.timereq.repository.SituationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SituationService {

    @Autowired
    private SituationRepository situationRepository;

    public Optional<Situation> findById(Long id) {
        return situationRepository.findById(id);
    }
}
