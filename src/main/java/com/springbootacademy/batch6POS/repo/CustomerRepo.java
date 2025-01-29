package com.springbootacademy.batch6POS.repo;

import com.springbootacademy.batch6POS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Customer c SET c.customerName = :customerName, c.customerAdress = :customerAdress, c.customerSalary = :customerSalary WHERE c.customerId = :customerId")
    int updateCustomer(
            @Param("customerId") int customerId,
            @Param("customerName") String customerName,
            @Param("customerAdress") String customerAdress,
            @Param("customerSalary") Double customerSalary
    );

    Optional<Customer> findByCustomerNicEquals(String nic);

    List<Customer> findAllByActiveStateEquals(boolean status);

    List<Customer> findAllByCustomerNameEqualsAndActiveStateEquals(String name, boolean status);

    // Optional<Customer> findByNucEquals(String nic);
//    Optional<Customer> findBYNic(String nic);
}
