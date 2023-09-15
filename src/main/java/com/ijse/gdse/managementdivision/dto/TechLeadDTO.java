package com.ijse.gdse.managementdivision.dto;

import com.ijse.gdse.managementdivision.entity.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
public class TechLeadDTO {
    private int id;
    private String name;
    private int age;
    private Double salary;
    private String profile;
    private List<Project> ordersList=new ArrayList<>();

    public TechLeadDTO(String name, int age, Double salary, String profile, List<Project> ordersList) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.profile = profile;
        this.ordersList = ordersList;
    }

    public TechLeadDTO() {
    }

    public TechLeadDTO(int id, String name, int age, Double salary, String profile, List<Project> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.profile = profile;
        this.ordersList = ordersList;
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

    public List<Project> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Project> ordersList) {
        this.ordersList = ordersList;
    }
}
