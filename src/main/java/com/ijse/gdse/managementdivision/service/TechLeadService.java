package com.ijse.gdse.managementdivision.service;

import com.ijse.gdse.managementdivision.dto.TechLeadDTO;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
public interface TechLeadService {
    TechLeadDTO saveTechLead (TechLeadDTO techLeadDTO);
    void deleteTechLead (int tlID);
    void updateTechLead (TechLeadDTO techLeadDTO);
    TechLeadDTO getTLByID (int tlID);
}
