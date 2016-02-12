package com.dto;

import com.model.Company;
import com.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amit on 08/02/16.
 */
public class CompanyRequestObject {
    private String id;
    private String name;
    private String address;
    private String city;
    private String country;
    private String email;
    private String phone;
    private List<EmployeeRequestObject> employees;

    public CompanyRequestObject() {

    }

    public CompanyRequestObject(String id, String name, String address, String city, String country, String email, String phone, List<EmployeeRequestObject> employees) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.email = email;
        this.phone = phone;
        this.employees = employees;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<EmployeeRequestObject> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeRequestObject> employees) {
        this.employees = employees;
    }

    public Company toCompany() {
        List<Employee> employees = new ArrayList<Employee>();
        for(EmployeeRequestObject employeeRequestObject: this.employees) {
            employees.add(employeeRequestObject.toEmployee());
        }
        return new Company(id, name, address, city, country, email, phone, employees);
    }
}
