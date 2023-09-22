package com.ijse.gdse.managementdivision.api;

import com.ijse.gdse.managementdivision.dto.ProjectDTO;
import com.ijse.gdse.managementdivision.dto.TechLeadDTO;
import com.ijse.gdse.managementdivision.entity.TechLead;
import com.ijse.gdse.managementdivision.exception.InvalidException;
import com.ijse.gdse.managementdivision.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;

/**
 * author : Sudeera Madushan
 * date : 9/15/2023
 * project : ManagementDivision
 */
@RestController
@RequestMapping("api/v1/project")
public class ProjectController {
    @Autowired
    ProjectService projectService;

    @DeleteMapping("{id}")
    String deleteProject(@PathVariable String id){
        projectService.deleteProject(Integer.parseInt(id));
        return "Deleted "+id+"  !";
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    ProjectDTO saveProject(
            @RequestPart String name,
            @RequestPart String cost,
            @RequestPart String date,
            @RequestPart String tlId
    ){
        System.out.println(name+cost+date+tlId);
        if(name == null || !name.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (cost== null) {
            throw new InvalidException("Invalid Cost");
        } else if (date == null) {
            throw new InvalidException("Invalid Date");
        } else if (tlId== null) {
            throw new InvalidException("Invalid Tech Lead ID");
        }
        String[] split = date.split("-");
        return projectService.saveProject(new ProjectDTO(name,
                Double.parseDouble(cost),
                Date.valueOf(LocalDate.of(Integer.parseInt(split[0]),Integer.parseInt(split[1]),Integer.parseInt(split[2]))),
                new TechLead(Integer.parseInt(tlId))));
    }
    @PatchMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String updateProject(
            @RequestPart String id,
            @RequestPart String name,
            @RequestPart String cost,
            @RequestPart String date,
            @RequestPart String tlId
    ) throws ClassNotFoundException {
        if(id == null){
            throw new InvalidException("Invalid ID");
        }else if(name == null || !name.matches("[A-Za-z ]+")){
            throw new InvalidException("Invalid Name");
        } else if (cost== null) {
            throw new InvalidException("Invalid Cost");
        } else if (date == null) {
            throw new InvalidException("Invalid Date");
        } else if (tlId== null) {
            throw new InvalidException("Invalid Tech Lead ID");
        }

        projectService.updateProject(new ProjectDTO(Integer.parseInt(id),
                name,
                Double.parseDouble(cost),
                Date.valueOf(date),
                new TechLead(Integer.parseInt(tlId))));
        return "Updated "+id+"  !";
    }
    @GetMapping("{id}")
    ProjectDTO getProject(@PathVariable String id){
        return projectService.getProjectByID(Integer.parseInt(id));
    }
}
