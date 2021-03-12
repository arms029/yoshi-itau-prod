package br.com.yoshi.projitau.dto;

import br.com.yoshi.projitau.model.AgFinanceiro;

public class AgFinanceiroDTO {

    private int id;
    private String nome;
    private double volumeTransacional;

    public AgFinanceiroDTO(AgFinanceiro agFinanceiro){
        this.id = agFinanceiro.getId();
        this.nome = agFinanceiro.getNome();
        this.volumeTransacional = agFinanceiro.getVolumeTransacional();
    }

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

    public double getVolumeTransacional() {
        return volumeTransacional;
    }

    public void setVolumeTransacional(double volumeTransacional) {
        this.volumeTransacional = volumeTransacional;
    }


    
}
