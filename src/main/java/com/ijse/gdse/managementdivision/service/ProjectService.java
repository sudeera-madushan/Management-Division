package com.ijse.gdse.managementdivision.service;

import com.ijse.gdse.managementdivision.dto.ProjectDTO;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
public interface ProjectService {
    ProjectDTO saveProject (ProjectDTO projectDTO);
    void deleteProject (int prID);
    void updateProject (ProjectDTO projectDTO);
    ProjectDTO getProjectByID (int tlID);
}
