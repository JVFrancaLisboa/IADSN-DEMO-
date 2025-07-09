package com.iadsn.controller;

import com.iadsn.entities.DizimoEntity;
import com.iadsn.entities.GastoEntity;
import com.iadsn.entities.MembroEntity;
import com.iadsn.entities.OfertaEntity;
import com.iadsn.services.DizimoService;
import com.iadsn.services.GastoService;
import com.iadsn.services.MembroService;
import com.iadsn.services.OfertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    @Autowired
    DizimoService dizimoService;
    @Autowired
    OfertaService ofertaService;
    @Autowired
    GastoService gastoService;
    @Autowired
    MembroService membroService;

    @GetMapping("/movimentacoesInterface")
    public String getMovs(Model model){
        model.addAttribute("oferta", new OfertaEntity());
        model.addAttribute("dizimo", new DizimoEntity());
        model.addAttribute("gasto", new GastoEntity());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/movimentacoes :: content";
    }

    // Realicionados aos Dizimos
    @PostMapping("/save-dizimo")
    public String salvarDizmo(@ModelAttribute DizimoEntity dizimo){
        dizimoService.criarDizimo(dizimo);
        return "redirect:/";
    }


    // Realicionados as Ofertas
    @PostMapping("/save-oferta")
    public String salvarOferta(@ModelAttribute OfertaEntity oferta){
        ofertaService.criarOferta(oferta);
        return "redirect:/";
    }


    // Realicionados aos Gastos
    @PostMapping("/save-gasto")
    public String salvaGasto(@ModelAttribute GastoEntity gasto){
        if(gasto == null) return "redirect:/";
        if(gasto.getId() == null) gastoService.criarGasto(gasto);
        else gastoService.atualizarGasto(gasto.getId(), gasto);
        return "redirect:/";
    }
}