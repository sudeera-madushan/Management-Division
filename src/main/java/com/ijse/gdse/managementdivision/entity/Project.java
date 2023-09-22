package com.ijse.gdse.managementdivision.entity;

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

@Entity(name = "Project")
public class Project implements SuperEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    double cost;
    @Column(nullable = false)
    Date date;
    @ManyToOne
    @JoinColumn(name = "techLead_id", referencedColumnName = "id")
    private TechLead techLead;

    public Project(String name, double cost, Date date, TechLead techLead) {
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.techLead = techLead;
    }

    public Project(int id, String name, double cost, Date date, TechLead techLead) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.date = date;
        this.techLead = techLead;
    }

    public Project() {
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

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                ", techLead=" + techLead +
                '}';
    }
}
