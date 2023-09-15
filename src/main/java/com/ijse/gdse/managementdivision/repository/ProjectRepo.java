package com.ijse.gdse.managementdivision.repository;

import com.ijse.gdse.managementdivision.entity.Project;
import com.ijse.gdse.managementdivision.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Repository
public interface ProjectRepo extends JpaRepository<Project,Integer> {
    Project save(Project project);
    Project findProjectById(Integer id);

    void deleteById(Integer id);
//    Project update(Integer id,Project techLead);
}
