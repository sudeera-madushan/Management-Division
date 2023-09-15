package com.ijse.gdse.managementdivision.dto;

import com.ijse.gdse.managementdivision.entity.TechLead;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */

public class ProjectDTO {
    int id;
    String name;
    double cost;
    Date date;
    private TechLead techLead;

    public ProjectDTO(String name, double cost, Date date, TechLead techLead) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.techLead = techLead;
    }

    public ProjectDTO(int id, String name, double cost, Date date, TechLead techLead) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.techLead = techLead;
    }

    public ProjectDTO() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public TechLead getTechLead() {
        return techLead;
    }

    public void setTechLead(TechLead techLead) {
        this.techLead = techLead;
    }
}
