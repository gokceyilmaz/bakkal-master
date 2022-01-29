package com.mvc.bys.controller;

import com.mvc.bys.model.Stok;
import com.mvc.bys.repository.StokRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StokGuncelleController {
    final StokRepository stokRepository;
    public StokGuncelleController(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }

    @PostMapping("/stokupdate")
    public String updateInvoice(@ModelAttribute(name = "stok") Stok stok) {
        stokRepository.save(stok);
        return "redirect:/stok";
    }
    @GetMapping("/stokguncelle")
    public String guncelle(Model model)
    {
        return "StokGuncelle";
    }

    @GetMapping("/stokedit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("stok", stokRepository.findById(cid));
            page="/StokGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/stok";
        }
        return page;
    }
}
