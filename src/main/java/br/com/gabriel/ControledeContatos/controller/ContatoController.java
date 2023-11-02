package br.com.gabriel.ControledeContatos.controller;

import br.com.gabriel.ControledeContatos.model.Contato;
import br.com.gabriel.ControledeContatos.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas/{pessoaId}/contatos")
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @PostMapping
    public ResponseEntity<Contato> adicionarContato(@PathVariable Long pessoaId, @RequestBody Contato contato) {
        Contato novoContato = contatoService.adicionarContato(pessoaId, contato);
        return new ResponseEntity<>(novoContato, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getContatoPorId(@PathVariable Long id) {
        Contato contato = contatoService.getContatoPorId(id);
        return new ResponseEntity<>(contato, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Contato>> listarContatosDePessoa(@PathVariable Long pessoaId) {
        List<Contato> contatos = contatoService.listarContatosDePessoa(pessoaId);
        return new ResponseEntity<>(contatos, HttpStatus.OK);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarContato(@PathVariable Long id) {
        contatoService.deletarContato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}