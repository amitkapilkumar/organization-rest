package com.builder;

import com.dto.CompanyRequestObject;
import com.dto.EmployeeRequestObject;

import java.util.List;

/**
 * Created by amit on 09/02/16.
 */
public class CompanyRequestObjectBuilder {
    private String id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private List<EmployeeRequestObject> employees;

    public CompanyRequestObjectBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public CompanyRequestObjectBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompanyRequestObjectBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public CompanyRequestObjectBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CompanyRequestObjectBuilder withCountry(String country) {
        this.country = country;
        return this;
    }

    public CompanyRequestObjectBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public CompanyRequestObjectBuilder withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public CompanyRequestObjectBuilder withEmployees(List<EmployeeRequestObject> employees) {
        this.employees = employees;
        return this;
    }

    public CompanyRequestObject build() {
        return new CompanyRequestObject(id, name, address, city, country, email, phone, employees);
    }
}
