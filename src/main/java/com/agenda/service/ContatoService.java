package com.agenda.service;

import com.agenda.model.entity.Contato;
import com.agenda.rest.dto.ContatoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.servlet.http.Part;


public interface ContatoService {
    Contato salvar(ContatoDTO dto);

    Page<Contato> listarTodos(PageRequest pageRequest);

    void deletarPorId(Integer id);

    void favoritar(Integer id);

    byte[] adicionarFoto(Integer id, Part arquivo);
}
