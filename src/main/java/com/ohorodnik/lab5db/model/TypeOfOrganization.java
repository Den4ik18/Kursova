package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

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


    @JsonIgnore
    @OneToMany(mappedBy = "typeOfOrganization",cascade = CascadeType.REMOVE)
    private List<Organization> organizations;


    public TypeOfOrganization(String organizationCharacteristic, List<Organization> organizations) {
        this.organizationCharacteristic = organizationCharacteristic;
        this.organizations = organizations;
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

    public List<Organization> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organization> organizations) {
        this.organizations = organizations;
    }
}
