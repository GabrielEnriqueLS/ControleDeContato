package br.com.gabriel.ControledeContatos.model;

import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false)
    private String endereco;
    @Column(nullable = false)
    private Long cep;
    @Column(nullable = false)
    private String cidade;
    private String uf;


    //construtores:
    public Pessoa(String nome, String endereco, Long cep, String cidade, String uf , Long id) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
        this.uf = uf;
        this.id = id;
        this.cep = cep;
    }

    public Pessoa() {

    }


    //getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(id, pessoa.id) && Objects.equals(nome, pessoa.nome) && Objects.equals(endereco, pessoa.endereco) && Objects.equals(cep, pessoa.cep) && Objects.equals(cidade, pessoa.cidade) && Objects.equals(uf, pessoa.uf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, endereco, cep, cidade, uf);
    }
}
