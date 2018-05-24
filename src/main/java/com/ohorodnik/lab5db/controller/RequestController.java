package com.ohorodnik.lab5db.controller;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.model.Organization;
import com.ohorodnik.lab5db.model.ReservationOrganization;
import com.ohorodnik.lab5db.model.Room;
import com.ohorodnik.lab5db.requestModel.AmountCustomer;
import com.ohorodnik.lab5db.requestModel.AmountOrganization;
import com.ohorodnik.lab5db.requestModel.AmountRoom;
import com.ohorodnik.lab5db.service.request.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/request")
public class RequestController {
    @Autowired
    RequestService requestService;

    @RequestMapping("/request1_1")
    List<Organization> listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(@RequestParam int countRoom_id) {
        return requestService.listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(countRoom_id);
    }

    @RequestMapping("/request1_2")
    List<AmountOrganization> countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(@RequestParam int countRoom_id){
        return requestService.countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicated(countRoom_id);
    }

    @RequestMapping("/request1_3")
    List<Organization> listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(@RequestParam int countRoom_id,
                                                                                                                    @RequestParam(value = "firstDate", required = true)
                                                                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                                                    @RequestParam(value = "secondDate", required = true)
                                                                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.listOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(countRoom_id,firstDate,secondDate);
    }

    @RequestMapping("/request1_4")
    List<AmountOrganization> countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(@RequestParam int countRoom_id,
                                                                                                                          @RequestParam(value = "firstDate", required = true)
                                                                                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                                                          @RequestParam(value = "secondDate", required = true)
                                                                                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {
        return requestService.countOrganizationWhatMadeReservationInTheOrderNotLessThanTheIndicatedDuringTheSpecifiedPeriod(countRoom_id, firstDate, secondDate);
    }

    @RequestMapping("/request2_1")
    List<Customer> listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@RequestParam int building_id,
                                                                                        @RequestParam(value = "firstDate", required = true)
                                                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                        @RequestParam(value = "secondDate", required = true)
                                                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate) {

        return requestService.listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(firstDate, secondDate, building_id);
    }

    @RequestMapping("/request2_2")
    List<AmountCustomer> countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@RequestParam(value = "firstDate", required = true)
                                                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                               @RequestParam(value = "secondDate", required = true)
                                                                                               @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate,
                                                                                               @RequestParam int building_id) {
        return requestService.countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(firstDate, secondDate, building_id);
    }

    @RequestMapping("/request3")
    List<AmountRoom> countFreeRoomForThisPeriod(@RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate) {

        return requestService.countFreeRoomForThisPeriod(firstDate);
    }

    @RequestMapping("/request4_1")
    List<AmountRoom> countFreeRoomGeneral(@RequestParam(value = "firstDate", required = true) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate) {
        return requestService.countFreeRoomGeneral(firstDate);
    }

    @RequestMapping("/request4_2")
    List<AmountRoom> countFreeRoomForSpecifiedCharacteristicForThisPeriod(@RequestParam int building_id) {
        return requestService.countFreeRoomForSpecifiedCharacteristicForThisPeriod(building_id);
    }

    @RequestMapping("/request5")
    List<Room> getInformationAboutCertainRoom(@RequestParam int idRoom){
        return requestService.getInformationAboutCertainRoom(idRoom);
    }
    @RequestMapping("/request6")
    List<Room> listRoomWhatWillBeReleasedUntilSpecifiedDate(@RequestParam(value = "date", required = true)@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate date){
        return requestService.listRoomWhatWillBeReleasedUntilSpecifiedDate(date);
    }

    @RequestMapping("/request7")
    List<ReservationOrganization> volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(@RequestParam int organization_id, @RequestParam(value = "firstDate", required = true)
                                                                                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                                                         @RequestParam(value = "secondDate", required = true)
                                                                                                                         @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate){
        return requestService.volumeOfReservedRoomsAndTheirCharacteristicsByTheIndicatedFirmDuringTheSpecifiedPeriod(organization_id,firstDate,secondDate);
    }
    @RequestMapping("/request8")
    List<Customer>listOfUnsatisfiedCustomerAndTheirComplaints(){
        return requestService.listOfUnsatisfiedCustomerAndTheirComplaints();
    }

    //10
    @RequestMapping("/request9")
    List<Customer> informationAboutCustomerWithSpecifiedRoom(@RequestParam int idRoom){
        return requestService.informationAboutCustomerWithSpecifiedRoom(idRoom);
    }
     //11
    @RequestMapping("/request10")
    List<ReservationOrganization>informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod( @RequestParam(value = "firstDate", required = true)
                                                                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                                                                     @RequestParam(value = "secondDate", required = true)
                                                                                                                     @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate){
        return requestService.informationAboutOrganizationWithWhichContractsForBookingRoomsForTheSpecifiedPeriod(firstDate,secondDate);
    }
    //12.1
    @RequestMapping("/request11")
    List<Customer>informationAboutCustomersWhoVisitThehotelMostOften(){
        return requestService.informationAboutCustomersWhoVisitThehotelMostOften();
    }
    //12.2
    @RequestMapping("/request12")
    public List<Customer> informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(@RequestParam int building_id) {
        return requestService.informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(building_id);
    }

    //13.1
    @RequestMapping("/request13")
    List<Customer>informationAboutNewCustomersWithinTheSpecifiedPeriod(@RequestParam(value = "firstDate", required = true)
                                                                        @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate firstDate,
                                                                       @RequestParam(value = "secondDate", required = true)
                                                                       @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate secondDate){
        return requestService.informationAboutNewCustomersWithinTheSpecifiedPeriod(firstDate,secondDate);
    }
    //13.2
    @RequestMapping("/request14")
    List<Customer>informationAboutTheSpecifiedCustomer(@RequestParam int name_id){
        return requestService.informationAboutTheSpecifiedCustomer(name_id);
    }
    @RequestMapping("/request15")
    List<Room>informationAboutWhoWasBusyTheSpecifiedNumberDuringTheSpecifiedPeriod(@RequestParam ("room_id")int room_id){
        return requestService.informationAboutWhoWasBusyTheSpecifiedNumberDuringTheSpecifiedPeriod(room_id);
    }









}
