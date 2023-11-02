package br.com.gabriel.ControledeContatos.service;

import br.com.gabriel.ControledeContatos.model.Pessoa;
import br.com.gabriel.ControledeContatos.model.PessoaDTO;
import br.com.gabriel.ControledeContatos.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criarPessoa(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }

    public Pessoa obterPessoaPorId(Long id) {
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + id));
    }

    public PessoaDTO obterPessoaParaMalaDireta(Long id) {
        Pessoa pessoa = obterPessoaPorId(id);
        String enderecoCompleto = pessoa.getEndereco() + " - CEP: " + pessoa.getCep() + " - " + pessoa.getCidade() + "/" + pessoa.getUf();
        return new PessoaDTO(pessoa.getId(), pessoa.getNome(), enderecoCompleto);
    }

    public List<Pessoa> listarTodasAsPessoas() {
        return pessoaRepository.findAll();
    }

    public Pessoa atualizarPessoa(Long id, Pessoa pessoa) {
        Pessoa pessoaExistente = obterPessoaPorId(id);
        pessoaExistente.setNome(pessoa.getNome());
        pessoaExistente.setEndereco(pessoa.getEndereco());
        return pessoaRepository.save(pessoaExistente);
    }

    public void deletarPessoa(Long id) {
        Pessoa pessoa = obterPessoaPorId(id);
        pessoaRepository.delete(pessoa);
    }
}
