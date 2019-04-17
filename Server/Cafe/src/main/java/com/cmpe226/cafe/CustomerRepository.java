package com.cmpe226.cafe;

import com.cmpe226.cafe.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    //PayByBalance
    @Transactional
    @Modifying
    @Query("update Customer c set c.account_balance = c.account_balance - ?2 where cus_id = ?1")
    public int payByBalance(String cus_id, double total_price);

    //topUp
    @Transactional
    @Modifying
    @Query(value = "update customer set account_balance = account_balance + ?2 where cus_id = ?1", nativeQuery = true)
    public int topUp(String cus_id, double value);

    //review
    @Query(value = "select * from customer where cus_id = ?1", nativeQuery = true)
    public Customer review(String cus_id);
}