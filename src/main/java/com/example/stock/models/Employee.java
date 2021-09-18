package com.example.stock.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    private Long employeeId;

    private String firstname, lastname, rank;

    @OneToMany(mappedBy ="employee", cascade = CascadeType.ALL)
    private List<Purshase> purshase = new ArrayList<>();

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public List<Purshase> getPurshase() {
        return purshase;
    }

    public void setPurshase(List<Purshase> purshase) {
        this.purshase = purshase;
    }

    public Employee() {
    }

    public Employee(String firstname, String lastname, String rank, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.rank = rank;
    }
}
