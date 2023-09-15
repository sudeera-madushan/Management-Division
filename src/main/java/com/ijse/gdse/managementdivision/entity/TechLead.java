package com.ijse.gdse.managementdivision.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Entity(name = "TechLead")
public class TechLead implements SuperEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private Double salary;
    @Column(nullable = false,columnDefinition = "Text")
    private String profile;
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
    private List<Project> projectList;

    public TechLead(String name, int age, Double salary, String profile, List<Project> projectList) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.profile = profile;
        this.projectList = projectList;
    }

    public TechLead(int id) {
        this.id = id;
    }

    public TechLead() {
    }

    public TechLead(int id, String name, int age, Double salary, String profile, List<Project> projectList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.profile = profile;
        this.projectList = projectList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
