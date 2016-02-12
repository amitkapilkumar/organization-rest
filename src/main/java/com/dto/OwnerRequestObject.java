package com.dto;

import java.util.List;

/**
 * Created by amit on 08/02/16.
 */
public class OwnerRequestObject {
    private List<String> owners;

    public OwnerRequestObject() {

    }

    public OwnerRequestObject(List<String> owners) {
        this.owners = owners;
    }

    public List<String> getOwners() {
        return owners;
    }

    public void setOwners(List<String> owners) {
        this.owners = owners;
    }
}
