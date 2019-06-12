package com.irrigation.rest.controller;

import com.irrigation.model.dto.ArduinoDTO;
import com.irrigation.rest.service.ArduinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/arduino")
public class ArduinoController {

    @Autowired
    ArduinoService service;

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> activeArduino(@Valid @RequestBody ArduinoDTO arduinoDTO, BindingResult result) {
        service.sendSignal(arduinoDTO);
        return ResponseEntity.ok(null);
    }
}
