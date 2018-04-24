package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "class_building")
@EntityListeners(AuditingEntityListener.class)
public class ClassBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_class")
    private int idClassHotel;

    @Column(name = "class_hotel")
    private int classHotel;

    @ManyToOne
    @JoinColumn(name = "building",insertable = false,updatable = false)
    private Building building;

    @Column(name = "building")
    private int building_id;

    @JsonIgnore
    @OneToMany(mappedBy = "classBuilding",cascade = CascadeType.REMOVE)
    private List<ReservationOrganization> reservationOrganizations;

    public ClassBuilding(int classHotel, Building building, int building_id, List<ReservationOrganization> reservationOrganizations) {
        this.classHotel = classHotel;
        this.building = building;
        this.building_id = building_id;
        this.reservationOrganizations = reservationOrganizations;
    }

    public List<ReservationOrganization> getReservationOrganizations() {
        return reservationOrganizations;
    }

    public void setReservationOrganizations(List<ReservationOrganization> reservationOrganizations) {
        this.reservationOrganizations = reservationOrganizations;
    }

    public int getBuilding_id() {
        return building_id;
    }

    public void setBuilding_id(int building_id) {
        this.building_id = building_id;
    }
//public ClassBuilding(int i, int i1, Building building) {
    //}


    public ClassBuilding() {
    }

    public int getIdClassHotel() {
        return idClassHotel;
    }

    public void setIdClassHotel(int idClassHotel) {
        this.idClassHotel = idClassHotel;
    }

    public int getClassHotel() {
        return classHotel;
    }

    public void setClassHotel(int classHotel) {
        this.classHotel = classHotel;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }
}
