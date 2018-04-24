package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@EntityListeners(AuditingEntityListener.class)
public class Reservation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_reservation")
    private int idReservation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "number_of_room",insertable = false,updatable = false)
    private Room room;

    @Column(name = "number_of_room")
    private int room_id;

    @Column(name = "booking_date")
    private LocalDate bookingData;

    @Column(name = "data_of_settlement")
    private LocalDate dataOfSettlement;

    @Column(name = "data_of_eviction")
    private LocalDate dataOfEviction;

    //@JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer",insertable = false, updatable = false)
    private Customer customer;

    @Column(name = "customer")
    private int customer_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building",insertable = false,updatable = false)
    private Building building;

    @Column(name = "building")
    private int building_id;

    public Reservation(Room room, int room_id, LocalDate bookingData, LocalDate dataOfSettlement, LocalDate dataOfEviction, Customer customer, int customer_id, Building building, int building_id) {
        this.room = room;
        this.room_id = room_id;
        this.bookingData = bookingData;
        this.dataOfSettlement = dataOfSettlement;
        this.dataOfEviction = dataOfEviction;
        this.customer = customer;
        this.customer_id = customer_id;
        this.building = building;
        this.building_id = building_id;
    }

    public Reservation() {
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public LocalDate getBookingData() {
        return bookingData;
    }

    public void setBookingData(LocalDate bookingData) {
        this.bookingData = bookingData;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }
}
