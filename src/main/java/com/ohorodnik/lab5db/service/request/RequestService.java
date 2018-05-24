package com.ohorodnik.lab5db.service.request;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.model.Organization;
import com.ohorodnik.lab5db.model.ReservationOrganization;
import com.ohorodnik.lab5db.model.Room;
import com.ohorodnik.lab5db.repository.*;
import com.ohorodnik.lab5db.requestModel.AmountCustomer;
import com.ohorodnik.lab5db.requestModel.AmountOrganization;
import com.ohorodnik.lab5db.requestModel.AmountRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RequestService implements IRequestService {
   @Autowired
   CustomerRepository customerRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ReservationOrganizationRepository reservationOrganizationRepository;
    //list without date 1.1
    @Override
    public List<Organization> listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(int countRoom) {
        return organizationRepository.listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(countRoom);
    }
    //count without date 1.2
    @Override
    public List<AmountOrganization> countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(int countRoom) {
        List<AmountOrganization> list = new ArrayList<>();
        List<Long> amountOfOrganization = organizationRepository.countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(countRoom);
        for(int i = 0;i<amountOfOrganization.size();i++){
            list.add(
                    new AmountOrganization(
                            amountOfOrganization.get(i)
                    )
            );
        }
        return list;
    }

    //list with date 1.3
    @Override
    public List<Organization> listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(int countRoom, LocalDate data1, LocalDate date2) {
        return organizationRepository.listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(countRoom,data1,date2);
    }
     //amount with date 1.4
    @Override
    public List<AmountOrganization> countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(int countRoom, LocalDate firstDate, LocalDate secondDate) {
        List<AmountOrganization> list = new ArrayList<>();
        List<Long> amountOfOrganization = organizationRepository.countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(countRoom,firstDate,secondDate);
        for(int i = 0;i<amountOfOrganization.size();i++){
            list.add(
                    new AmountOrganization(
                            amountOfOrganization.get(i)
                    )
            );
        }
        return list;
    }

    @Override
    public List<Customer> listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(LocalDate firstDate, LocalDate secondDate, int building) {
        return customerRepository.listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(firstDate,secondDate,building);
    }

    @Override
    public List<AmountCustomer> countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(LocalDate data1, LocalDate data2, int building) {
        List<AmountCustomer> list = new ArrayList<>();
        List<Long>amountOfCustomer = customerRepository.countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(data1,data2,building);
        for(int i = 0;i<amountOfCustomer.size();i++){
            list.add(new AmountCustomer(
                    amountOfCustomer.get(i)
            ));
        }
        return list;
    }

    @Override
    public List<AmountRoom> countFreeRoomForThisPeriod(LocalDate data) {
        //AmountRoom amountRoom = new AmountRoom();
        //amountRoom.setAmountRoom(roomRepository.countFreeRoomForThisPeriod(data));
        List<AmountRoom> list = new ArrayList<>();
        List<Long>amountOfRoom = roomRepository.countFreeRoomForThisPeriod(data);
        for (int i = 0; i < amountOfRoom.size(); i++) {
            list.add(new AmountRoom(
                    amountOfRoom.get(i)

            ));
        }
        return list;

    }

    @Override
    public List<AmountRoom> countFreeRoomGeneral(LocalDate data) {
        List<AmountRoom> list = new ArrayList<>();
        List<Long>amountOfRoom = roomRepository.countFreeRoomGeneral(data);
        for (int i = 0; i < amountOfRoom.size(); i++) {
            list.add(new AmountRoom(
                    amountOfRoom.get(i)

            ));
        }
        return list;
    }

    @Override
    public List<AmountRoom> countFreeRoomForSpecifiedCharacteristicForThisPeriod(int building) {
        List<AmountRoom> list = new ArrayList<>();
        List<Long>amountOfRoom = roomRepository.countFreeRoomForSpecifiedCharacteristicForThisPeriod(building);
        for (int i = 0; i < amountOfRoom.size(); i++) {
            list.add(new AmountRoom(
                    amountOfRoom.get(i)

            ));
        }
        return list;
    }

    @Override
    public List<Room> getInformationAboutCertainRoom(int idRoom) {
        return roomRepository.getInformationAboutCertainRoom(idRoom);
    }

    @Override
    public List<Room> listRoomWhatWillBeReleasedUntilSpecifiedDate(LocalDate date) {
        return roomRepository.listRoomWhatWillBeReleasedUntilSpecifiedDate(date);
    }

    @Override
    public List<ReservationOrganization> volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(int organization, LocalDate date1, LocalDate date2) {
        return reservationOrganizationRepository.volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(organization,date1,date2);
    }

    @Override
    public List<Customer> listOfUnsatisfiedCustomerAndTheirComplaints() {
        return customerRepository.listOfUnsatisfiedCustomerAndTheirComplaints();
    }

    @Override
    public List<Customer> informationAboutCustomerWithSpecifiedRoom(int room) {
        return customerRepository.informationAboutCustomerWithSpecifiedRoom(room);
    }

    @Override
    public List<ReservationOrganization> informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod(LocalDate date1, LocalDate date2) {
        return reservationOrganizationRepository.informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod(date1,date2);
    }

    @Override
    public List<Customer> informationAboutCustomersWhoVisitThehotelMostOften() {
        return customerRepository.informationAboutCustomersWhoVisitThehotelMostOften(new PageRequest(0, 1));
    }

    @Override
    public List<Customer> informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(int building) {
        return customerRepository.informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(building,new PageRequest(0, 1));
    }

    @Override
    public List<Customer> informationAboutNewCustomersWithinTheSpecifiedPeriod(LocalDate date1, LocalDate date2) {
        return customerRepository.informationAboutNewCustomersWithinTheSpecifiedPeriod(date1,date2);
    }

    @Override
    public List<Customer> informationAboutTheSpecifiedCustomer(int name) {
        return customerRepository.informationAboutTheSpecifiedCustomer(name);

    }

    @Override
    public List<Room> informationAboutWhoWasBusyTheSpecifiedNumberDuringTheSpecifiedPeriod(int room) {
        return roomRepository.informationAboutWhoWasBusyTheSpecifiedNumberDuringTheSpecifiedPeriod(room);
    }


}
