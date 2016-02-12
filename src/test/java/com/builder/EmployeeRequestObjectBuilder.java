package com.builder;

import com.dto.EmployeeRequestObject;

/**
 * Created by amit on 09/02/16.
 */
public class EmployeeRequestObjectBuilder {
    private String id;
    private String firstName;
    private String lastName;

    public EmployeeRequestObjectBuilder withId(String id) {
        this.id = id;
        return this;
    }

    public EmployeeRequestObjectBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public EmployeeRequestObjectBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public EmployeeRequestObject build() {
        return new EmployeeRequestObject(id, firstName, lastName);
    }
}
