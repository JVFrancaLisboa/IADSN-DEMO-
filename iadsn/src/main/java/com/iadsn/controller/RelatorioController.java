package com.iadsn.controller;

import com.iadsn.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    RelatorioService relatorioService;

    @GetMapping("/relatorioInterface")
    public String getRelatorio(Model model){
        model.addAttribute("movimentacoes", relatorioService.getMovimentacoesDTO());
        model.addAttribute("total", relatorioService.getValoresEmBrl());
        return "fragments/relatorio :: content";
    }
}