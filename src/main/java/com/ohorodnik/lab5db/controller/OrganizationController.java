package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Organization;
import com.ohorodnik.lab5db.repository.OrganizationRepository;
import com.ohorodnik.lab5db.service.organization.impls.OrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    OrganizationServiceImpl organizationService;

    @Autowired
    OrganizationRepository organizationRepository;

    @RequestMapping("/get")
    public List<Organization> getOrganization()  {
        //return organizationService.getOrganizations();
        return organizationRepository.findAll();
    }

    @PostMapping("/insert")
    public Organization insertOrganization( @RequestBody Organization organization){
        //return organizationService.insertOrganization(organization);
        return organizationRepository.save(organization);
    }
    @RequestMapping("/update")
    public Organization updateOrganization(@RequestBody Organization organization,@RequestParam("id")int id)  {
        organization.setIdOrganization(id);
        return organizationRepository.save(organization);
        //return organizationService.updateOrganization(organization);
    }

    @RequestMapping("/del")
    public void deleteOrganization(@RequestParam("id")int id)  {
        //organizationService.deleteOrganization(id);
        organizationRepository.deleteById(id);
    }
}
