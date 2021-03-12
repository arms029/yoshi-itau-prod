package br.com.yoshi.projitau.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mtb310_ag_financeiro")
public class AgFinanceiro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_agente")
    private int id; //PK

    @Column(name="nome_agente", length = 100)
    private String nome;

    @Column(name="volume_transacional")
    private double volumeTransacional;

    @OneToMany(mappedBy = "agFinanceiro")
    @JsonIgnoreProperties("agFinanceiro")
    private List<Transacao> transacoes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

 

    // public List<Transacao> getTransacoes() {
    //     return transacoes;
    // }


    public void setVolumeTransacional(int volumeTransacional) {
        this.volumeTransacional = volumeTransacional;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public double getVolumeTransacional() {
        return volumeTransacional;
    }

    public void setVolumeTransacional(double volumeTransacional) {
        this.volumeTransacional = volumeTransacional;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }   

    
}
