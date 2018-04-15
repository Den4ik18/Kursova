package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.*;
import com.ohorodnik.lab5db.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class GeneralController {

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    ClassBuildingRepository classBuildingRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    ReservationOrganizationRepository reservationOrganizationRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    TypeOfOrganizationRepository typeOfOrganizationRepository;

    @RequestMapping("/building")
    public List<Building> getBuilding(){ return buildingRepository.findAll(); }

    @RequestMapping("/class")
    public List<ClassBuilding> getClassBuilding(){ return classBuildingRepository.findAll(); }

    @RequestMapping("/customer")
    public List<Customer> getCustomer(){ return customerRepository.findAll(); }

    @RequestMapping("/organization")
    public List<Organization> getOrganization(){ return organizationRepository.findAll(); }

    @RequestMapping("/reservationOrganization")
    public List<ReservationOrganization> getReservationByOrganization(){ return reservationOrganizationRepository.findAll(); }

    @RequestMapping("/reservation")
    public List<Reservation> getReservation(){ return reservationRepository.findAll(); }

    @RequestMapping("/room")
    public List<Room> getRoom(){ return roomRepository.findAll(); }

    @RequestMapping("/service")
    public List<Service> getService(){ return serviceRepository.findAll(); }

    @RequestMapping("/type")
    public List<TypeOfOrganization> getTypeOfOrganization(){ return typeOfOrganizationRepository.findAll(); }

    /*@RequestMapping("/pidor")
    public String getPidor(){
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        buildingRepository.save(new Building(13,34,23,5,"pidor","vitlik"));
        return "Pidor";
    }
*/
}
