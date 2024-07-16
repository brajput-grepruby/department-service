package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.DepartmentRepository;
import view.Department;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  private static final Logger LOGGER
          = LoggerFactory.getLogger(DepartmentController.class);

  @Autowired
  private DepartmentRepository repository;

  @PostMapping("/")
  public Department add(@RequestBody Department department) {
    LOGGER.info("Department add: {}", department);
    return repository.addDepartment(department);
  }

  @GetMapping("/")
  public List<Department> findALl() {
    LOGGER.info("Fetching all departments");
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Department findById(@PathVariable Long id) {
    LOGGER.info("Fetching department by id: {}", id);
    return repository.findById(id);
  }
}
