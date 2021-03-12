package br.com.yoshi.projitau.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.yoshi.projitau.model.AgFinanceiro;

public interface AgFinanceiroRepo extends CrudRepository<AgFinanceiro,Integer>{

    public List<AgFinanceiro> findTop10ByOrderByVolumeTransacionalDesc();
}

