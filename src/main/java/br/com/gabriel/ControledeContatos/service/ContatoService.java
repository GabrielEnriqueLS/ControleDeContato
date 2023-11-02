package br.com.gabriel.ControledeContatos.service;

import java.util.List;
import br.com.gabriel.ControledeContatos.model.Contato;
import br.com.gabriel.ControledeContatos.model.Pessoa;
import br.com.gabriel.ControledeContatos.repository.ContatoRepository;
import br.com.gabriel.ControledeContatos.repository.PessoaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    public Contato adicionarContato(Long pessoaId, Contato contato) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + pessoaId));
        contato.setPessoa(pessoa);
        return contatoRepository.save(contato);
    }

    public Contato obterContatoPorId(Long id) {
        return contatoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado com o ID: " + id));
    }

    public List<Contato> listarContatosDeUmaPessoa(Long pessoaId) {
        Pessoa pessoa = pessoaRepository.findById(pessoaId)
                .orElseThrow(() -> new EntityNotFoundException("Pessoa não encontrada com o ID: " + pessoaId));
        return pessoa.getContatos();
    }


    public void deletarContato(Long id) {
        Contato contato = obterContatoPorId(id);
        contatoRepository.delete(contato);
    }

    public Contato getContatoPorId(Long id) {
        return getContatoPorId(id);
    }

    public List<Contato> listarContatosDePessoa(Long pessoaId) {
        return null;
    }
}
