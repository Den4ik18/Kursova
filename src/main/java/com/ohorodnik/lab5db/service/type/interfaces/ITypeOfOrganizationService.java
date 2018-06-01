package com.ohorodnik.lab5db.service.type.interfaces;


import com.ohorodnik.lab5db.model.Service;
import com.ohorodnik.lab5db.model.TypeOfOrganization;

import java.sql.SQLException;
import java.util.List;

public interface ITypeOfOrganizationService {
   /* public TypeOfOrganization insertTypeOfOrganization(TypeOfOrganization typeOfOrganization);


    public TypeOfOrganization updateTypeOfOrganization(TypeOfOrganization typeOfOrganization) throws SQLException;

    public void deleteTypeOfOrganization(int id) throws SQLException;

    public List<TypeOfOrganization> getTypes() throws SQLException;
*/
   List<TypeOfOrganization> getAll();

    TypeOfOrganization insert(TypeOfOrganization typeOfOrganization);

    TypeOfOrganization update(TypeOfOrganization typeOfOrganization);

    TypeOfOrganization getById(int id);

    void delete(int id);

    //TypeOfOrganization getTypeOfOrganizationBy...(String typeOfOrganization)throws SQLException;
}
