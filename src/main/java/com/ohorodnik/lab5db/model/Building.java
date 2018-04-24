package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "building")
@EntityListeners(AuditingEntityListener.class)
public class Building {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_building")
    private int idBuilding;

    //@Column(nullable = false)
    @Column(name = "class_hotel")
    private int classHotel;

    @Column(name = "count_of_floors")
    private int countOfFloor;

    @Column(name = "total_number_of_rooms")
    private int totalCountOfRooms;

    @Column(name = "count_rooms_on_the_floor")
    private int countRoomsOnTheFloor;

    @Column(name = "area_of_numbers")
    private String areaOfNumber;

    @Column(name = "adress_of_hotel_building")
    private String addressOfHotelBuilding;

    @JsonIgnore
    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private List<ClassBuilding> classBuildings;

    @JsonIgnore
    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private List<Reservation> reservations;

    @JsonIgnore
    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private List<Customer> customer;

    @JsonIgnore
    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private List<ReservationOrganization> reservationOrganizations;

    @JsonIgnore
    @OneToMany(mappedBy = "building",cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    public Building(int classHotel, int countOfFloor, int totalCountOfRooms, int countRoomsOnTheFloor, String areaOfNumber, String addressOfHotelBuilding, List<ClassBuilding> classBuildings, List<Reservation> reservations, List<Customer> customer, List<ReservationOrganization> reservationOrganizations, List<Room> rooms) {
        this.classHotel = classHotel;
        this.countOfFloor = countOfFloor;
        this.totalCountOfRooms = totalCountOfRooms;
        this.countRoomsOnTheFloor = countRoomsOnTheFloor;
        this.areaOfNumber = areaOfNumber;
        this.addressOfHotelBuilding = addressOfHotelBuilding;
        this.classBuildings = classBuildings;
        this.reservations = reservations;
        this.customer = customer;
        this.reservationOrganizations = reservationOrganizations;
        this.rooms = rooms;
    }
////
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<ReservationOrganization> getReservationOrganizations() {
        return reservationOrganizations;
    }

    public void setReservationOrganizations(List<ReservationOrganization> reservationOrganizations) {
        this.reservationOrganizations = reservationOrganizations;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
// public Building(int i, int i1, int i2, int i3, int i4, String двохмісні, String s) {
    //}

    public Building() {
    }

    public int getIdBuilding() {
        return idBuilding;
    }

    public void setIdBuilding(int idBuilding) {
        this.idBuilding = idBuilding;
    }

    public int getClassHotel() {
        return classHotel;
    }

    public void setClassHotel(int classHotel) {
        this.classHotel = classHotel;
    }

    public int getCountOfFloor() {
        return countOfFloor;
    }

    public void setCountOfFloor(int countOfFloor) {
        this.countOfFloor = countOfFloor;
    }

    public int getTotalCountOfRooms() {
        return totalCountOfRooms;
    }

    public void setTotalCountOfRooms(int totalCountOfRooms) {
        this.totalCountOfRooms = totalCountOfRooms;
    }

    public int getCountRoomsOnTheFloor() {
        return countRoomsOnTheFloor;
    }

    public void setCountRoomsOnTheFloor(int countRoomsOnTheFloor) {
        this.countRoomsOnTheFloor = countRoomsOnTheFloor;
    }

    public String getAreaOfNumber() {
        return areaOfNumber;
    }

    public void setAreaOfNumber(String areaOfNumber) {
        this.areaOfNumber = areaOfNumber;
    }

    public String getAddressOfHotelBuilding() {
        return addressOfHotelBuilding;
    }

    public void setAddressOfHotelBuilding(String addressOfHotelBuilding) {
        this.addressOfHotelBuilding = addressOfHotelBuilding;
    }

    public List<ClassBuilding> getClassBuildings() {
        return classBuildings;
    }

    public void setClassBuildings(List<ClassBuilding> classBuildings) {
        this.classBuildings = classBuildings;
    }
    /*
    spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://localhost:3306/lab5db
spring.datasource.username=root
spring.datasource.password=root
    */
}
