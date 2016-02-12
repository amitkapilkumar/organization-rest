package com.builder;

import com.dto.OwnerRequestObject;

import java.util.List;

/**
 * Created by amit on 09/02/16.
 */
public class OwnerRequestObjectBuilder {
    private List<String> owners;

    public OwnerRequestObjectBuilder withOwners(List<String> owners) {
        this.owners = owners;
        return this;
    }

    public OwnerRequestObject build() {
        return new OwnerRequestObject(owners);
    }
}
