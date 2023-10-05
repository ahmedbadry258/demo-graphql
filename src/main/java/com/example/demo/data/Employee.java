package com.example.demo.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "EMPS")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
//    @Basic
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "EMPLOYEE_ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;



    @Column(name = "JOB_ID")
    private String job;

    public Employee() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
