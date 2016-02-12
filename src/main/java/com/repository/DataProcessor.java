package com.repository;

import com.model.Company;

import java.util.List;

/**
 * Created by amit on 09/02/16.
 */

public interface DataProcessor {

    public List<Company> getCompanyList();

    public Company getCompany(String id);

    public Boolean addCompany(Company company);

    public Boolean updateCompany(Company company);

    public Boolean addOwners(String id, List<String> owners);
}
