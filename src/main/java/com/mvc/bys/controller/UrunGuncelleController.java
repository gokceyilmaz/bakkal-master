package com.mvc.bys.controller;

import com.mvc.bys.model.Urun;
import com.mvc.bys.repository.UrunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UrunGuncelleController {
    final UrunRepository urunRepository;
    public UrunGuncelleController(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    @GetMapping("/urunguncelle")
    public String guncelle(Model model)
    {
        return "UrunGuncelle";
    }

    @GetMapping("/urunedit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("urun", urunRepository.findById(cid));
            page="/UrunGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/urun";
        }
        return page;
    }
    @PostMapping("/urunupdate")
    public String updateInvoice(@ModelAttribute(name = "urun") Urun urun) {
        urunRepository.save(urun);
        return "redirect:/urun";
    }
}
