package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Building;
import com.ohorodnik.lab5db.repository.BuildingRepository;
import com.ohorodnik.lab5db.service.building.impls.BuildingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    BuildingServiceImpl buildingService;

    @Autowired
    BuildingRepository buildingRepository;

    @RequestMapping("/get")
    public List<Building> getBuilding()  {
        //return buildingService.getBuildings();
        return buildingRepository.findAll();
    }

    @PostMapping("/insert")
    public Building insertBuilding( @RequestBody Building building){
        //return buildingService.insertBuilding(building);
        return buildingRepository.save(building);
    }
    @RequestMapping("/update")
    public Building updateBuilding(@RequestBody Building building,@RequestParam("id")int id)  {
        building.setIdBuilding(id);
        return buildingRepository.save(building);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/del")
    public void deleteBuilding(@RequestParam("id")int id)  {
        //buildingService.deleteBuilding(id);
        buildingRepository.deleteById(id);
    }

}
