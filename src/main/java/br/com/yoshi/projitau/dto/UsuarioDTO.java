package br.com.yoshi.projitau.dto;

import br.com.yoshi.projitau.model.Usuario;

public class UsuarioDTO {

    private String email;
    private String linkFoto;
    private String nome;
    private String racf;

    public UsuarioDTO(Usuario usuario){
        this.email = usuario.getEmail();
        this.linkFoto = usuario.getLinkFoto();
        this.nome = usuario.getNome();
        this.racf = usuario.getRacf();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkFoto() {
        return linkFoto;
    }

    public void setLinkFoto(String linkFoto) {
        this.linkFoto = linkFoto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRacf() {
        return racf;
    }

    public void setRacf(String racf) {
        this.racf = racf;
    }

}
