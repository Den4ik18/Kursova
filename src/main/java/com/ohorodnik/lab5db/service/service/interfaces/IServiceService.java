package com.ohorodnik.lab5db.service.service.interfaces;



import com.ohorodnik.lab5db.model.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceService {
    public Service insertService(Service service);

    public Service updateService(Service service) throws SQLException;

    public void deleteService(int id) throws SQLException;

    public List<Service> getServices() throws SQLException;

    //Service getServiceBy...(String Service)throws SQLException;
}
