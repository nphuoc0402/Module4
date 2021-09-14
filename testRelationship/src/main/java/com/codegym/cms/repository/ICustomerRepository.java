//package com.codegym.cms.repository;
//
//import com.codegym.cms.model.Customer;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.math.BigDecimal;
//import java.util.Optional;
//
//@Repository
//public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
//
//    @Query(value = "SELECT * FROM customers WHERE id = ?1",nativeQuery = true)
//    Optional<Customer> findByIdNativeQuery(Long id);
//
//    @Query(
//            value = "SELECT * FROM customers",
//            nativeQuery = true)
//    Iterable<Customer> findAllActiveUsersNative();
//
//    @Modifying
//    @Query(value = "UPDATE customers  SET c_salary = c_salary + :salary WHERE id = :id", nativeQuery = true)
//    void deposit(@Param("salary") BigDecimal salary, @Param("id") Long id);
//
//    @Modifying
//    @Query(value = "UPDATE Customer AS c  SET c.salary = c.salary - ?1 WHERE c.id = ?2")
//    void withdraw(BigDecimal salary, Long id);
//
//    @Modifying
//    @Query(value = "UPDATE customers  SET c_salary = c_salary - ?1 - ?2 WHERE id = ?2",nativeQuery = true)
//    void transfer(BigDecimal salary, int fee, Long id);
//
//    @Modifying
//    @Query(value = "UPDATE customers  SET c_salary = c_salary + ?1 WHERE id = ?2",nativeQuery = true)
//    void increment(BigDecimal salary, Long id);
//
//    @Modifying
//    @Query(value = "UPDATE Customer AS c  SET c.salary = c.salary - ?1 WHERE c.id = ?2")
//    void decrease(BigDecimal salary, Long id);
//
//    @Query (value = "SELECT * FROM customers WHERE id != ?1",nativeQuery = true)
//    Iterable<Customer> findAllWithoutSenderById(Long id);
//
//}
