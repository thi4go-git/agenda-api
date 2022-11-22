package com.agenda.model.entity;

import com.agenda.rest.dto.ContatoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String nome;

    @Column
    private String email;

    @Column
    private boolean favorito;


    @Column
    @Lob
    private byte[] foto;


    public Contato(ContatoDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
        this.favorito = dto.isFavorito();
    }
}
