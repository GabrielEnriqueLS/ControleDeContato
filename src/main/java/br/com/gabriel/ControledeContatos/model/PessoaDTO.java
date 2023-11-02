package br.com.gabriel.ControledeContatos.model;

public class PessoaDTO {
    private Long id;
    private String nome;
    private String enderecoCompleto;

    public PessoaDTO(Long id, String nome, String enderecoCompleto) {
        this.id = id;
        this.nome = nome;
        this.enderecoCompleto = enderecoCompleto;
    }

}