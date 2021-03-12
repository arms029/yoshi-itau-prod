package br.com.yoshi.projitau.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.yoshi.projitau.dto.ContagemStatusDTO;
import br.com.yoshi.projitau.model.Transacao;

public interface TransacaoRepo extends CrudRepository<Transacao, Integer> {
    @Query("SELECT new br.com.yoshi.projitau.dto.ContagemStatusDTO(t.agFinanceiro.nome, t.agFinanceiro.volumeTransacional, t.status, " +
    "COUNT(t.status)) " +
    "FROM Transacao AS t " +
    "WHERE t.agFinanceiro.id = ?1 " +
    "GROUP BY t.agFinanceiro.nome, t.status " +
    "ORDER By t.status")
    List<ContagemStatusDTO> teste(int idAgente);
}
