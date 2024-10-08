package com.dio.coding.votacao_bbb.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import com.dio.coding.votacao_bbb.model.ParticipanteModel;
import com.dio.coding.votacao_bbb.model.VotacaoModel;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.dio.coding.votacao_bbb.repository.VotacaoRepository;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

    private final VotacaoRepository repository;

    @KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro ){

        String participanteStr = registro.value();
        log.info("Voto recebido = {}", participanteStr);

        ObjectMapper mapper = new ObjectMapper();
        ParticipanteModel participante = null;

        try {
            participante = mapper.readValue(participanteStr, ParticipanteModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}]", participanteStr, ex);
            return;
        }

        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entity = repository.save(votacao);

        log.info("Voto registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDataHora());
    }
}
