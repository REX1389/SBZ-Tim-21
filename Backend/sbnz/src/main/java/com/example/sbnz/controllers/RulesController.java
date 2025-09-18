package com.example.sbnz.controllers;

import com.example.sbnz.DTO.RequestDTO;
import com.example.sbnz.DTO.ResponseDTO;
import com.example.sbnz.service.RulesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/")
public class RulesController
{
    @Autowired
    private RulesService rulesService;

    @GetMapping("rules")
    public ResponseEntity<?> aplyRules(@RequestBody RequestDTO requestDTO)
    {
        ResponseDTO response = rulesService.applyRules(requestDTO);
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
}
