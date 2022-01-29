package com.mvc.bys.controller;

import com.mvc.bys.model.Kullanici;
import com.mvc.bys.repository.KullaniciRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class KullaniciListeleController {
    final KullaniciRepository kullaniciRepository;
    public KullaniciListeleController(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }

    @GetMapping("/kullanici")
    public String survey(Model model)
    {
        model.addAttribute("kullanici", kullaniciRepository.findById(1));
        return "/Kullanici";
    }

    @RequestMapping(value = "/kullanicikaydet", method = RequestMethod.POST)
    public String save(Kullanici kullanici) {
        kullaniciRepository.save(kullanici);
        return "redirect:/giris";
    }

    @GetMapping("/kullanicisil")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            kullaniciRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/giris";
    }


}
