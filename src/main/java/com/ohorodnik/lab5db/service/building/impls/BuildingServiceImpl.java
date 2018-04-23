package com.ohorodnik.lab5db.service.building.impls;



import com.ohorodnik.lab5db.model.Building;
import com.ohorodnik.lab5db.repository.BuildingRepository;
import com.ohorodnik.lab5db.service.building.interfaces.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingServiceImpl implements IBuildingService {
    //@Autowired
    //BuildingDAOFakeImpl buildingDAO;
    @Autowired
    BuildingRepository buildingRepository;

    @Override
    public Building insertBuilding(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building updateBuilding(Building building) throws SQLException {
        return buildingRepository.save(building);
    }

    @Override
    public void deleteBuilding(int id) throws SQLException {
         buildingRepository.deleteById(id);
    }

    @Override
    public List<Building> getBuildings() throws SQLException {
        return buildingRepository.findAll();
    }

    /*@Override
    public Building getBuildingByAddress(String building) throws SQLException {
        List<Building> all = buildingDAO.getAll();
        return all.stream()
                .filter(x -> x.getAddressOfhBuilding().equals(building))
                .findFirst()
                .get();
    }*/
}
