package br.com.yoshi.projitau.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "mtb310_transaction")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_transacao")
    private int id; //PK

    @Column(name="data_hora")
    private LocalDate dataHora;

    @Column(name="dispositivo")
    private int dispositivo;

    @Column(name="valor_solic")
    private double valorSolic;

    @Column(name="valor_aut")
    private double valorAut;

    @Column(name="status")
    private int status;

    @ManyToOne
    @JoinColumn(name = "ag_financeiro")
    @JsonIgnoreProperties("transacoes")
    private AgFinanceiro agFinanceiro; //FK

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDate dataHora) {
        this.dataHora = dataHora;
    }

    public int getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(int dispositivo) {
        this.dispositivo = dispositivo;
    }

    public double getValorSolic() {
        return valorSolic;
    }

    public void setValorSolic(double valorSolic) {
        this.valorSolic = valorSolic;
    }

    public double getValorAut() {
        return valorAut;
    }

    public void setValorAut(double valorAut) {
        this.valorAut = valorAut;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public AgFinanceiro getAgFinanceiro() {
        return agFinanceiro;
    }

    public void setAgFinanceiro(AgFinanceiro agFinanceiro) {
        this.agFinanceiro = agFinanceiro;
    }

    

}
