package com.dto;

import com.model.Employee;

/**
 * Created by amit on 08/02/16.
 */
public class EmployeeRequestObject {
    private String id;
    private String firstName;
    private String lastName;

    public EmployeeRequestObject() {

    }

    public EmployeeRequestObject(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName  = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Employee toEmployee() {
        return new Employee(id, firstName, lastName);
    }
}
