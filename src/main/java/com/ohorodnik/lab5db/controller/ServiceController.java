package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Service;
import com.ohorodnik.lab5db.repository.ServiceRepository;
import com.ohorodnik.lab5db.service.service.impls.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceController {
    //@Autowired
    //ServiceServiceImpl serviceService;

    @Autowired
    ServiceRepository serviceRepository;

    @RequestMapping("/get")
    public List<Service> getService()  {
        //return serviceService.getServices();
        return serviceRepository.findAll();
    }

    @PostMapping("/insert")
    public Service insertService( @RequestBody Service service){
        //return serviceService.insertService(service);
        return serviceRepository.save(service);
    }
    @RequestMapping("/update")
    public Service updateService(@RequestBody Service service,@RequestParam("id")int id)  {
        service.setIdService(id);
        return serviceRepository.save(service);
        //return serviceService.updateService(service);
    }

    @RequestMapping("/del")
    public void deleteService(@RequestParam("id")int id)  {
        //serviceService.deleteService(id);
        serviceRepository.deleteById(id);
    }
}
