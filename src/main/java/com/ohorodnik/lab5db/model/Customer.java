package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private int idCustomer;

    @Column(name = "name_of_customer")
    private String nameOfCustomer;

    /*@JsonIgnore
    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER)
    private List<Room> list;*/
    @Column(name = "room")
    private int room;



    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "data_of_settlement")
    private LocalDate dataOfSettlement;

    //@JsonIgnore
    //@OneToOne(mappedBy = "customer", fetch = FetchType.EAGER, cascade=CascadeType.REMOVE)
    //private Reservation reservation;

    @Column(name = "data_of_eviction")
    private LocalDate dataOfEviction;

    @ManyToOne
    @JoinColumn(name = "service",insertable = false,updatable = false)
    private Service service;

    @Column(name = "service")
    private int service_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "building",insertable = false,updatable = false)
    private Building building;

    @Column(name = "building")
    private int building_id;

    @Column(name = "organization")
    private Boolean isOrganization;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organization",insertable = false,updatable = false)
    private Organization organization;

    @Column(name = "id_organization")
    private Integer organization_id;

    @Column(name = "feedback_and_suggestion")
    private String feedbackAndSuggestion;

    @JsonIgnore
    @OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
    private List<Room> rooms;

    public Customer(String nameOfCustomer, int room, LocalDate bookingDate, LocalDate dataOfSettlement, LocalDate dataOfEviction, Service service, int service_id, Building building, int building_id, Boolean isOrganization, Organization organization, Integer organization_id, String feedbackAndSuggestion, List<Room> rooms) {
        this.nameOfCustomer = nameOfCustomer;
        this.room = room;
        this.bookingDate = bookingDate;
        this.dataOfSettlement = dataOfSettlement;
        this.dataOfEviction = dataOfEviction;
        this.service = service;
        this.service_id = service_id;
        this.building = building;
        this.building_id = building_id;
        this.isOrganization = isOrganization;
        this.organization = organization;
        this.organization_id = organization_id;
        this.feedbackAndSuggestion = feedbackAndSuggestion;
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
    /* public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }*/

    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
    public String getNameOfCustomer() {
        return nameOfCustomer;
    }

    public void setNameOfCustomer(String nameOfCustomer) {
        this.nameOfCustomer = nameOfCustomer;
    }

   /* public List<Room> getList() {
        return list;
    }

    public void setList(List<Room> list) {
        this.list = list;
    }*/

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }

    public Integer getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(Integer organization_id) {
        this.organization_id = organization_id;
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

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Boolean getisOrganization() {
        return isOrganization;
    }

    public String getFeedbackAndSuggestion() {
        return feedbackAndSuggestion;
    }

    public void setFeedbackAndSuggestion(String feedbackAndSuggestion) {
        this.feedbackAndSuggestion = feedbackAndSuggestion;
    }

    public void setisOrganization(Boolean isOrganization) {
        isOrganization = isOrganization;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
