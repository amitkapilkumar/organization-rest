package com.repository;

import com.model.Company;
import com.model.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by amit on 09/02/16.
 */
@Component
public class DataProcessorImpl implements DataProcessor {

    @Override
    public List<Company> getCompanyList() {
        List<Company> companies = new ArrayList<Company>(
                Arrays.asList(
                        new Company("QWERTY", "PTC", "70 RCR", "PUNE", "INDIA", "a@ptc.com", "+91673268324", new ArrayList<Employee>()),
                        new Company("YHTY", "Syne Group", "77 UTY", "Delhi", "INDIA", "a@syne.com", "+916735438324", new ArrayList<Employee>())
                )
        );
        return companies;
    }

    @Override
    public Company getCompany(String id) {
        return new Company("QWERTY", "PTC", "70 RCR", "PUNE", "INDIA", "a@ptc.com", "+91673268324", new ArrayList<Employee>());
    }

    @Override
    public Boolean addCompany(Company company) {
        return true;
    }

    @Override
    public Boolean updateCompany(Company company) {
        return true;
    }

    @Override
    public Boolean addOwners(String id, List<String> owners) {
        return true;
    }
}
