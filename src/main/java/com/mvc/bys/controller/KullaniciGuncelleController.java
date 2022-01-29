package com.mvc.bys.controller;

import com.mvc.bys.model.Kullanici;
import com.mvc.bys.repository.KullaniciRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class KullaniciGuncelleController {
    final KullaniciRepository kullaniciRepository;
    public KullaniciGuncelleController(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }
    @GetMapping("/kullaniciguncelle")
    public String guncelle(Model model)
    {
        return "KullaniciGuncelle";
    }

    @GetMapping("/kullaniciedit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("kullanici", kullaniciRepository.findById(cid));
            page="/KullaniciGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/kullanici";
        }
        return page;
    }
    @PostMapping("/kullaniciupdate")
    public String updateInvoice(@ModelAttribute(name = "kullanici") Kullanici kullanici) {
        kullaniciRepository.save(kullanici);
        return "redirect:/kullanici";
    }
}
