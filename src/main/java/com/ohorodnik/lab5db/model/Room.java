package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "room")
@EntityListeners(AuditingEntityListener.class)
public class Room {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_room")
    private int idRoom;

    @Column(name = "number_of_room")
    private int numberOfRoom;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "data_of_settlement")
    private LocalDate dataOfSettlement;

    @Column(name = "data_of_eviction")
    private LocalDate dataOfEviction;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building",insertable = false,updatable = false)
    private Building building;

    @Column(name = "building")
    private int building_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer",insertable = false,updatable = false)
    private Customer customer;

    @Column(name = "customer")
    private Integer customer_id;

    @JsonIgnore
    @OneToMany(mappedBy = "room",cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    public Room(int numberOfRoom, LocalDate bookingDate, LocalDate dataOfSettlement, LocalDate dataOfEviction, Building building, int building_id, Customer customer, Integer customer_id, List<Reservation> reservations) {
        this.numberOfRoom = numberOfRoom;
        this.bookingDate = bookingDate;
        this.dataOfSettlement = dataOfSettlement;
        this.dataOfEviction = dataOfEviction;
        this.building = building;
        this.building_id = building_id;
        this.customer = customer;
        this.customer_id = customer_id;
        this.reservations = reservations;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;//
    }

    public Room() {
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(int numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
