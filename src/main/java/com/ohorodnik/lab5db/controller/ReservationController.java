package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Reservation;
import com.ohorodnik.lab5db.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    //@Autowired
    //ReservationServiceImpl organizationService;

    @Autowired
    ReservationRepository reservationRepository;

    @RequestMapping("/get")
    public List<Reservation> getReservation()  {
        //return organizationService.getReservations();
        return reservationRepository.findAll();
    }

    @PostMapping("/insert")
    public Reservation insertReservation(@RequestBody Reservation reservation){
        //return organizationService.insertReservation(organization);
        return reservationRepository.save(reservation);
    }
    @RequestMapping("/update")
    public Reservation updateReservation(@RequestBody Reservation reservation,@RequestParam("id")int id)  {
        reservation.setIdReservation(id);
        return reservationRepository.save(reservation);
        //return organizationService.updateReservation(organization);
    }

    @RequestMapping("/del")
    public void deleteReservation(@RequestParam("id")int id)  {
        //organizationService.deleteReservation(id);
        reservationRepository.deleteById(id);
    }
}
