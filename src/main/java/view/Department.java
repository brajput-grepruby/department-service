package view;

import java.util.ArrayList;
import java.util.List;

public class Department {
  private Long id;
  private String name;

  private List<Employee> employees = new ArrayList<Employee>();

  public Department(Long id, String name, List<Employee> employees) {
    this.id = id;
    this.name = name;
    this.employees = employees;
  }

  public List<Employee> getEmployees() {
    return employees;
  }

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmployees(List<Employee> employees) {
    this.employees = employees;
  }

  @Override
  public String toString() {
    return "Department{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", employees=" + employees +
            '}';
  }
}
