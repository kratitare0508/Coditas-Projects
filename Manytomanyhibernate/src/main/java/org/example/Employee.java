package org.example;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Employee {

   @Id
   private int empid;
    private String employeename;

    @ManyToMany
    private List<Project> projects;

    public Employee(int empid, String employeename, List<Project> projects) {
        this.empid = empid;
        this.employeename = employeename;
        this.projects = projects;
    }
  public Employee()
  {
      super();
  }
    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
