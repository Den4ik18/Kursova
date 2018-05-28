package com.ohorodnik.lab5db.service.request;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.model.Organization;
import com.ohorodnik.lab5db.model.ReservationOrganization;
import com.ohorodnik.lab5db.model.Room;
import com.ohorodnik.lab5db.requestModel.AmountCustomer;
import com.ohorodnik.lab5db.requestModel.AmountOrganization;
import com.ohorodnik.lab5db.requestModel.AmountRoom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;

public interface IRequestService {
    //1.1
    List<Organization>listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(int countRoom);
    //1.2
    List<AmountOrganization>countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(int countRoom);
    //1.3
    List<Organization>listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(int countRoom,LocalDate data1,LocalDate date2);
    //1.4
    List<AmountOrganization>countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(int countRoom, LocalDate firstDate, LocalDate secondDate);
    //2.1
    List<Customer> listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(LocalDate firstDate, LocalDate secondDate, int building);

    //2.2
    List<AmountCustomer>countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(LocalDate data1,LocalDate data2, int building);

    //3
    List<AmountRoom> countFreeRoomForThisPeriod(LocalDate data);

    //4.1
    List<AmountRoom> countFreeRoomGeneral(LocalDate data);

    //4.2
    List<AmountRoom>countFreeRoomForSpecifiedCharacteristicForThisPeriod(int building);

    //5
    List<Room> getInformationAboutCertainRoom(int idRoom );

    //6
    List<Room> listRoomWhatWillBeReleasedUntilSpecifiedDate(LocalDate date);

    //7
    List<ReservationOrganization> volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(int organization, LocalDate date1,LocalDate date2);

    //8
    List<Customer>listOfUnsatisfiedCustomerAndTheirComplaints();

    //9
    List<Customer> informationAboutCustomerWithSpecifiedRoom(int room);

    //11
    List<ReservationOrganization>informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod(LocalDate date1,LocalDate date2 );

    //12
    List<Customer>informationAboutCustomersWhoVisitThehotelMostOften();

    //12.1
    List<Customer>informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(int idBuilding);

   //13.1
   List<Customer>informationAboutNewCustomersWithinTheSpecifiedPeriod( LocalDate date1,LocalDate date2);

   //13.2
   List<Customer>informationAboutTheSpecifiedCustomer(int name);

   //14
   List<Room>informationAboutWhoWasBusyTheSpecifiedNumberDuringTheSpecifiedPeriod(int room);




}
