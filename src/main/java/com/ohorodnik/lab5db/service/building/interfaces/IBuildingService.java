package com.ohorodnik.lab5db.service.building.interfaces;


import com.ohorodnik.lab5db.model.Building;

import java.sql.SQLException;
import java.util.List;

public interface IBuildingService {
    /*public Building insertBuilding(Building building);
   
    
    
    Building getById(int id);
    
    public Building updateBuilding(Building building) throws SQLException;

    public void deleteBuilding(int id) throws SQLException;

    public List<Building> getBuildings() throws SQLException;

    //Building getBuildingByAddress(String building)throws SQLException;*/
    List<Building> getAll();

    Building insert(Building building);

    Building update(Building building);

    Building getById(int id);

    void delete(int id);
}
