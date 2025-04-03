package com.crve.crve.Controller;

import com.crve.crve.Controller.EmploeyController;
import com.crve.crve.Model.EmploeyModel;
import com.crve.crve.DTO.EmployeDto;
import jakarta.validation.Valid;
import com.crve.crve.Repository.EmployeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/employe")



public class EmploeyController {
    @PostMapping
    public ResponseEntity<EmploeyModel> saveEmploey(@RequestBody @Valid EmployeDto) {
        var EmployedModel = new EmploeyModel();
        BeanUtils.copyProperties(EmployeDto, EmployeDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(EmployeRepository).save(EmployedModel));
    }

    @GetMapping

    public ResponseEntity<EmploeyModel> getAllEmploye(){
        return ResponseEntity.status(HttpStatus.OK).body(EmployeRepository.findAll());
    }
}
