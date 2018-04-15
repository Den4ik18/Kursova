package com.ohorodnik.lab5db.datastorage;

import com.ohorodnik.lab5db.model.*;
import javafx.scene.input.DataFormat;
import org.springframework.context.annotation.Configuration;


import javax.xml.crypto.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

@Configuration
public class DataStorageFake {
    public List<Building> buildingList = new ArrayList<>(
            Arrays.asList(
                    new Building( 3, 4, 40, 10, "двохмісні", "вул.Гагаріна, 62"),
                    new Building( 4, 4, 40, 10, "трохмісні", "вул.Дубінська, 10"),
                    new Building( 2, 5, 50, 10, "одномісні", "вул.Садова, 127"),
                    new Building( 5, 3, 33, 11, "двохмісні", "вул.Грушевського, 10"),
                    new Building( 3, 2, 50, 25, "одномісні", "вул.Дачна, 15"),

                    new Building( 3, 4, 40, 10, "одномісні", "вул.Ентузіастів, 4"),
                    new Building( 4, 3, 30, 10, "двохмісні", "вул.Гайдара, 1А"),
                    new Building( 5, 5, 55, 11, "двохмісні", "вул.Сонячна, 21"),
                    new Building(3, 3, 60, 20, "трохмісні", "вул.Перемоги, 9"),
                    new Building( 2, 2, 80, 40, "одномісні", "вул.Зради, 10"),

                    new Building( 3, 2, 50, 25, "трохмісні", "вул.Леоніда Кучми, 94"),
                    new Building( 4, 3, 40, 15, "одномісні", "вул.Кохання, 69"),
                    new Building(5, 2, 50, 25, "трохмісні", "вул.Бульварська, 4"),
                    new Building( 2, 4, 32, 8, "двомісні", "вул.Проспектна, 22"),
                    new Building( 3, 4, 80, 20, "одномісні", "вул.Рівненська, 32")
            )
    );

    public List<Building> getBuildingList() {
        return buildingList;
    }

    public List<ClassBuilding> classList = new ArrayList<>(
            Arrays.asList(
                    new ClassBuilding( 3, buildingList.get(0)),
                    new ClassBuilding( 4, buildingList.get(1)),
                    new ClassBuilding( 2, buildingList.get(2)),
                    new ClassBuilding(5, buildingList.get(3)),
                    new ClassBuilding( 3, buildingList.get(4)),

                    new ClassBuilding( 4, buildingList.get(5)),
                    new ClassBuilding(3, buildingList.get(6)),
                    new ClassBuilding( 2, buildingList.get(7)),
                    new ClassBuilding(5, buildingList.get(8)),
                    new ClassBuilding( 3, buildingList.get(9))
            )
    );

    public List<ClassBuilding> getClassList() {
        return classList;
    }

    public List<TypeOfOrganization> typeOfOrganizationList = new ArrayList<>(
            Arrays.asList(
                    new TypeOfOrganization( "спортсмени"),
                    new TypeOfOrganization("рубалки"),
                    new TypeOfOrganization("мисливці"),
                    new TypeOfOrganization( "водії"),
                    new TypeOfOrganization( "банкіри")
            )
    );

    public List<TypeOfOrganization> getTypeOfOrganizationList() {
        return typeOfOrganizationList;
    }

    public List<Organization> organizations = new ArrayList<>(
            Arrays.asList(
                    new Organization( "ЗОЖ", typeOfOrganizationList.get(0)),
                    new Organization( "Fisher", typeOfOrganizationList.get(1)),
                    new Organization( "Bear", typeOfOrganizationList.get(2)),
                    new Organization( "Ferrari", typeOfOrganizationList.get(3)),
                    new Organization( "Приват банк", typeOfOrganizationList.get(4))


            )
    );


    public List<Organization> getOrganizationsList() {
        return organizations;
    }

    public List<Service> serviceList = new ArrayList<>(
            Arrays.asList(
                    new Service( "Спортзал", 5),
                    new Service( "Додатковий шампунь", 10)

            )
    );

    public List<Service> getServiceList() {
        return serviceList;
    }

