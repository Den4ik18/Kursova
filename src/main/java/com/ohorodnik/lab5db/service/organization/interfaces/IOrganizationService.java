package com.ohorodnik.lab5db.service.organization.interfaces;



import com.ohorodnik.lab5db.model.Building;
import com.ohorodnik.lab5db.model.Organization;

import java.sql.SQLException;
import java.util.List;

public interface IOrganizationService {
    /*public Organization insertOrganization(Organization organization);



    public Organization updateOrganization(Organization organization) throws SQLException;

    public void deleteOrganization(int id) throws SQLException;

    public List<Organization> getOrganizations() throws SQLException;

    //Organization getOrganizationBy...(String Organization)throws SQLException;*/

    List<Organization> getAll();

    Organization insert(Organization organization);

    Organization update(Organization organization);

    Organization getById(int id);

    void delete(int id);
}
