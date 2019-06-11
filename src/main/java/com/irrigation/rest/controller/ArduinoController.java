package com.irrigation.rest.controller;

import com.irrigation.model.dto.ArduinoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@RestController
@RequestMapping("/rest/arduino")
public class ArduinoController {

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<?> save(@Valid @RequestBody ArduinoDTO arduinoDTO, BindingResult result) {

        try {
            URL url = new URL(arduinoDTO.getIp());
            URLConnection conection;
            conection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conection.getInputStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
