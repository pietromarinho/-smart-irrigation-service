package com.irrigation.Utils;

import com.irrigation.model.dto.ArduinoDTO;
import com.irrigation.model.dto.PlantacaoDTO;
import com.irrigation.rest.service.ArduinoService;
import com.irrigation.rest.service.PlantacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Component
@EnableScheduling
@Transactional
public class ScheduleActivation {

    @Autowired
    PlantacaoService service;

    @Autowired
    ArduinoService arduinoService;

    private PlantacaoDTO plantacao;

    @Scheduled(fixedDelay = 2000, initialDelay = 2000)
    public void verifyTimeToActivate() {

        plantacao = service.findOne(Long.valueOf(1));

        if (plantacao != null) {
            if (plantacao.getInterval() > 0) {

                LocalDateTime dateNow = LocalDateTime.now();
                LocalDateTime endTime = plantacao.getActivationTime().plusSeconds(5);

                if (dateNow.isAfter(plantacao.getActivationTime()) && dateNow.isBefore(endTime)) {
                    playBomb();
                } else if (dateNow.isAfter(endTime)) {
                    stopBomb();
                }
            }
        }
    }

    private void stopBomb() {
        ArduinoDTO dto = new ArduinoDTO();
        dto.setAtivar(false);
        dto.setIp(plantacao.getIp());

        arduinoService.sendSignal(dto);

        LocalDateTime newTime = LocalDateTime.now().plusMinutes(plantacao.getInterval());
        plantacao.setActivationTime(newTime);

        service.save(plantacao);
    }

    private void playBomb() {
        ArduinoDTO dto = new ArduinoDTO();
        dto.setAtivar(true);
        dto.setIp(plantacao.getIp());

        arduinoService.sendSignal(dto);
    }
}
