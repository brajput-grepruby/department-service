package repository;

import org.springframework.stereotype.Repository;
import view.Department;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {

  private List<Department> departments = new ArrayList<>();

//  Add new department
  public Department addDepartment(Department department) {
    departments.add(department);
    return department;
  }

//  Find department by ID
  public Department findById(Long id) {
    return departments.stream()
            .filter(department -> department.getId().equals(id))
            .findFirst()
            .orElseThrow();
  }

//  Get all departments
  public List<Department> findAll(){
    return departments;
  }


}
