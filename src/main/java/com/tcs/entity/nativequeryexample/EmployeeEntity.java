package com.tcs.entity.nativequeryexample;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity(name="EmployeeEntityNative")
@Table (name="employeenative")
 
@NamedNativeQueries({
        @NamedNativeQuery(
                name    =   "getAllEmployees",
                query   =   "SELECT id, firstName, lastName, email, department.id, department.name " +
                            "FROM employee, department",
                            resultClass=EmployeeEntity.class
        ),
        @NamedNativeQuery(
                name    =   "getAllEmployeesByDeptId",
                query   =   "SELECT id, firstName, lastName, email, department.id, department.name " +
                            "FROM employee, department " + 
                            "WHERE department.id = ?",
                            resultClass=EmployeeEntity.class
        )
})
 
public class EmployeeEntity implements Serializable
{
    private static final long serialVersionUID = 1L;
  
    @Id
    @GeneratedValue
    private Integer id;
      
    private String firstName;
    private String lastName;
    private String email;
      
    @ManyToOne
    private DepartmentEntity department;
      
    public EmployeeEntity() {}
       
    public EmployeeEntity(String name, DepartmentEntity department) {
        this.firstName = name;
        this.department = department;
    }
       
    public EmployeeEntity(String name) {
        this.firstName = name;
    }
  
    //Setters and Getters
 
    @Override
    public String toString() {
        return "EmployeeVO [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", email=" + email
                + ", department=" + department + "]";
    }
}
