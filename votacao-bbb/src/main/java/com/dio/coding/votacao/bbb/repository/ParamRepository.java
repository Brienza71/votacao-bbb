package com.dio.coding.votacao.bbb.repository;

import com.dio.coding.votacao.bbb.model.ParamModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParamRepository extends MongoRepository<ParamModel, String> {
}
