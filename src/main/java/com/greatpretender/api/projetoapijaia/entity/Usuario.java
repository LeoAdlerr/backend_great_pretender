package com.greatpretender.api.projetoapijaia.entity;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    @JsonIgnore
    private String senha;

    @Column(name = "email")
    private String email;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_setor")
    private Setor setor;

    @OneToMany(mappedBy = "ordem_de_servico", fetch = FetchType.LAZY)
    private Set<OrdemDeServico> ordemDeServicos;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private Set<AtribuicaoOrdemServico> atribuicoes;


    public Usuario() { }

        public Usuario(String cpf, String nome, String senha, String email) {
            this();
            this.cpf = cpf;
            this.nome = nome;
            this.senha = senha;
            this.email = email;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getCpf() {
            return cpf;
        }

        public void setCpf(String cpf) {
            this.cpf = cpf;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Set<OrdemDeServico> getOrdemDeServicos() {
            return ordemDeServicos;
        }

        public void setOrdemDeServicos(Set<OrdemDeServico> ordemDeServicos) {
            this.ordemDeServicos = ordemDeServicos;
        }

        public Set<AtribuicaoOrdemServico> getAtribuicoes() {
            return atribuicoes;
        }

        public void setAtribuicoes(Set<AtribuicaoOrdemServico> atribuicoes) {
            this.atribuicoes = atribuicoes;
        }

        
}
