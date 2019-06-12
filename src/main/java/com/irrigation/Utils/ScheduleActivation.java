package com.irrigation.Utils;

import com.irrigation.model.dto.ArduinoDTO;
import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.rest.service.ArduinoService;
import com.irrigation.rest.service.PlantacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduleActivation {

    @Autowired
    PlantacaoService service;

    @Autowired
    ArduinoService arduinoService;

    private PlantacaoDTO plantacao = null;
    private LocalDateTime endTime = LocalDateTime.now();

    @Scheduled(fixedDelay = 1000)
    public void verifyTimeToActivate() {

        if (plantacao == null) {
            plantacao = service.findOne(Long.valueOf(1));

            if (plantacao == null) {
                return;
            }
        }

        LocalDateTime dateNow = LocalDateTime.now();

        if (dateNow.isAfter(endTime)) {
            stopBomb();
        }

        if (plantacao != null) {
            if (plantacao.getActivationTime().isAfter(dateNow)) {
                ArduinoDTO dto = new ArduinoDTO();
                dto.setAtivar(true);
                dto.setIp(plantacao.getIp());
                arduinoService.sendSignal(dto);

                endTime = LocalDateTime.now();
                endTime.plusSeconds(6);
            }
        }
    }

    private void stopBomb() {
        ArduinoDTO dto = new ArduinoDTO();
        dto.setAtivar(false);
        dto.setIp(plantacao.getIp());
        arduinoService.sendSignal(dto);

        LocalDateTime newTime = LocalDateTime.now();
        newTime.plusMinutes(plantacao.getInterval());
        plantacao.setActivationTime(newTime);

        service.save(plantacao);
    }
}
