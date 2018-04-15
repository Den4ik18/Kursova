package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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



    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "type_of_organization")
    private TypeOfOrganization typeOfOrganization;

    public Organization(String nameOfOrganization, TypeOfOrganization typeOfOrganization) {
        this.nameOfOrganization = nameOfOrganization;
        this.typeOfOrganization = typeOfOrganization;
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
}
