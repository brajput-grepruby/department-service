package com.training.department_service.service;

import com.training.department_service.entity.Department;
import com.training.department_service.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
  Department saveDepartment(Department department);


  Department findDepartmentById(Long departmentId);

  void deleteDepartmentById(Long departmentId);

  Department updateDepartment(Long departmentId, Department department);

  List<Department> findAllDepartment();
}
