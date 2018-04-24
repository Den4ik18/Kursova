package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.jmx.export.annotation.ManagedOperation;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "organization")
@EntityListeners(AuditingEntityListener.class)
public class Organization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_organization")
    private int idOrganization;

    @Column(name = "name_of_organization")
    private String nameOfOrganization;


    //@OneToMany(mappedBy = "organization",cascade = CascadeType.REMOVE)
    //List<ReservationOrganization> reservationOrganizations;

    //@OneToMany(mappedBy = "organization",cascade = CascadeType.REMOVE)
    //List<Customer> customers;

    @ManyToOne
    @JoinColumn(name = "type_of_organization",insertable = false,updatable = false)
    private TypeOfOrganization typeOfOrganization;

    @Column(name = "type_of_organization")
    private int typeOfOrganization_id;

    @JsonIgnore
    @OneToMany(mappedBy = "organization",cascade = CascadeType.REMOVE)
    private List<Customer> customer;

    @JsonIgnore
    @OneToMany(mappedBy = "organization",cascade = CascadeType.REMOVE)
    private List<ReservationOrganization> reservationOrganizations;

    public Organization(String nameOfOrganization, TypeOfOrganization typeOfOrganization, int typeOfOrganization_id, List<Customer> customer, List<ReservationOrganization> reservationOrganizations) {
        this.nameOfOrganization = nameOfOrganization;
        this.typeOfOrganization = typeOfOrganization;
        this.typeOfOrganization_id = typeOfOrganization_id;
        this.customer = customer;
        this.reservationOrganizations = reservationOrganizations;
    }

    public List<Customer> getCustomer() {
        return customer;//
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;//
    }

    public List<ReservationOrganization> getReservationOrganizations() {
        return reservationOrganizations;
    }

    public void setReservationOrganizations(List<ReservationOrganization> reservationOrganizations) {
        this.reservationOrganizations = reservationOrganizations;
    }

    public Organization() {
    }

    public int getIdOrganization() {
        return idOrganization;
    }

    public void setIdOrganization(int idOrganization) {
        this.idOrganization = idOrganization;
    }

    public String getNameOfOrganization() {
        return nameOfOrganization;
    }

    public void setNameOfOrganization(String nameOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
    }

    public TypeOfOrganization getTypeOfOrganization() {
        return typeOfOrganization;
    }

    public void setTypeOfOrganization(TypeOfOrganization typeOfOrganization) {
        this.typeOfOrganization = typeOfOrganization;
    }

    public long getTypeOfOrganization_id() {
        return typeOfOrganization_id;
    }

    public void setTypeOfOrganization_id(int typeOfOrganization_id) {
        this.typeOfOrganization_id = typeOfOrganization_id;
    }

   /* public List<ReservationOrganization> getReservationOrganizations() {
        return reservationOrganizations;
    }

    public void setReservationOrganizations(List<ReservationOrganization> reservationOrganizations) {
        this.reservationOrganizations = reservationOrganizations;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }*/
}