    public List<Customer> customerList = Arrays.asList(
            new Customer( "Петров Д.В.", 1, LocalDate.of(2018, 02, 10), LocalDate.of(2018, 02, 20), LocalDate.of(2018, 02, 24),
                    serviceList.get(0), buildingList.get(0), true, organizations.get(0), "Позитивний"),
            new Customer( "Іванов В.І.", 2, LocalDate.of(2018, 01, 02), LocalDate.of(2018, 01, 16), LocalDate.of(2018, 01, 20),
                    serviceList.get(1), buildingList.get(1), true, organizations.get(0), "Позитивний"),
            new Customer("Дякун Д.Б.", 3, LocalDate.of(2017, 03, 10), LocalDate.of(2017, 03, 20), LocalDate.of(2017, 03, 23),
                    serviceList.get(0), buildingList.get(2), false, null, "Позитивний"),
            new Customer( "Токарук В.І.", 3, LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 23), LocalDate.of(2017, 10, 25),
                    serviceList.get(1), buildingList.get(3), false, null, "Негативний"),
            new Customer("Сікорська М.М.", 5, LocalDate.of(2017, 11, 01), LocalDate.of(2017, 11, 12), LocalDate.of(2017, 11, 16),
                    serviceList.get(0), buildingList.get(4), true, organizations.get(4), "Негативний")


    );


    public List<Customer> getCustomerList() {
        return customerList;
    }


    public List<Room> roomList = new ArrayList<>(
            Arrays.asList(
                    new Room( 15, LocalDate.of(2018, 02, 10), LocalDate.of(2018, 02, 20), LocalDate.of(2018, 02, 24), getBuildingList().get(0), customerList.get(0)),
                    new Room( 17, LocalDate.of(2018, 01, 02), LocalDate.of(2018, 01, 16), LocalDate.of(2018, 01, 20), getBuildingList().get(1), customerList.get(1)),
                    new Room( 19, LocalDate.of(2017, 03, 10), LocalDate.of(2017, 03, 20), LocalDate.of(2017, 03, 23), getBuildingList().get(2), customerList.get(2)),
                    new Room( 22, LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 23), LocalDate.of(2017, 10, 25), getBuildingList().get(3), customerList.get(3)),
                    new Room( 23, LocalDate.of(2017, 11, 01), LocalDate.of(2017, 11, 12), LocalDate.of(2017, 11, 16), getBuildingList().get(4), customerList.get(4))


            )
    );

    public List<Room> getRoomList() {
        return roomList;
    }

    public List<Reservation> reservationList = new ArrayList<>(
            Arrays.asList(new Reservation( roomList.get(0), LocalDate.of(2018, 02, 10), LocalDate.of(2018, 02, 20),
                            LocalDate.of(2018, 02, 24), customerList.get(0), buildingList.get(0)),
                    new Reservation( roomList.get(1), LocalDate.of(2018, 01, 02),
                            LocalDate.of(2018, 01, 16), LocalDate.of(2018, 01, 20), customerList.get(1), buildingList.get(1)),
                    new Reservation(roomList.get(2), LocalDate.of(2017, 03, 10), LocalDate.of(2017, 03, 20), LocalDate.of(2017, 03, 23),
                            customerList.get(0), buildingList.get(0)),
                    new Reservation( roomList.get(3), LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 23), LocalDate.of(2017, 10, 25),
                            customerList.get(3), buildingList.get(3)),
                    new Reservation( roomList.get(4), LocalDate.of(2017, 11, 01), LocalDate.of(2017, 11, 12), LocalDate.of(2017, 11, 16),
                            customerList.get(4), buildingList.get(4))
            )

    );

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public List<ReservationOrganization> reservationOrganizationList = new ArrayList<>(
            Arrays.asList(
                    new ReservationOrganization( 2, 2, 2, classList.get(0),
                            "8,9", LocalDate.of(2018, 02, 10), LocalDate.of(2018, 02, 20), LocalDate.of(2018, 02, 24), buildingList.get(0), organizations.get(0)),
                    new ReservationOrganization( 3, 2, 2, classList.get(1), "12,13", LocalDate.of(2017, 10, 10), LocalDate.of(2017, 10, 20),
                            LocalDate.of(2017, 10, 25), buildingList.get(1), organizations.get(1)),
                    new ReservationOrganization( 3, 2, 2, classList.get(2), "3,4",
                            LocalDate.of(2018, 01, 02), LocalDate.of(2018, 01, 16), LocalDate.of(2018, 01, 20), buildingList.get(2), organizations.get(3)),
                    new ReservationOrganization( 2, 2, 2, classList.get(3), "55,57", LocalDate.of(2017, 12, 01),
                            LocalDate.of(2017, 12, 20), LocalDate.of(2017, 12, 28), buildingList.get(3), organizations.get(3)),
                    new ReservationOrganization( 1, 2, 2, classList.get(4), "70,72", LocalDate.of(2016, 03, 10), LocalDate.of(2016, 03, 24), LocalDate.of(2016, 02, 27), buildingList.get(4), organizations.get(4))

            )
    );

    public List<ReservationOrganization> getReservationOrganizationList() {
        return reservationOrganizationList;
    }
}



