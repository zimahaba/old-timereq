package com.zimahaba.timereq.service;

import com.zimahaba.timereq.entity.Company;
import com.zimahaba.timereq.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }
}
