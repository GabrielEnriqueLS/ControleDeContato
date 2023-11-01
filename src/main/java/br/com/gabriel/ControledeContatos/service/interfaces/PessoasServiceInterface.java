package br.com.gabriel.ControledeContatos.service.interfaces;

import java.util.List;
import java.util.Optional;


import br.com.gabriel.ControledeContatos.model.Pessoa;
public interface PessoasInterfaces {

    Pessoa save(Pessoa pessoa);
    Optional<Pessoa> getById(Long id);
    List<Pessoa> getAll();
    Pessoa update(Pessoa estoque);
    void delete(Long id);
    Pessoa addQuantidade(Long id, int quantidade);
    Pessoa delQuantidade(Long id, int quantidade);
}
