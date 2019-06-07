package com.irrigation.rest.controller;

import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.rest.service.PlantacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/plantacao")
public class PlantacaoController {
    @Autowired
    private PlantacaoService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<PlantacaoDTO> findOne(@PathVariable("id") Long id) {
        PlantacaoDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<PlantacaoDTO>> findAll() {
        Collection<PlantacaoDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody PlantacaoDTO plantacaoDTO, BindingResult result) {

        return getResponseEntity(plantacaoDTO, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody PlantacaoDTO plantacaoDTO, BindingResult result) {

        return getResponseEntity(plantacaoDTO, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid PlantacaoDTO plantacaoDTO, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        PlantacaoDTO response = this.service.save(plantacaoDTO);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
