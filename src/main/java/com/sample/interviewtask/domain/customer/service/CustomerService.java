package com.sample.interviewtask.domain.customer.service;

import com.sample.interviewtask.domain.customer.model.Customer;
import com.sample.interviewtask.domain.customer.model.CustomerDto;
import org.springframework.data.domain.Page;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

public interface CustomerService {

    public void create(CustomerDto customerDto);
    public void update(CustomerDto customerDto);
    public Customer getById(int id);
    public Page<Customer> getAllPaginated(int pageNumber, int pageSize);
    public void deleteById(int id);
}
