package com.training.department_service.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.*;

import com.training.department_service.entity.Department;

import com.training.department_service.service.DepartmentService;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/department")
@Slf4j
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping("/")
  public List<Department> findAllDepartment() {
    return departmentService.findAllDepartment();
  }

  @PostMapping("/")
  public Department saveDepartment(@RequestBody Department department) {
//    log.info
    return departmentService.saveDepartment(department);
  }

  @GetMapping("/{id}")
  public Department findDepartmentById(@PathVariable("id") Long departmentId) {
    return departmentService.findDepartmentById(departmentId);
  }

  @DeleteMapping("/{id}")
  public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
    departmentService.deleteDepartmentById(departmentId);
    return "Department deleted";
  }

  @PutMapping("/{id}")
  public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department) {
//    Department updatedDepartment = departmentService.saveDepartment(departmentId);
//    Department department1 = departmentService.findDepartmentById(departmentId);

    return departmentService.updateDepartment(departmentId, department);
  }
}


