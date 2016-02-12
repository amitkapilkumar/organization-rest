package com.controller;

import com.builder.CompanyRequestObjectBuilder;
import com.builder.OwnerRequestObjectBuilder;
import com.dto.CompanyRequestObject;
import com.dto.OwnerRequestObject;
import com.model.Company;
import com.model.Employee;
import com.service.CompanyService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Mockito.when;

/**
 * Created by amit on 09/02/16.
 */

public class CompanyControllerTest {

    private CompanyController companyController;

    private CompanyService mockCompanyService;

    @Before
    public void setup() {
        companyController = new CompanyController();
        mockCompanyService = Mockito.mock(CompanyService.class);
        companyController.companyService = mockCompanyService;
    }

    @Test
    public void itShouldVerifyServiceCallToGetCompanies() {
        List<Company> list = new ArrayList<Company>();
        list.add(new Company("QWE", "Light group", "XYZ", "ABC", "TYU", "a@ptc.com", "7834567289", null));
        list.add(new Company("TYR", "2nd Light group", "THR", "UIU", "IYRE", "b@ptc.com", "78345672456", null));
        when(mockCompanyService.getCompanies()).thenReturn(list);

        List<Company> actualList = companyController.getAllCompany();

        Assert.assertEquals(list.size(), actualList.size());
    }

    @Test
    public void itShouldVerifyServiceCallToAddCompany() {

        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                                                        .withId("QWER")
                                                        .withName("Light Group")
                                                        .build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyService.addCompany(companyRequestObject)).thenReturn(expectedMap);

        Map<String, String> actualMap = companyController.addCompany(companyRequestObject);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyServiceCallToAddOwners() {
        String id = "SDFR";
        List<String> owners = new ArrayList<String>(){{
                add("AK group");
                add("Seyne");
        }};
        OwnerRequestObject ownerRequestObject = new OwnerRequestObjectBuilder().withOwners(owners).build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyService.addOwners(id, ownerRequestObject)).thenReturn(expectedMap);

        Map<String, String> actualMap = companyController.addOwners(ownerRequestObject, id);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyServiceCallToUpdateCompany() {
        CompanyRequestObject companyRequestObject = new CompanyRequestObjectBuilder()
                .withId("QWER")
                .withName("Light Group")
                .build();

        Map<String, String> expectedMap = constructSuccessResponse();
        when(mockCompanyService.updateCompany(companyRequestObject)).thenReturn(expectedMap);

        Map<String, String> actualMap = companyController.updateCompany(companyRequestObject);

        Assert.assertEquals(actualMap.size(), expectedMap.size());
        Assert.assertEquals(actualMap.get("status"), expectedMap.get("status"));
    }

    @Test
    public void itShouldVerifyServiceCallToGetCompany() {
        String id = "UYRT";

        Company expectedCompany = new Company("QWERTY", "PTC", "70 RCR", "PUNE", "INDIA", "a@ptc.com", "+91673268324", new ArrayList<Employee>());
        when(mockCompanyService.getCompany(id)).thenReturn(expectedCompany);

        Company actualCompany = companyController.getCompany(id);

        Assert.assertEquals(expectedCompany.getId(), actualCompany.getId());
    }

    private Map<String, String> constructSuccessResponse() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("status", "success");
        return map;
    }

}