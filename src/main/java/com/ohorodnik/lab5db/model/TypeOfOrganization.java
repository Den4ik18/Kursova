package com.ohorodnik.lab5db.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "type_of_organization")
@EntityListeners(AuditingEntityListener.class)
public class TypeOfOrganization {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_type_of_organization")
    private int idTypeOfOrganization;

    @Column(name = "organization_characteristic")
    private String organizationCharacteristic;


    public TypeOfOrganization(int idTypeOfOrganization, String organizationCharacteristic) {
        this.idTypeOfOrganization = idTypeOfOrganization;
        this.organizationCharacteristic = organizationCharacteristic;
    }

    public TypeOfOrganization() {
    }

    public int getIdTypeOfOrganization() {
        return idTypeOfOrganization;
    }

    public void setIdTypeOfOrganization(int idTypeOfOrganization) {
        this.idTypeOfOrganization = idTypeOfOrganization;
    }

    public String getOrganizationCharacteristic() {
        return organizationCharacteristic;
    }

    public void setOrganizationCharacteristic(String organizationCharacteristic) {
        this.organizationCharacteristic = organizationCharacteristic;
    }
}
