package com.agenda.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContatoDTO {
    private Integer id;
    private String nome;
    private String email;
    private boolean favorito;
}
