package br.com.gabriel.ControledeContatos.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "contato")
public class Contatos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "tipo_contato", nullable = false)
    private int tipoContato; // 0 para Telefone, 1 para Celular
    @Column(nullable = false)
    private String contato;
    @ManyToOne
    @JoinColumn(name = "relacionamento")
    private Pessoa relacionamento;


    //construtores:

    public Contatos(int tipoContato, String contato, Long id) {
        this.tipoContato = tipoContato;
        this.contato = contato;
        this.id = id;
    }

    public Contatos() {

    }

    // getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTipoContato() {
        return tipoContato;
    }

    public void setTipoContato(int tipoContato) {
        this.tipoContato = tipoContato;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public Pessoa getRelacionamento() {
        return relacionamento;
    }

    public void setRelacionamento(Pessoa relacionamento) {
        this.relacionamento = relacionamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contatos contatos = (Contatos) o;
        return Objects.equals(id, contatos.id) && Objects.equals(tipoContato, contatos.tipoContato) && Objects.equals(contato, contatos.contato) && Objects.equals(relacionamento, contatos.relacionamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipoContato, contato, relacionamento);
    }
}