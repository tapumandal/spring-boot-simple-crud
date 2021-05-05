package com.sample.interviewtask.domain.department.repository;

import com.sample.interviewtask.domain.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by TapuMandal on 5/3/2021.
 * For any query ask online.tapu@gmail.com
 */

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
