package com.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 11/02/16.
 */
public class ClientControllerTest {
    private ClientController clientController;

    @Before
    public void setup() {
        clientController = new ClientController();
    }

    @Test
    public void itShouldReturnClient() {
        Assert.assertEquals(clientController.index(), "client");
    }

    @Test
    public void itShouldReturnGetCompany() {
        Assert.assertEquals(clientController.company(), "getCompany");
    }

    @Test
    public void itShouldReturnGetAllCompany() {
        Assert.assertEquals(clientController.list(), "getAllCompany");
    }

    @Test
    public void itShouldReturnAddCompany() {
        Assert.assertEquals(clientController.add(), "addCompany");
    }

    @Test
    public void itShouldReturnUpdateCompany() {
        Assert.assertEquals(clientController.update(), "updateCompany");
    }

    @Test
    public void itShouldReturnAddOwners() {
        Assert.assertEquals(clientController.addOwners(), "addOwners");
    }
}