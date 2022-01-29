package com.mvc.bys.controller;

import com.mvc.bys.model.SatisMaddeleri;
import com.mvc.bys.repository.SatisMaddeleriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class SatisMaddeleriGuncelleController {
    final SatisMaddeleriRepository satisMaddeleriRepository;

    public SatisMaddeleriGuncelleController(SatisMaddeleriRepository satisMaddeleriRepository) {
        this.satisMaddeleriRepository = satisMaddeleriRepository;
    }
    @GetMapping("/satismaddeleriguncelle")
    public String satisMaddeleriGuncelle(Model model) {
        return "SatisMaddeleriGuncelle";
    }

    @GetMapping("/satismaddeleriedit")
    public String getEditPageSatisMaddeleri(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("satismaddeleri", satisMaddeleriRepository.findById(cid));
            page = "/SatisMaddeleriGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page = "redirect:/satismaddeleri";
        }
        return page;
    }
    @GetMapping("/satismaddelerieditfromsatis")
    public String getEditPageSatis(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            List<SatisMaddeleri> gonder = satisMaddeleriRepository.findAll().stream().filter(satisMaddeleri -> satisMaddeleri.getSatisId() == cid).collect(Collectors.toList());
            model.addAttribute("satismaddeleri", gonder.get(0));
            page = "/SatisMaddeleriGuncelleSatis.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page = "redirect:/satismaddeleri";
        }
        return page;
    }
    @PostMapping("/satismaddeleriupdate")
    public String updateInvoice(@ModelAttribute(name = "satismaddeleri") SatisMaddeleri satisMaddeleri) {
        satisMaddeleriRepository.save(satisMaddeleri);
        return "redirect:/satismaddeleri";
    }

    @PostMapping("/satismaddeleriupdatesatis")
    public String updateInvoiceSatis(@ModelAttribute(name = "satismaddeleri") SatisMaddeleri satisMaddeleri) {
        satisMaddeleriRepository.save(satisMaddeleri);
        return "redirect:/satis";
    }



}
