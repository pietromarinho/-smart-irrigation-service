package com.irrigation.rest.controller;

import com.irrigation.model.dto.CategoryDTO;
import com.irrigation.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/rest/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<CategoryDTO> findOne(@PathVariable("id") Long id) {
        CategoryDTO response = this.service.findOne(id);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<Collection<CategoryDTO>> findAll() {
        Collection<CategoryDTO> response = this.service.findAll();

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody CategoryDTO categoryDto, BindingResult result) {

        return getResponseEntity(categoryDto, result);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/")
    public ResponseEntity<?> update(@Valid @RequestBody CategoryDTO categoryDto, BindingResult result) {

        return getResponseEntity(categoryDto, result);
    }

    private ResponseEntity<?> getResponseEntity(@RequestBody @Valid CategoryDTO categoryDto, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errors = new ArrayList<>();
            result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        CategoryDTO response = this.service.save(categoryDto);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        this.service.delete(id);
        return ResponseEntity.ok(null);
    }
}
