package com.ohorodnik.lab5db.repository;

import com.ohorodnik.lab5db.model.Customer;
import com.ohorodnik.lab5db.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    @Query("select cus from Customer cus where cus.building.idBuilding = :building and cus.dataOfEviction between :data1 and :data2")
    List<Customer> listCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@Param("data1")LocalDate data1, @Param("data2")LocalDate data2, @Param("building")int building);

    @Query("select count(cus.idCustomer) from Customer cus where cus.building.idBuilding = :building and cus.dataOfEviction between :data1 and :data2")
    List<Long>countCustomerWhatSettledForSpecifiedPeriodAndInRoomWithCharacteristic(@Param("data1")LocalDate data1, @Param("data2")LocalDate data2, @Param("building")int building);

    @Query("SELECT cus FROM Customer cus WHERE cus.feedbackAndSuggestion LIKE 'негативний'")
    List<Customer>listOfUnsatisfiedCustomerAndTheirComplaints();

    @Query("SELECT cus FROM Customer cus WHERE cus.room = :room")
    List<Customer> informationAboutCustomerWithSpecifiedRoom(@Param("room")int room);
    //

    @Query("SELECT cus FROM  Customer cus GROUP BY cus.nameOfCustomer order by count(cus.idCustomer) desc ")
    List<Customer>informationAboutCustomersWhoVisitThehotelMostOften(Pageable pageable);

    //
    //Query q = em.createNativeQuery("SELECT a.firstname, a.lastname FROM Author a");
    //11
    //@Query(value = "SELECT c.name_of_customer  FROM Customer c  GROUP BY c.name_of_customer order by count(idCustomer) desc LIMIT 1", nativeQuery = true)
    //List<Customer>informationAboutCustomersWhoVisitThehotelMostOften();

    @Query("SELECT cus FROM Customer cus WHERE cus.building.idBuilding = :idBuilding " +
            "GROUP BY cus.nameOfCustomer order by count(cus.idCustomer) desc ")
    List<Customer>informationAboutTheClientsWhoVisitTheHotelInGeneralAndEachCaseSeparately(@Param("idBuilding")int idBuilding,Pageable pageable);

    @Query("SELECT cus FROM Customer cus WHERE cus.dataOfSettlement BETWEEN :date1 AND :date2")
    List<Customer>informationAboutNewCustomersWithinTheSpecifiedPeriod(@Param("date1") LocalDate date1,@Param("date2")LocalDate date2);

    //@Query(value = "SELECT * FROM customer  WHERE id_customer =:name GROUP BY name_of_customer order by id_customer", nativeQuery = true)
    @Query("SELECT cus FROM Customer cus WHERE cus.idCustomer =:name GROUP BY cus.nameOfCustomer ORDER BY count(cus.idCustomer)")
    List<Customer>informationAboutTheSpecifiedCustomer(@Param("name")int name);
}
