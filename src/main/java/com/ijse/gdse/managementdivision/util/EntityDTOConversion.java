package com.ijse.gdse.managementdivision.util;

import com.ijse.gdse.managementdivision.dto.ProjectDTO;
import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.Project;
import com.ijse.gdse.managementdivision.entity.TechLead;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Component
public class EntityDTOConversion {
private final ModelMapper modelMapper;

    public EntityDTOConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public TechLead getTLEntity(TechLeadDTO dto){return modelMapper.map(dto, TechLead.class);}

    public TechLeadDTO getTlDTO(TechLead entity){
        return modelMapper.map(entity, TechLeadDTO.class);
    }

    public Project getProjectEntity(ProjectDTO dto){return modelMapper.map(dto, Project.class);}
    public ProjectDTO getProjectDTO(Project entity){return modelMapper.map(entity, ProjectDTO.class);}
}
