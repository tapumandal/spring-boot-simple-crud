package com.sample.interviewtask.domain.customer.repository;

import com.sample.interviewtask.domain.customer.model.Customer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Integer> {

}