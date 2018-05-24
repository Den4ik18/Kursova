package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.ReservationOrganization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationOrganizationRepository extends JpaRepository<ReservationOrganization,Integer>{
    @Query("SELECT res  FROM ReservationOrganization res "  +
            "WHERE res.organization.idOrganization =:organization AND res.bookingDate BETWEEN :date1 AND :date2 ")
           List<ReservationOrganization> volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(@Param("organization")int organization, @Param("date1")LocalDate date1,@Param("date2")LocalDate date2);

    @Query("SELECT res FROM ReservationOrganization res WHERE res.bookingDate BETWEEN :date1 AND :date2")
    List<ReservationOrganization>informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod(@Param("date1")LocalDate date1,@Param("date2")LocalDate date2 );
}
