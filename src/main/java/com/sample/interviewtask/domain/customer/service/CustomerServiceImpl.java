package com.sample.interviewtask.domain.customer.service;

import com.sample.interviewtask.domain.customer.model.Customer;
import com.sample.interviewtask.domain.customer.model.CustomerDto;
import com.sample.interviewtask.domain.customer.repository.CustomerRepository;
import com.sample.interviewtask.domain.department.model.Department;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import com.sample.interviewtask.domain.department.repository.DepartmentRepository;
import com.sample.interviewtask.domain.department.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void create(CustomerDto customerDto) {

        Customer customer = convertToEntity(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public void update(CustomerDto customerDto) {
        Customer customer = convertToEntity(customerDto);
        customerRepository.save(customer);
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Page<Customer> getAllPaginated(int pageNumber, int pageSize) {
        Pageable requestedEntity = PageRequest.of(pageNumber-1, pageSize);
        Page<Customer> customerPage = customerRepository.findAll(requestedEntity);
        return customerPage;
    }

    @Override
    public void deleteById(int id) {
        customerRepository.deleteById(id);
    }

    private Customer convertToEntity(CustomerDto customerDto){

        Customer customer = modelMapper.map(customerDto, Customer.class);
        if(customerDto.getDepartmentId() > 0) {
            Department department = departmentRepository.findById(customerDto.getDepartmentId()).get();

            if (department != null) {

                List<Department> departmentList = new ArrayList<Department>();
                departmentList.add(department);
                customer.setDepartments(departmentList);
            }
        }

        return customer;
    }
    private CustomerDto convertToDto(Customer customer){
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
}
