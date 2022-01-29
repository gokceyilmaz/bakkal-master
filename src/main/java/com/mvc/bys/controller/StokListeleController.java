package com.mvc.bys.controller;

import com.mvc.bys.model.Stok;
import com.mvc.bys.repository.StokRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StokListeleController {
    final StokRepository stokRepository;
    public StokListeleController(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }

    @GetMapping("/stok")
    public String survey(Model model)
    {
        model.addAttribute("list", stokRepository.findAll());
        return "/Stok";
    }

    @RequestMapping(value = "/stokkaydet", method = RequestMethod.POST)
    public String save(Stok stok) {
        stokRepository.save(stok);
        return "redirect:/stok";
    }

    @GetMapping("/stoksil")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            stokRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/stok";
    }

}
