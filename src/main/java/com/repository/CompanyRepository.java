package com.repository;

import com.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amit on 08/02/16.
 */
@Repository
public class CompanyRepository {

    @Autowired
    DataProcessor dataProcessor;

    public List<Company> getCompanies() {
        return dataProcessor.getCompanyList();
    }

    public Map<String, String> addCompany(Company company) {
        if(dataProcessor.addCompany(company)) {
            return getSuccessResponse();
        }
        return getUnSuccessResponse();
    }

    public Map<String, String> updateCompany(Company company) {
        if(dataProcessor.updateCompany(company)) {
            return getSuccessResponse();
        }
        return getUnSuccessResponse();
    }

    public Map<String, String> addOwners(String id, List<String> owners) {
        if(dataProcessor.addOwners(id, owners)) {
            return getSuccessResponse();
        }
        return getUnSuccessResponse();
    }

    public Company getCompany(String id) {
        return dataProcessor.getCompany(id);
    }

    private Map<String, String> getSuccessResponse() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "success");
        return map;
    }

    private Map<String, String> getUnSuccessResponse() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "failure");
        return map;
    }
}
