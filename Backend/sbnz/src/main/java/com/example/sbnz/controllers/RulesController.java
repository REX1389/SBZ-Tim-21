package com.example.sbnz.controllers;

import com.example.sbnz.DTO.RequestDTO;
import com.example.sbnz.DTO.ResponseDTO;
import com.example.sbnz.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
public class RulesController
{
    @Autowired
    private RulesService rulesService;

    @PostMapping ("rules")
    public ResponseEntity<?> aplyRules(@RequestBody RequestDTO requestDTO)
    {
        ResponseDTO response = rulesService.applyRules(requestDTO);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
