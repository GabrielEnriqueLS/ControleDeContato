package br.com.gabriel.ControledeContatos.controller;

import br.com.gabriel.ControledeContatos.model.Pessoa;
import br.com.gabriel.ControledeContatos.model.PessoaDTO;
import br.com.gabriel.ControledeContatos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa) {
        Pessoa novaPessoa = pessoaService.criarPessoa(pessoa);
        return new ResponseEntity<>(novaPessoa, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaPorId(@PathVariable Long id) {
        Pessoa pessoa = pessoaService.obterPessoaPorId(id);
        return new ResponseEntity<>(pessoa, HttpStatus.OK);
    }

    @GetMapping("/maladireta/{id}")
    public ResponseEntity<PessoaDTO> obterPessoaParaMaladireta(@PathVariable Long id) {
        PessoaDTO maladireta = pessoaService.obterPessoaParaMalaDireta(id);
        return new ResponseEntity<>(maladireta, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarPessoas() {
        List<Pessoa> pessoas = pessoaService.listarTodasAsPessoas();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa) {
        Pessoa pessoaAtualizada = pessoaService.atualizarPessoa(id, pessoa);
        return new ResponseEntity<>(pessoaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPessoa(@PathVariable Long id) {
        pessoaService.deletarPessoa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
