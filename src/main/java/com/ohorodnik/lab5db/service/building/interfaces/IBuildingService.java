package com.ohorodnik.lab5db.service.building.interfaces;


import com.ohorodnik.lab5db.model.Building;

import java.sql.SQLException;
import java.util.List;

public interface IBuildingService {
    public Building insertBuilding(Building building);


    public Building updateBuilding(Building building) throws SQLException;

    public void deleteBuilding(int id) throws SQLException;

    public List<Building> getBuildings() throws SQLException;

    //Building getBuildingByAddress(String building)throws SQLException;
}
