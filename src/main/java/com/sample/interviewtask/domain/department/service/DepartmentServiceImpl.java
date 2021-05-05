package com.sample.interviewtask.domain.department.service;

import com.sample.interviewtask.domain.department.model.Department;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import com.sample.interviewtask.domain.department.model.Department;
import com.sample.interviewtask.domain.department.model.DepartmentDto;
import com.sample.interviewtask.domain.department.repository.DepartmentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void create(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        departmentRepository.save(department);
    }

    @Override
    public void update(DepartmentDto departmentDto) {
        Department department = convertToEntity(departmentDto);
        departmentRepository.save(department);
    }

    @Override
    public DepartmentDto getById(int id) {
        return convertToDto(departmentRepository.findById(id).get());
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department> departmentList = departmentRepository.findAll();

        return departmentList.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Page<DepartmentDto> getAllPaginated(int pageNumber) {
        return null;
    }

    @Override
    public void deleteById(int id) {
        departmentRepository.deleteById(id);
    }

    private Department convertToEntity(DepartmentDto departmentDto){
        Department department = modelMapper.map(departmentDto, Department.class);
        return department;
    }
    private DepartmentDto convertToDto(Department department){
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }
}
;