package br.com.yoshi.projitau.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yoshi.projitau.dto.AgFinanceiroDTO;
import br.com.yoshi.projitau.model.AgFinanceiro;
import br.com.yoshi.projitau.repository.AgFinanceiroRepo;



@RestController
@CrossOrigin("*") // requisições de qualquer origem
@RequestMapping("/agfinanceiro")
public class AgFinanceiroController {

    @Autowired
    private AgFinanceiroRepo agFinanceiroRepo;

    @GetMapping("/id/{id}")
    public ResponseEntity<AgFinanceiro> getAgFinanceiroById(@PathVariable int id) {
        AgFinanceiro agenteFinanceiro = agFinanceiroRepo.findById(id).orElse(null); // findById busca pela PK

        if (agenteFinanceiro != null) {
            return ResponseEntity.ok(agenteFinanceiro); // OK = 200
        }

        return ResponseEntity.notFound().build(); // NOT FOUND = 404
    }

    @GetMapping("/top10")
    public ResponseEntity<List<AgFinanceiroDTO>> getTopAgFinanceiroByQtde() {
        List<AgFinanceiro> agFinanceiros = (List<AgFinanceiro>) agFinanceiroRepo.findTop10ByOrderByVolumeTransacionalDesc();

        if (agFinanceiros != null) {
            List<AgFinanceiroDTO> agFinanceirosDTO = new ArrayList<AgFinanceiroDTO>();
            agFinanceiros.forEach((ag) -> agFinanceirosDTO.add(new AgFinanceiroDTO(ag)));  
            return ResponseEntity.ok(agFinanceirosDTO); // OK = 200
        }

        return ResponseEntity.status(404).build(); // NOT FOUND = 404

    }

}
