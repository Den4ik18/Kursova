package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrganizationRepository extends JpaRepository<Organization,Integer> {

    @Query("SELECT org FROM Organization org inner join ReservationOrganization res ON org.idOrganization = res.idReservationOrganization WHERE res.countOfReservationRooms >:countRoom")
    List<Organization>listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(@Param("countRoom")int countRoom);

    @Query("SELECT count(org.idOrganization) FROM Organization org inner join ReservationOrganization res ON org.idOrganization = res.idReservationOrganization WHERE res.countOfReservationRooms >:countRoom AND res.bookingDate BETWEEN :data1 AND :data2")
    List<Long>countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(@Param("countRoom")int countRoom, @Param("data1")LocalDate data1,@Param("data2")LocalDate date2);


}
