package com.ijse.gdse.managementdivision.service.util;

import com.ijse.gdse.managementdivision.dto.ProjectDTO;
import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.Project;
import com.ijse.gdse.managementdivision.exception.NotFoundException;
import com.ijse.gdse.managementdivision.repository.ProjectRepo;
import com.ijse.gdse.managementdivision.service.ProjectService;
import com.ijse.gdse.managementdivision.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.Optional;

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
        if(!projectRepo.existsById(prID)) throw new NotFoundException("Project Not Found");
        projectRepo.deleteById(prID);
    }

    @Override
    public void updateProject(ProjectDTO dto) throws ClassNotFoundException {
        Optional<Project> byId = projectRepo.findById(dto.getId());
        if (!byId.isPresent()) throw new ClassNotFoundException();
        byId.get().setName(dto.getName());
        byId.get().setCost(dto.getCost());
        byId.get().setDate(dto.getDate());

    }

    @Override
    public ProjectDTO getProjectByID(int prID) {
        if(!projectRepo.existsById(prID)) throw new NotFoundException("Project Not Found");
        Project project = projectRepo.findProjectById(prID);
//        project.setTechLead(null);
        return conversion.getProjectDTO(project);
    }
}
