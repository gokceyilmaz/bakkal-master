package com.mvc.bys.controller;

import com.mvc.bys.model.Marka;
import com.mvc.bys.repository.MarkaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class MarkaGuncelleController {
    final MarkaRepository markaRepository;
    public MarkaGuncelleController(MarkaRepository markaRepository) {
        this.markaRepository = markaRepository;
    }


    @GetMapping("/markaguncelle")
    public String guncelle(Model model)
    {
        return "MarkaGuncelle";
    }


    @GetMapping("/markaedit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("marka", markaRepository.findById(cid));
            return "/MarkaGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/marka";
        }
        return page;
    }
    @PostMapping("/markaupdate")
    public String updateInvoice(@ModelAttribute(name = "marka") Marka marka) {
        markaRepository.save(marka);
        return "redirect:/marka";
    }
}
