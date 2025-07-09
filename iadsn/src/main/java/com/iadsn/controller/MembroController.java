package com.iadsn.controller;

import com.iadsn.entities.MembroEntity;
import com.iadsn.services.MembroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Controller
@RequestMapping("/membros")
public class MembroController {

    @Autowired
    MembroService membroService;

    @GetMapping("/membrosInterface")
    public String membros(Model model) {
        model.addAttribute("membro", new MembroEntity());
        model.addAttribute("membrosLista", membroService.getMembrosDesarquivados());
        model.addAttribute("membrosArquivados", membroService.getMembrosArquivados());
        return "fragments/membros :: content";
    }

    @PostMapping("salvar-membro")
    public String salvarMembro(@Valid @ModelAttribute MembroEntity membro) {
        if (membro == null) return "redirect:/";
        if(membro.getId() == null) membroService.criarMembro(membro);
        else membroService.atualizarMembro(membro.getId(), membro, membro.getMultipartFile());
        return "redirect:/";
    }

    @PostMapping("deletar/{id}")
    public String deletarMembro(@PathVariable Long id){
        membroService.deletarMembro(id);
        return "redirect:/";
    }

    @PostMapping("arquivar/{id}")
    public String arquivarMembro(@PathVariable(value = "id") Long id){
        membroService.arquivarMembroId(id);
        return "redirect:/";
    }

    @PostMapping("desarquivar/{id}")
    public String desarquivarMembro(@PathVariable(value = "id") Long id){
        membroService.desarquivarMembroId(id);
        return "redirect:/";
    }

    @PostMapping("/atualizar-membro/{id}")
    public String atualizarMembro(@PathVariable Long id, Model model){
        model.addAttribute("membro", membroService.getMembroId(id));
        return "atualizar-membro";
    }
}