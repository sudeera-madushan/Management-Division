package com.ijse.gdse.managementdivision.service.util;

import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.TechLead;
import com.ijse.gdse.managementdivision.exception.NotFoundException;
import com.ijse.gdse.managementdivision.repository.TechLeadRepo;
import com.ijse.gdse.managementdivision.service.TechLeadService;
import com.ijse.gdse.managementdivision.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@Service
@Transactional
public class TechLeadServiceIMPL implements TechLeadService {

    @Autowired
    TechLeadRepo techLeadRepo;

    @Autowired
    EntityDTOConversion conversion;
    @Override
    public TechLeadDTO saveTechLead(TechLeadDTO techLeadDTO) {
        return conversion.getTlDTO(techLeadRepo.save(conversion.getTLEntity(techLeadDTO)));
    }

    @Override
    public void deleteTechLead(int tlID) {
        if(!techLeadRepo.existsById(tlID)) throw new NotFoundException("Tech Lead Not Found");
        techLeadRepo.deleteById(tlID);
    }

    @Override
    public void updateTechLead(TechLeadDTO techLeadDTO) {
        Optional<TechLead> techLead = techLeadRepo.findById(techLeadDTO.getId());
        if (!techLead.isPresent())throw new NotFoundException("Tech Lead not found");
        techLead.get().setName(techLeadDTO.getName());
        techLead.get().setAge(techLeadDTO.getAge());
        techLead.get().setSalary(techLeadDTO.getSalary());
        techLead.get().setProfile(techLeadDTO.getProfile());
    }

    @Override
    public TechLeadDTO getTLByID(int tlID) {
        if(!techLeadRepo.existsById(tlID)) throw new NotFoundException("Tech Lead Not Found");
        return conversion.getTlDTO(techLeadRepo.findTechLeadById(tlID));
    }
}
