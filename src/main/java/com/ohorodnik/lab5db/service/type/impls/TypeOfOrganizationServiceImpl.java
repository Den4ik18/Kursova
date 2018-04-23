package com.ohorodnik.lab5db.service.type.impls;




import com.ohorodnik.lab5db.model.TypeOfOrganization;
import com.ohorodnik.lab5db.repository.TypeOfOrganizationRepository;
import com.ohorodnik.lab5db.service.type.interfaces.ITypeOfOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TypeOfOrganizationServiceImpl implements ITypeOfOrganizationService {
    
    //@Autowired
    //TypeOfOrganizationDAOFakeImpl typeOfOrganizationDAOFake;

    @Autowired
    TypeOfOrganizationRepository typeOfOrganizationRepository;

    @Override
    public TypeOfOrganization insertTypeOfOrganization(TypeOfOrganization typeOfOrganization) {
        //return typeOfOrganizationDAOFake.insertTypeOfOrganization(typeOfOrganization);
        return typeOfOrganizationRepository.save(typeOfOrganization);
    }



    @Override
    public TypeOfOrganization updateTypeOfOrganization(TypeOfOrganization typeOfOrganization) throws SQLException {
        //return typeOfOrganizationDAOFake.updateTypeOfOrganization(typeOfOrganization);
        return typeOfOrganizationRepository.save(typeOfOrganization);
    }

    @Override
    public void deleteTypeOfOrganization(int id) throws SQLException {
        //return typeOfOrganizationDAOFake.deleteTypeOfOrganization(id);
        typeOfOrganizationRepository.deleteById(id);
    }

    @Override
    public List<TypeOfOrganization> getTypes() throws SQLException {
        //return typeOfOrganizationDAOFake.getAll().stream().collect(Collectors.toList());
         return typeOfOrganizationRepository.findAll();
    }
}
