package br.com.yoshi.projitau.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.yoshi.projitau.dto.UsuarioDTO;
import br.com.yoshi.projitau.model.Usuario;
import br.com.yoshi.projitau.repository.UsuarioRepo;



@RestController
@CrossOrigin("*") // requisições de qualquer origem
@RequestMapping("/user")
public class UsuarioController {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @GetMapping("/id/{id}")
    public ResponseEntity<UsuarioDTO> obterUsuarioPorId(@PathVariable int id) {
        Usuario userFound = usuarioRepo.findById(id).orElse(null); // findById busca pela PK

        if (userFound != null) {
            UsuarioDTO usuario = new UsuarioDTO(userFound);
            return ResponseEntity.ok(usuario); // OK = 200
        }

        return ResponseEntity.notFound().build(); // NOT FOUND = 404
    }

    @PostMapping("/login")
    public ResponseEntity<UsuarioDTO> login(@RequestBody Usuario user) {
        Usuario userFound = usuarioRepo.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFound != null && user.getSenha() != null) {
            if (user.getSenha().equals(userFound.getSenha())) {
                UsuarioDTO usuario = new UsuarioDTO(userFound);
                return ResponseEntity.ok(usuario); // OK = 200
            }
        }

        return ResponseEntity.status(404).build(); // NOT FOUND = 404

    }

}
