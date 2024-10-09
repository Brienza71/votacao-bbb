package com.dio.coding.votacao_bbb.repository;

import com.dio.coding.votacao_bbb.model.VotacaoModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VotacaoRepository extends MongoRepository<VotacaoModel, String> {
}
