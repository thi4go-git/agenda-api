package com.agenda.rest.controller;

import com.agenda.model.entity.Contato;
import com.agenda.rest.dto.ContatoDTO;
import com.agenda.service.impl.ContatoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Part;
import java.util.List;

@RestController
@RequestMapping("api/contatos")
@CrossOrigin("http://localhost:4200/")
public class ContatoController {

    @Autowired
    private ContatoServiceImpl service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Contato salvar(@RequestBody ContatoDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping()
    public Page<Contato> listarTodos(
            @RequestParam(value = "page", defaultValue = "0") Integer pagina,
            @RequestParam(value = "size", defaultValue = "10") Integer tamanhoPagina
    ) {
        PageRequest pageRequest = PageRequest.of(pagina, tamanhoPagina);
        return service.listarTodos(pageRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(@PathVariable Integer id) {
        service.deletarPorId(id);
    }

    @PatchMapping("{id}")
    public void favoritar(
            @PathVariable Integer id) {
        service.favoritar(id);
    }

    @PutMapping("{id}/foto")
    public byte[] adicionarFoto(@PathVariable Integer id,
                                @RequestParam("foto") Part arquivo) {
        return service.adicionarFoto(id, arquivo);
    }

}
