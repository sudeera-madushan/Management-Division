package com.ijse.gdse.managementdivision.api;

import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.Project;
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
        return tlService.saveTechLead(new TechLeadDTO(name,
                Integer.parseInt(age),
                Double.parseDouble(salary),
                Base64.getEncoder().encodeToString(profile),
                null));
    }
    @PutMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String updateTechLead(
            @RequestPart String id,
            @RequestPart String name,
            @RequestPart String age,
            @RequestPart String salary,
           @RequestPart byte [] profile
    ){
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
