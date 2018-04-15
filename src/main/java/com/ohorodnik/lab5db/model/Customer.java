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

    @Column(name = "data_of_eviction")
    private LocalDate dataOfEviction;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "service")
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "building")
    private Building building;

    @Column(name = "organization")
    private Boolean isOrganization;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_organization")
    private Organization organization;

    @Column(name = "feedback_and_suggestion")
    private String feedbackAndSuggestion;

    public Customer(String nameOfCustomer, int room, LocalDate bookingDate, LocalDate dataOfSettlement, LocalDate dataOfEviction, Service service, Building building, Boolean isOrganization, Organization organization, String feedbackAndSuggestion) {
        this.nameOfCustomer = nameOfCustomer;
        this.room = room;
        this.bookingDate = bookingDate;
        this.dataOfSettlement = dataOfSettlement;
        this.dataOfEviction = dataOfEviction;
        this.service = service;
        this.building = building;
        this.isOrganization = isOrganization;
        this.organization = organization;
        this.feedbackAndSuggestion = feedbackAndSuggestion;
    }

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
