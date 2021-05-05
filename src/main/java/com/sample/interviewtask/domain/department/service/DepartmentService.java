package com.sample.interviewtask.domain.department.service;

import com.sample.interviewtask.domain.department.model.Department;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

public interface DepartmentService {

    public void create(DepartmentDto departmentDto);
    public void update(DepartmentDto departmentDto);
    public DepartmentDto getById(int id);
    public List<DepartmentDto> getAll();
    public Page<DepartmentDto> getAllPaginated(int pageNumber);
    public void deleteById(int id);
}
