package com.example.sbnz.controllers;

import com.example.sbnz.DTO.RequestDTO;
import com.example.sbnz.DTO.ResponseDTO;
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
    @GetMapping("rules")
    public ResponseEntity<?> aplyRules(@RequestBody RequestDTO requestDTO)
    {
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("a", "b", "c", "d", "e", 5, 4, 3, 2, 1), HttpStatus.OK);
    }
}
