package com.iadsn.controller.api;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/membros_api")
@CrossOrigin(origins = "*") // Permite todas as origens (apenas para desenvolvimento!)
public class MembroControllerApi {

    @Autowired
    MembroService membroService;

    @GetMapping("/pesquisar/{id}")
    public ResponseEntity<MembroEntity> procurarMembro(@PathVariable(value = "id") Long id){
        MembroEntity membro = membroService.getMembroId(id);
        return new ResponseEntity<>(membro, HttpStatus.OK);
    }

    @GetMapping("/foto/{id}")
    public ResponseEntity<byte[]> carregarFoto(@PathVariable Long id) {
        MembroEntity membro = membroService.getMembroId(id);
        if (membro != null && membro.getFoto() != null) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG) // Altere para PNG se necessário
                    .body(membro.getFoto());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
