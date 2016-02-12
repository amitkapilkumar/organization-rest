package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by amit on 11/02/16.
 */
@Controller
public class ClientController {
    @RequestMapping("/client")
    public String index() {
        return "client";
    }

    @RequestMapping("/getAllCompany")
    public String list() {
        return "getAllCompany";
    }

    @RequestMapping("/getCompany")
    public String company() {
        return "getCompany";
    }

    @RequestMapping("/updateCompany")
    public String update() {
        return "updateCompany";
    }

    @RequestMapping("/addCompany")
    public String add() {
        return "addCompany";
    }

    @RequestMapping("/addOwners")
    public String addOwners() {
        return "addOwners";
    }
}
