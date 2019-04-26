package com.smart_irrigation.rest.controllers;

import com.smart_irrigation.rest.dtos.PlantDto;
import com.smart_irrigation.rest.services.PlantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/plant")
public class PlantController {

    @Autowired
    private PlantService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PlantDto> findOne(@PathVariable("id") Long id) {
        PlantDto response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<PlantDto>> findAll() {
        Collection<PlantDto> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody PlantDto plantDto, BindingResult result) {

        return getResponseEntity(plantDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody PlantDto plantDto, BindingResult result) {

        return getResponseEntity(plantDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid PlantDto plantDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        PlantDto response = this.service.save(plantDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }

}
