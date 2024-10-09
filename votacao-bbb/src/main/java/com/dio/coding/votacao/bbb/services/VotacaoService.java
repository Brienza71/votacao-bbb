package com.dio.coding.votacao.bbb.services;

import com.dio.coding.votacao.bbb.model.ParticipanteModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotacaoService {

    private static final String TOPICO_VOTACAO = "votacao";

    private final KafkaTemplate<Object, Object> template;

    public void adicionalEventos(ParticipanteModel participante){
        template.send(TOPICO_VOTACAO, participante);
    }

}
