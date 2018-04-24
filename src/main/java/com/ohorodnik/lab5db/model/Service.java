package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@EntityListeners(AuditingEntityListener.class)
public class Service {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_service")
    private int idService;

    @Column(name = "name_of_service")
    private String nameOfService;

    @Column(name = "cost_of_service")
    private int costOfService;

    @JsonIgnore
    @OneToMany(mappedBy = "service",cascade = CascadeType.REMOVE)
    private List<Customer> customer;

    public Service(String nameOfService, int costOfService, List<Customer> customer) {
        this.nameOfService = nameOfService;
        this.costOfService = costOfService;
        this.customer = customer;
    }

    public Service() {
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameOfService() {
        return nameOfService;
    }

    public void setNameOfService(String nameOfService) {
        this.nameOfService = nameOfService;
    }

    public int getCostOfService() {
        return costOfService;
    }

    public void setCostOfService(int costOfService) {
        this.costOfService = costOfService;
    }

    public List<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(List<Customer> customer) {
        this.customer = customer;
    }
}
