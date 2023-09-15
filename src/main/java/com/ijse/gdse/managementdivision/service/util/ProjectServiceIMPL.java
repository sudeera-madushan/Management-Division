package com.ijse.gdse.managementdivision.service.util;

import com.ijse.gdse.managementdivision.dto.ProjectDTO;
import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.repository.ProjectRepo;
import com.ijse.gdse.managementdivision.service.ProjectService;
import com.ijse.gdse.managementdivision.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Service
@Transactional
public class ProjectServiceIMPL implements ProjectService {

    @Autowired
    ProjectRepo projectRepo;
    @Autowired
    EntityDTOConversion conversion;
    @Override
    public ProjectDTO saveProject(ProjectDTO projectDTO) {
        return conversion.getProjectDTO(projectRepo.save(conversion.getProjectEntity(projectDTO)));
    }

    @Override
    public void deleteProject(int prID) {
        deleteProject(prID);
    }

    @Override
    public void updateProject(ProjectDTO projectDTO) {
//        projectRepo.update(projectDTO.getId(),conversion.getProjectEntity(projectDTO));
    }

    @Override
    public ProjectDTO getProjectByID(int tlID) {
        return conversion.getProjectDTO(projectRepo.findProjectById(tlID));
    }
}
