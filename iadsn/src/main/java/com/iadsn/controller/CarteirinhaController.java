package com.iadsn.controller;

import com.iadsn.dto.Carteirinha;
import com.iadsn.dto.CarteirinhaMembroDTO;
import com.iadsn.dto.CarteirinhaMinistroDTO;
import com.iadsn.dto.CarteirinhaMissionarioDTO;
import com.iadsn.dto.enums.TipoCarteirinha;
import com.iadsn.services.MembroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carteirinha")
public class CarteirinhaController {

    @Autowired
    private MembroService membroService;

    @GetMapping("/membro")
    public String gerarMembro(@ModelAttribute CarteirinhaMembroDTO dto, Model model){
        dto.getMembro().setNascimento(dto.formatarData(dto.getMembro().getNascimento()));
        dto.setBatismoAguas(dto.formatarData(dto.getBatismoAguas()));
        dto.setBatismoEspiritoSanto(dto.formatarData(dto.getBatismoEspiritoSanto()));

        model.addAttribute("dto", dto);

        return "membro_carteirinha";
    }

    @GetMapping("/ministro")
    public String gerarMinistro(@ModelAttribute CarteirinhaMinistroDTO dto, Model model){
        dto.getMembro().setNascimento(dto.formatarData(dto.getMembro().getNascimento()));
        dto.setBatismoAguas(dto.formatarData(dto.getBatismoAguas()));
        dto.setBatismoEspiritoSanto(dto.formatarData(dto.getBatismoEspiritoSanto()));
        dto.setOrdenacao(dto.formatarData(dto.getOrdenacao()));

        model.addAttribute("dto", dto);

        return "ministro_carteirinha";
    }

    @GetMapping("/missionario")
    public String gerarMissionario(@ModelAttribute CarteirinhaMissionarioDTO dto, Model model){
        dto.getMembro().setNascimento(dto.formatarData(dto.getMembro().getNascimento()));
        dto.setBatismoAguas(dto.formatarData(dto.getBatismoAguas()));
        dto.setBatismoEspiritoSanto(dto.formatarData(dto.getBatismoEspiritoSanto()));

        model.addAttribute("dto", dto);

        return "missionario_carteirinha";
    }

    @GetMapping("/membrodto")
    public String  getCapturaMembroDto(Model model){
        model.addAttribute("dto", new CarteirinhaMembroDTO());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/captura-membrodto :: content";
    }

    @GetMapping("/ministrodto")
    public String getCapturaMinistroDto(Model model){
        model.addAttribute("dto", new CarteirinhaMinistroDTO());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/captura-ministrodto :: content";
    }

    @GetMapping("/missionariodto")
    public String getCapturaMissionarioDto(Model model){
        model.addAttribute("dto", new CarteirinhaMissionarioDTO());
        model.addAttribute("membros", membroService.getMembrosDesarquivados());
        return "fragments/captura-missionariodto :: content";
    }
}
