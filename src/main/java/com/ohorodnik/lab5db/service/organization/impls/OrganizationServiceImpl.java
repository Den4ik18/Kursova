package com.ohorodnik.lab5db.service.organization.impls;



import com.ohorodnik.lab5db.model.Organization;
import com.ohorodnik.lab5db.repository.OrganizationRepository;
import com.ohorodnik.lab5db.service.organization.interfaces.IOrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganizationServiceImpl implements IOrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;
    @Override
    public List<Organization> getAll() {
        return (List<Organization>) organizationRepository.findAll();
    }

    @Override
    public Organization insert(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization update(Organization organization) {
        return organizationRepository.save(organization);
    }

    @Override
    public Organization getById(int id) {
        return organizationRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        organizationRepository.deleteById(id);
    }
    //@Autowired
    //OrganizationDAOFakeImpl organizationDAOFake;
    /*OrganizationRepository organizationRepository;

    @Override
    public Organization insertOrganization(Organization organization) {
        //return organizationDAOFake.insertOrganization(organization);
        return organizationRepository.save(organization);
    }

    @Override
    public Organization updateOrganization(Organization organization) throws SQLException {
        //return organizationDAOFake.updateOrganization(organization);
        return organizationRepository.save(organization);
    }

    @Override
    public void deleteOrganization(int id) throws SQLException {
        //return organizationDAOFake.deleteOrganization(id);
        organizationRepository.deleteById(id);
    }

    @Override
    public List<Organization> getOrganizations()  {
        //return organizationDAOFake.getAll().stream().collect(Collectors.toList());
        return organizationRepository.findAll();
    }*/
}
