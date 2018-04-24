package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.ReservationOrganization;

import com.ohorodnik.lab5db.repository.ReservationOrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservationByOrganization")
public class ReservationOrganizationController {
    //@Autowired
    //ReservationOrganizationServiceImpl organizationService;

    @Autowired
    ReservationOrganizationRepository reservationOrganizationRepository;

    @RequestMapping("/get")
    public List<ReservationOrganization> getReservationOrganization()  {
        //return organizationService.getReservationOrganizations();
        return reservationOrganizationRepository.findAll();
    }

    @PostMapping("/insert")
    public ReservationOrganization insertReservationOrganization(@RequestBody ReservationOrganization reservationOrganization){
        //return organizationService.insertReservationOrganization(organization);
        return reservationOrganizationRepository.save(reservationOrganization);
    }
    @RequestMapping("/update")
    public ReservationOrganization updateReservationOrganization(@RequestBody ReservationOrganization reservationOrganization,@RequestParam("id")int id)  {
        reservationOrganization.setIdReservationOrganization(id);
        return reservationOrganizationRepository.save(reservationOrganization);
        //return organizationService.updateReservationOrganization(organization);
    }

    @RequestMapping("/del")
    public void deleteReservationOrganization(@RequestParam("id")int id)  {
        //organizationService.deleteReservationOrganization(id);
        reservationOrganizationRepository.deleteById(id);
    }
}
