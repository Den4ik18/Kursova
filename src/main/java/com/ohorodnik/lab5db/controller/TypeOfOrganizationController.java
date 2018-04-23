package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.TypeOfOrganization;
import com.ohorodnik.lab5db.repository.TypeOfOrganizationRepository;
import com.ohorodnik.lab5db.service.type.impls.TypeOfOrganizationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/typeOfOrganization")
public class TypeOfOrganizationController {
    @Autowired
    TypeOfOrganizationServiceImpl typeOfOrganizationService;

    @Autowired
    TypeOfOrganizationRepository typeOfOrganizationRepository;

    @RequestMapping("/get")
    public List<TypeOfOrganization> getTypeOfOrganization()  {
        //return typeOfOrganizationService.getTypeOfOrganizations();
        return typeOfOrganizationRepository.findAll();
    }

    @PostMapping("/insert")
    public TypeOfOrganization insertTypeOfOrganization( @RequestBody TypeOfOrganization typeOfOrganization){
        //return typeOfOrganizationService.insertTypeOfOrganization(typeOfOrganization);
        return typeOfOrganizationRepository.save(typeOfOrganization);
    }
    @RequestMapping("/update")
    public TypeOfOrganization updateTypeOfOrganization(@RequestBody TypeOfOrganization typeOfOrganization,@RequestParam("id")int id)  {
        typeOfOrganization.setIdTypeOfOrganization(id);
        return typeOfOrganizationRepository.save(typeOfOrganization);
        //return typeOfOrganizationService.updateTypeOfOrganization(typeOfOrganization);
    }

    @RequestMapping("/del")
    public void deleteTypeOfOrganization(@RequestParam("id")int id)  {
        //typeOfOrganizationService.deleteTypeOfOrganization(id);
        typeOfOrganizationRepository.deleteById(id);
    }
}
