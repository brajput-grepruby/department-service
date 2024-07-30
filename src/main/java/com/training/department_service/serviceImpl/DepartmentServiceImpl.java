package com.training.department_service.serviceImpl;

import com.training.department_service.exception.DepartmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.department_service.entity.Department;
import com.training.department_service.service.DepartmentService;
import com.training.department_service.repository.DepartmentRepository;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired
  private DepartmentRepository departmentRepository;

  @Override
  public List<Department> findAllDepartment() {
    List<Department> departments = departmentRepository.findAll();
    return departments;
  }

  @Override
  public Department saveDepartment(Department department) {
    return departmentRepository.save(department);
  }

  @Override
  public Department findDepartmentById(Long departmentId) {
    Department department = departmentRepository.findByDepartmentId(departmentId);
    if (department == null) {
      throw new DepartmentNotFoundException("User with id " + departmentId + " does not exist in database");
    }
    return department;
  }

  @Override
  public void deleteDepartmentById(Long departmentId) {
    departmentRepository.deleteById(departmentId);
  }

  @Override
  public Department updateDepartment(Long departmentId, Department departmentData) {
    Department department = departmentRepository.findByDepartmentId(departmentId);
    if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
      department.setDepartmentName(departmentData.getDepartmentName());
    }

    if (Objects.nonNull(department.getDepartmentAddress()) && !"".equalsIgnoreCase(department.getDepartmentAddress())) {
      department.setDepartmentAddress(departmentData.getDepartmentAddress());
    }

    if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
      department.setDepartmentCode(departmentData.getDepartmentCode());
    }

    return departmentRepository.save(department);
  }
}
