package com.agenda.service.impl;

import com.agenda.model.entity.Contato;
import com.agenda.model.repository.ContatoRepository;
import com.agenda.rest.dto.ContatoDTO;
import com.agenda.service.ContatoService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;


@Service
public class ContatoServiceImpl implements ContatoService {

    @Autowired
    private ContatoRepository repository;

    @Override
    public Contato salvar(ContatoDTO dto) {
        return repository.save(new Contato(dto));
    }

    @Override
    public Page<Contato> listarTodos(PageRequest pageRequest) {
        return repository.findAll(pageRequest);
    }

    @Override
    public void deletarPorId(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void favoritar(Integer id) {
        Optional<Contato> contato = repository.findById(id);
        contato.ifPresent(c -> {
            c.setFavorito(!c.isFavorito());
            repository.save(c);
        });
    }

    @Override
    public byte[] adicionarFoto(Integer id, Part arquivo) {
        Optional<Contato> contato = repository.findById(id);
        return contato.map(c -> {
            try {
                InputStream is = arquivo.getInputStream();
                byte[] bytes = new byte[(int) arquivo.getSize()];
                IOUtils.readFully(is, bytes);
                c.setFoto(bytes);
                repository.save(c);
                is.close();
                return bytes;
            } catch (IOException ex) {
                return null;
            }
        }).orElse(null);
    }
}
