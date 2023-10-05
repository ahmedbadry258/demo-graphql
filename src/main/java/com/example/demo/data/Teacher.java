package com.example.demo.data;

import javax.persistence.*;

@Entity
@Table(name = "TEACHERS")
public class Teacher {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Basic
    private Long id;

    private String name;

    private String active;

    public Teacher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
}
