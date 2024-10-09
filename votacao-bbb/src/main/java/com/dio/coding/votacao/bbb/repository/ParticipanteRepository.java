package com.dio.coding.votacao.bbb.repository;

import com.dio.coding.votacao.bbb.model.ParticipanteModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipanteRepository extends MongoRepository<ParticipanteModel, String> {
}
