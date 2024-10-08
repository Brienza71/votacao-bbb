package com.dio.coding.votacao_bbb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("participante")
public class ParticipanteModel {

    @Id
    private String id;
    private String nome;
}
