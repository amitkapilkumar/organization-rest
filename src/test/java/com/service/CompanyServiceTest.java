package com.service;

import com.builder.CompanyRequestObjectBuilder;
import com.builder.EmployeeRequestObjectBuilder;
import com.builder.OwnerRequestObjectBuilder;
import com.dto.CompanyRequestObject;
import com.dto.EmployeeRequestObject;
import com.dto.OwnerRequestObject;
import com.model.Company;
import com.model.Employee;
import com.repository.CompanyRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.when;

/**
 * Created by amit on 09/02/16.
 */
public class CompanyServiceTest {

    private CompanyService companyService;

    private CompanyRepository mockCompanyRepository;

    @Before
    public void setup() {
        companyService = new CompanyService();
        mockCompanyRepository = Mockito.mock(CompanyRepository.class);
        companyService.companyRepository = mockCompanyRepository;
    }

    @Test
    public void itShouldVerifyRepositoryCallToGetCompanies() {
        List<Company> list = new ArrayList<Company>();
        list.add(new Company("QWE", "Light group", "XYZ", "ABC", "TYU", "a@ptc.com", "7834567289", null));
        list.add(new Company("TYR", "2nd Light group", "THR", "UIU", "IYRE", "b@ptc.com", "78345672456", null));
        when(mockCompanyRepository.getCompanies()).thenReturn(list);

        Assert.assertEquals(list.size(), companyService.getCompanies().size());
    }

    @Test
    public void itShouldVerifyRepositoryCallToAddCompany() {

        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("E233").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyRepository.addCompany(Matchers.any(Company.class))).thenReturn(expectedMap);

        Map<String, String> actualMap = companyService.addCompany(companyRequestObject);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyRepositoryCallToAddOwners() {
        String id = "SDFR";
        List<String> owners = new ArrayList<String>(){{
            add("AK group");
            add("Seyne");
        }};
        OwnerRequestObject ownerRequestObject = new OwnerRequestObjectBuilder().withOwners(owners).build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyRepository.addOwners(id, ownerRequestObject.getOwners())).thenReturn(expectedMap);

        Map<String, String> actualMap = companyService.addOwners(id, ownerRequestObject);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyRepositoryCallToUpdateCompany() {
        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("E233").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyRepository.updateCompany(Matchers.any(Company.class))).thenReturn(expectedMap);

        Map<String, String> actualMap = companyService.updateCompany(companyRequestObject);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyRepositoryCallToGetCompany() {
        String id = "UYRT";

        Company expectedCompany = new Company("QWERTY", "PTC", "70 RCR", "PUNE", "INDIA", "a@ptc.com", "+91673268324", new ArrayList<Employee>());
        when(mockCompanyRepository.getCompany(id)).thenReturn(expectedCompany);

        Company actualCompany = mockCompanyRepository.getCompany(id);

        Assert.assertEquals(expectedCompany.getId(), actualCompany.getId());
    }

    private Map<String, String> constructSuccessResponse() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "success");
        return map;
    }
}