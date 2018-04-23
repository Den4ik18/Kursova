package com.ohorodnik.lab5db.service.type.interfaces;


import com.ohorodnik.lab5db.model.TypeOfOrganization;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfOrganizationService {
    public TypeOfOrganization insertTypeOfOrganization(TypeOfOrganization typeOfOrganization);


    public TypeOfOrganization updateTypeOfOrganization(TypeOfOrganization typeOfOrganization) throws SQLException;

    public void deleteTypeOfOrganization(int id) throws SQLException;

    public List<TypeOfOrganization> getTypes() throws SQLException;

    //TypeOfOrganization getTypeOfOrganizationBy...(String typeOfOrganization)throws SQLException;
}
