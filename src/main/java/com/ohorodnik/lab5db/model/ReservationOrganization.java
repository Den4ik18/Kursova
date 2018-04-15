package com.ohorodnik.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "reservation_by_organization")
@EntityListeners(AuditingEntityListener.class)
public class ReservationOrganization {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_reservation_room")
    private int idReservationOrganization;

    @Column(name = "floor")
    private int floor;

    @Column(name = "count_of_reservation_rooms")
    private int countOfReservationRooms;

    @Column(name = "total_count_of_people")
    private int totalCountOfPeople;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "class")
    private ClassBuilding classBuilding;

    @Column(name = "list_of_reservation_rooms")
    private String listOfReservationRooms;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "data_of_settlement")
    private LocalDate dataOfSettlement;

    @Column(name = "data_of_eviction")
    private LocalDate dataOfEviction;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "building")
    private Building building;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "organization")
    private Organization organization;

    public ReservationOrganization(int floor, int countOfReservationRooms, int totalCountOfPeople, ClassBuilding classBuilding, String listOfReservationRooms, LocalDate bookingDate, LocalDate dataOfSettlement, LocalDate dataOfEviction, Building building, Organization organization) {
        this.floor = floor;
        this.countOfReservationRooms = countOfReservationRooms;
        this.totalCountOfPeople = totalCountOfPeople;
        this.classBuilding = classBuilding;
        this.listOfReservationRooms = listOfReservationRooms;
        this.bookingDate = bookingDate;
        this.dataOfSettlement = dataOfSettlement;
        this.dataOfEviction = dataOfEviction;
        this.building = building;
        this.organization = organization;
    }

    public ReservationOrganization() {
    }

    public int getIdReservationOrganization() {
        return idReservationOrganization;
    }

    public void setIdReservationOrganization(int idReservationOrganization) {
        this.idReservationOrganization = idReservationOrganization;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCountOfReservationRooms() {
        return countOfReservationRooms;
    }

    public void setCountOfReservationRooms(int countOfReservationRooms) {
        this.countOfReservationRooms = countOfReservationRooms;
    }

    public int getTotalCountOfPeople() {
        return totalCountOfPeople;
    }

    public void setTotalCountOfPeople(int totalCountOfPeople) {
        this.totalCountOfPeople = totalCountOfPeople;
    }

    public ClassBuilding getClassBuilding() {
        return classBuilding;
    }

    public void setClassBuilding(ClassBuilding classBuilding) {
        this.classBuilding = classBuilding;
    }

    public String getListOfReservationRooms() {
        return listOfReservationRooms;
    }

    public void setListOfReservationRooms(String listOfReservationRooms) {
        this.listOfReservationRooms = listOfReservationRooms;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getDataOfSettlement() {
        return dataOfSettlement;
    }

    public void setDataOfSettlement(LocalDate dataOfSettlement) {
        this.dataOfSettlement = dataOfSettlement;
    }

    public LocalDate getDataOfEviction() {
        return dataOfEviction;
    }

    public void setDataOfEviction(LocalDate dataOfEviction) {
        this.dataOfEviction = dataOfEviction;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
