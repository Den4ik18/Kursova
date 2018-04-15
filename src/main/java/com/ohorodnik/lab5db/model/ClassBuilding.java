package com.ohorodnik.lab5db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "building")
    private Building building;

    public ClassBuilding(int classHotel, Building building) {
        this.classHotel = classHotel;
        this.building = building;
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
