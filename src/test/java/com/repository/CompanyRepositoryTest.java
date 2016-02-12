package com.repository;

import com.builder.CompanyRequestObjectBuilder;
import com.builder.EmployeeRequestObjectBuilder;
import com.builder.OwnerRequestObjectBuilder;
import com.dto.CompanyRequestObject;
import com.dto.EmployeeRequestObject;
import com.dto.OwnerRequestObject;
import com.model.Company;
import com.model.Employee;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by amit on 10/02/16.
 */
public class CompanyRepositoryTest {
    private CompanyRepository companyRepository;
    private DataProcessor mockDataProcessor;

    @Before
    public void setup() {
        companyRepository = new CompanyRepository();
        mockDataProcessor = Mockito.mock(DataProcessorImpl.class);
        companyRepository.dataProcessor = mockDataProcessor;
    }

    @Test
    public void itShouldGetCompanyList() {
        List<Company> list = new ArrayList<Company>();
        list.add(new Company("QWE", "Light group", "XYZ", "ABC", "TYU", "a@ptc.com", "7834567289", null));
        list.add(new Company("TYR", "2nd Light group", "THR", "UIU", "IYRE", "b@ptc.com", "78345672456", null));
        when(mockDataProcessor.getCompanyList()).thenReturn(list);
        Assert.assertEquals(list.size(), companyRepository.getCompanies().size());
    }

    @Test
    public void itShouldGetCompany() {
        String id = "UYRT";
        Company expectedCompany = new Company("QWERTY", "PTC", "70 RCR", "PUNE", "INDIA", "a@ptc.com", "+91673268324", new ArrayList<Employee>());
        when(mockDataProcessor.getCompany(id)).thenReturn(expectedCompany);
        Company actualCompany = mockDataProcessor.getCompany(id);
        Assert.assertEquals(expectedCompany.getId(), actualCompany.getId());
    }

    @Test
    public void itShouldAddCompanyAsSuccess() {
        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("E233").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        when(mockDataProcessor.addCompany(Matchers.any(Company.class))).thenReturn(true);

        Map<String, String> actualMap = companyRepository.addCompany(companyRequestObject.toCompany());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "success");
    }

    @Test
    public void itShouldAddCompanyAsFailure() {
        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("IYTE").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        when(mockDataProcessor.addCompany(Matchers.any(Company.class))).thenReturn(false);

        Map<String, String> actualMap = companyRepository.addCompany(companyRequestObject.toCompany());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "failure");
    }

    @Test
    public void itShouldUpdateCompanyAsSuccess() {
        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("E233").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        when(mockDataProcessor.updateCompany(Matchers.any(Company.class))).thenReturn(true);

        Map<String, String> actualMap = companyRepository.updateCompany(companyRequestObject.toCompany());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "success");
    }

    @Test
    public void itShouldUpdateCompanyAsFailure() {
        EmployeeRequestObject employeeRequestObject = new EmployeeRequestObjectBuilder().withId("E233").withFirstName("Alex").withLastName("Ward").build();
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .withEmployees(new ArrayList<EmployeeRequestObject>(Arrays.asList(employeeRequestObject)))
                .build();

        when(mockDataProcessor.updateCompany(Matchers.any(Company.class))).thenReturn(false);

        Map<String, String> actualMap = companyRepository.updateCompany(companyRequestObject.toCompany());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "failure");
    }

    @Test
    public void itShouldAddOwnersAsSuccess() {
        String id = "SDFR";
        List<String> owners = new ArrayList<String>(){{
            add("AK group");
            add("Seyne");
        }};
        OwnerRequestObject ownerRequestObject = new OwnerRequestObjectBuilder().withOwners(owners).build();

        when(mockDataProcessor.addOwners(id, ownerRequestObject.getOwners())).thenReturn(true);

        Map<String, String> actualMap = companyRepository.addOwners(id, ownerRequestObject.getOwners());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "success");
    }

    @Test
    public void itShouldAddOwnersAsFailure() {
        String id = "SDFR";
        List<String> owners = new ArrayList<String>(){{
            add("AK group");
            add("Seyne");
        }};
        OwnerRequestObject ownerRequestObject = new OwnerRequestObjectBuilder().withOwners(owners).build();

        when(mockDataProcessor.addOwners(id, ownerRequestObject.getOwners())).thenReturn(false);

        Map<String, String> actualMap = companyRepository.addOwners(id, ownerRequestObject.getOwners());

        Assert.assertEquals(actualMap.size(), 1);
        Assert.assertEquals(actualMap.get("status"), "failure");
    }
}