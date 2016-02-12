package com.controller;

import com.dto.CompanyRequestObject;
import com.dto.OwnerRequestObject;
import com.model.Company;
import com.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class CompanyController {
	@Autowired
	CompanyService companyService;

	@RequestMapping(value = "/company/list", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Company> getAllCompany() {
		return companyService.getCompanies();
	}

	@RequestMapping(value = "/company", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Map<String, String> addCompany(@RequestBody CompanyRequestObject cro) {
		return companyService.addCompany(cro);
	}

	@RequestMapping(value = "/company/{id}/owners", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Map<String, String> addOwners(@RequestBody OwnerRequestObject oro, @PathVariable String id) {
		return companyService.addOwners(id, oro);
	}

	@RequestMapping(value = "/company", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public Map<String, String> updateCompany(@RequestBody CompanyRequestObject cro) {
		return companyService.updateCompany(cro);
	}

	@RequestMapping(value = "/company/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Company getCompany(@PathVariable String id) {
		return companyService.getCompany(id);
	}
}