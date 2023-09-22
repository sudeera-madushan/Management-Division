package com.ijse.gdse.managementdivision.api;

import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.Project;
import com.ijse.gdse.managementdivision.exception.InvalidException;
import com.ijse.gdse.managementdivision.repository.TechLeadRepo;
import com.ijse.gdse.managementdivision.service.TechLeadService;
import com.ijse.gdse.managementdivision.util.EntityDTOConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@RestController
@RequestMapping("api/v1/tl")
public class TechLeadController {

    @Autowired
    TechLeadService tlService;

    @DeleteMapping("{id}")
    String deleteTechLead(@PathVariable String id){
        tlService.deleteTechLead(Integer.parseInt(id));
        return "Deleted "+id+"  !";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    TechLeadDTO saveTechLead(
            @RequestPart String name,
            @RequestPart String age,
            @RequestPart String salary,
           @RequestPart byte [] profile
    ){
        if(name == null || !name.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (age== null) {
            throw new InvalidException("Invalid Age");
        } else if (salary == null) {
            throw new InvalidException("Invalid Salary");
        } else if (profile== null) {
            throw new InvalidException("Invalid Profile");
        }
        return tlService.saveTechLead(new TechLeadDTO(name,
                Integer.parseInt(age),
                Double.parseDouble(salary),
                Base64.getEncoder().encodeToString(profile),
                null));
    }
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String updateTechLead(
            @RequestPart String id,
            @RequestPart String name,
            @RequestPart String age,
            @RequestPart String salary,
           @RequestPart byte [] profile
    ){
        if(id == null){
            throw new InvalidException("Invalid ID");
        }else if(name == null || !name.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (age== null) {
            throw new InvalidException("Invalid Age");
        } else if (salary == null) {
            throw new InvalidException("Invalid Salary");
        } else if (profile== null) {
            throw new InvalidException("Invalid Profile");
        }
        tlService.updateTechLead(new TechLeadDTO(
                Integer.parseInt(id),
                name,
                Integer.parseInt(age),
                Double.parseDouble(salary),
                Base64.getEncoder().encodeToString(profile),
                null));
        return "Updated "+id+"  !";
    }
    @GetMapping("{id}")
    TechLeadDTO getTechLead(@PathVariable String id){
        return tlService.getTLByID(Integer.parseInt(id));
    }
}
