package com.sample.interviewtask.domain.customer.controller;

import com.google.gson.Gson;
import com.sample.interviewtask.config.UtilityConfig;
import com.sample.interviewtask.domain.customer.model.Customer;
import com.sample.interviewtask.domain.customer.model.CustomerDto;
import com.sample.interviewtask.domain.customer.service.CustomerService;
import com.sample.interviewtask.domain.customer.model.CustomerDto;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import com.sample.interviewtask.domain.department.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

@Controller
@RequestMapping(value = {"/"})
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = {"", "/customer"}, method = RequestMethod.GET)
    public String getAll(@RequestParam(value = "size", required = false) Integer size, @RequestParam(value ="page", required = false) Integer page,  HttpServletRequest request, Model model){

        if(size == null){ size = 10; }
        if(page == null){ page = 1; }

        Page<Customer> customerList = customerService.getAllPaginated(page, size);

        System.out.println(new Gson().toJson(customerList));

        model.addAttribute("customerList", customerList);

        int totalPages = customerList.getTotalPages();
        List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                .boxed()
                .collect(Collectors.toList());
        model.addAttribute("pageNumbers", pageNumbers);

        return "customer";
    }

    @RequestMapping(value = {"customer/create"}, method = RequestMethod.GET)
    public String createForm(HttpServletRequest request, Model model){

        List<DepartmentDto> departmentDtoList = departmentService.getAll();
        model.addAttribute("departmentDtoList", departmentDtoList);
        return "customercreate";
    }

    @RequestMapping(value = {"customer/create"}, method = RequestMethod.POST)
    public String create(@ModelAttribute CustomerDto customerDto, HttpServletRequest request){

        customerService.create(customerDto);

        System.out.println(new Gson().toJson(customerDto));

        return "redirect:/customer";
    }


    @RequestMapping(value = {"customer/update/{id}"}, method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") int id, HttpServletRequest request, Model model){

        Customer customer = customerService.getById(id);
        List<DepartmentDto> departmentDtoList = departmentService.getAll();
        System.out.println(new Gson().toJson(customer));
        System.out.println(new Gson().toJson(departmentDtoList));

        model.addAttribute("departmentDtoList", departmentDtoList);
        model.addAttribute(customer);

        return "customerupdate";
    }

    @RequestMapping(value = {"customer/update/{id}"}, method = RequestMethod.POST)
    public String update(@PathVariable("id") int id, @ModelAttribute CustomerDto customerDto, HttpServletRequest request){

        customerService.update(customerDto);

        return "redirect:/customer";
    }
    @RequestMapping(value = {"customer/delete/{id}"}, method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, HttpServletRequest request){

        customerService.deleteById(id);

        return "redirect:/customer";
    }
}
