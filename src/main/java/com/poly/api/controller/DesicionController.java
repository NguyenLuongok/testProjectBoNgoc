package com.poly.api.controller;

import com.poly.api.dto.DesicionDto;
import com.poly.api.entities.Desicion;
import com.poly.api.service.DesicionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/desicion")
public class DesicionController {


    @Autowired
    private DesicionService desicionService;

    @GetMapping
    public ResponseEntity<List<DesicionDto>> getAll(){
        List<DesicionDto> desicionDtos = desicionService.findAll();
        return new ResponseEntity<>(desicionDtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DesicionDto> getById(@PathVariable int id){
        return new ResponseEntity<>(desicionService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DesicionDto> save(@RequestBody DesicionDto desicionDto){
        return new ResponseEntity<>(desicionService.save(desicionDto),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<DesicionDto> update(@RequestBody DesicionDto desicionDto){
        return new ResponseEntity<>(desicionService.update(desicionDto),HttpStatus.OK);
    }
}
