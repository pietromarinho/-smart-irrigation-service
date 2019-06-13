package com.irrigation.rest.service;

import com.irrigation.model.dto.ArduinoDTO;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Service
public class ArduinoService {

    public void sendSignal(ArduinoDTO arduinoDTO) {
        try {
            String urlText;
            URL url;

            if (arduinoDTO.getIp() == null) {
                urlText = "http://" + "192.168.43.83";
            } else {
                urlText = "http://" + arduinoDTO.getIp();
            }

            if (arduinoDTO.getAtivar()) {
                urlText += "/led1on";
            } else {
                urlText += "/led1off";
            }

            url = new URL(urlText);
            URLConnection connection;
            connection = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
