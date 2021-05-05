package com.sample.interviewtask.domain.department.controller;

import com.google.gson.Gson;
import com.sample.interviewtask.domain.department.model.Department;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import com.sample.interviewtask.domain.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

@Controller
@RequestMapping(value = {"/department"})
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String getAll(HttpServletRequest request, Model model){
        List<DepartmentDto> departmentList = departmentService.getAll();
        System.out.println(new Gson().toJson(departmentList));
        model.addAttribute("departmentList",departmentList);
        return "department";
    }

    @RequestMapping(value = {"create"}, method = RequestMethod.GET)
    public String createForm(HttpServletRequest request){

        return "departmentcreate";
    }

    @RequestMapping(value = {"create"}, method = RequestMethod.POST)
    public String create(@ModelAttribute DepartmentDto departmentDto, HttpServletRequest request){

        departmentService.create(departmentDto);

        return "redirect:/department";
    }

    @RequestMapping(value = {"update/{id}"}, method = RequestMethod.GET)
    public String updateForm(@PathVariable("id") int id,  HttpServletRequest request, Model model){

        DepartmentDto departmentDto = departmentService.getById(id);
        model.addAttribute(departmentDto);
        return "departmentupdate";
    }

    @RequestMapping(value = {"update/{id}"}, method = RequestMethod.POST)
    public String update(@PathVariable("id") int id, @ModelAttribute DepartmentDto departmentDto, HttpServletRequest request){

        departmentService.update(departmentDto);

        return "redirect:/department";
    }
    @RequestMapping(value = {"delete/{id}"}, method = RequestMethod.GET)
    public String update(@PathVariable("id") int id, HttpServletRequest request){

        departmentService.deleteById(id);

        return "redirect:/department";
    }
}
