package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select cus from Customer cus where cus.building.idBuilding = :building and cus.dataOfEviction between :data1 and :data2")
    List<Customer> listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@Param("data1")LocalDate data1, @Param("data2")LocalDate data2, @Param("building")int building);

    @Query("select count(cus.idCustomer) from Customer cus where cus.building.idBuilding = :building and cus.dataOfEviction between :data1 and :data2")
    List<Long>countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@Param("data1")LocalDate data1, @Param("data2")LocalDate data2, @Param("building")int building);
}
