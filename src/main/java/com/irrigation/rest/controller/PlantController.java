package com.irrigation.rest.controller;

import com.irrigation.model.dto.PlantDTO;
import com.irrigation.rest.service.PlantService;
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
    public ResponseEntity<PlantDTO> findOne(@PathVariable("id") Long id) {
        PlantDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<PlantDTO>> findAll() {
        Collection<PlantDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody PlantDTO plantDto, BindingResult result) {

        return getResponseEntity(plantDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody PlantDTO plantDto, BindingResult result) {

        return getResponseEntity(plantDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid PlantDTO plantDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        PlantDTO response = this.service.save(plantDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
