package com.service;

import com.dto.CompanyRequestObject;
import com.dto.OwnerRequestObject;
import com.model.Company;
import com.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by amit on 08/02/16.
 */
@Service
public class CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    public List<Company> getCompanies() {
        return companyRepository.getCompanies();
    }

    public Map<String, String> addCompany(CompanyRequestObject companyRequestObject) {
        return companyRepository.addCompany(companyRequestObject.toCompany());
    }

    public Map<String, String> addOwners(String id, OwnerRequestObject  ownerRequestObject) {
        return companyRepository.addOwners(id, ownerRequestObject.getOwners());
    }

    public Map<String, String> updateCompany(CompanyRequestObject companyRequestObject) {
        return companyRepository.updateCompany(companyRequestObject.toCompany());
    }

    public Company getCompany(String id) {
        return companyRepository.getCompany(id);
    }
}
