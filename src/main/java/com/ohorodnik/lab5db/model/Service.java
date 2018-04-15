package com.ohorodnik.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "service")
@EntityListeners(AuditingEntityListener.class)
public class Service {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id_service")
    private int idService;

    @Column(name = "name_of_service")
    private String nameOfService;

    @Column(name = "cost_of_service")
    private int costOfService;

    public Service(int idService, String nameOfService, int costOfService) {
        this.idService = idService;
        this.nameOfService = nameOfService;
        this.costOfService = costOfService;
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
}
