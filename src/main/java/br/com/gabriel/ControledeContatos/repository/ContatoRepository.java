package br.com.gabriel.ControledeContatos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gabriel.ControledeContatos.model.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
