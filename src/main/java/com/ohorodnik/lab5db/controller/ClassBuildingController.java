package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.ClassBuilding;
import com.ohorodnik.lab5db.repository.ClassBuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class")
public class ClassBuildingController {
    //@Autowired
    //ClassBuildingServiceImpl organizationService;

    @Autowired
    ClassBuildingRepository classBuildingRepository;

    @RequestMapping("/get")
    public List<ClassBuilding> getClassBuilding()  {
        //return organizationService.getClassBuildings();
        return classBuildingRepository.findAll();
    }

    @PostMapping("/insert")
    public ClassBuilding insertClassBuilding( @RequestBody ClassBuilding classBuilding){
        //return organizationService.insertClassBuilding(organization);
        return classBuildingRepository.save(classBuilding);
    }
    @RequestMapping("/update")
    public ClassBuilding updateClassBuilding(@RequestBody ClassBuilding classBuilding,@RequestParam("id")int id)  {
        classBuilding.setIdClassHotel(id);
        return classBuildingRepository.save(classBuilding);
        //return organizationService.updateClassBuilding(organization);
    }

    @RequestMapping("/del")
    public void deleteClassBuilding(@RequestParam("id")int id)  {
        //organizationService.deleteClassBuilding(id);
        classBuildingRepository.deleteById(id);
    }
}
