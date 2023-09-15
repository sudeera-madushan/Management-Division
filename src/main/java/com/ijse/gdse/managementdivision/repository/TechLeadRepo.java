package com.ijse.gdse.managementdivision.repository;

import com.ijse.gdse.managementdivision.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Repository
public interface TechLeadRepo extends JpaRepository<TechLead,Integer> {

        TechLead save(TechLead techLead);
        TechLead findTechLeadById(Integer id);

        void deleteById(Integer id);
//        TechLead updateTechLeadB(Integer id,TechLead techLead);
}
