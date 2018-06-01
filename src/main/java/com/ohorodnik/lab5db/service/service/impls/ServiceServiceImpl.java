package com.ohorodnik.lab5db.service.service.impls;



import com.ohorodnik.lab5db.model.Service;
import com.ohorodnik.lab5db.repository.ServiceRepository;
import com.ohorodnik.lab5db.service.service.interfaces.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    //@Autowired
    //ServiceDAOFakeImpl serviceDAOFake;
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<Service> getAll() {
        return (List<Service>)serviceRepository.findAll();
    }

    @Override
    public Service insert(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service update(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public Service getById(int id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void delete(int id) {
        serviceRepository.deleteById(id);
    }

    /*@Override
    public Service insertService(Service service) {
        //return serviceDAOFake.insertService(service);
        return serviceRepository.save(service);
    }


    @Override
    public Service updateService(Service service) throws SQLException {
        //return serviceDAOFake.updateService(service);
        return serviceRepository.save(service);
    }

    @Override
    public void deleteService(int id) throws SQLException {
        //return serviceDAOFake.deleteService(id);
        serviceRepository.deleteById(id);
    }

    @Override
    public List<Service> getServices() throws SQLException {
        //return serviceDAOFake.getAll().stream().collect(Collectors.toList());
        return serviceRepository.findAll();
    }*/
}
