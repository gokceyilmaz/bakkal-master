package com.mvc.bys.controller;
import com.mvc.bys.model.Satis;
import com.mvc.bys.repository.SatisRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SatisGuncelleController {
    final SatisRepository satisRepository;

    public SatisGuncelleController(SatisRepository satisRepository) {
        this.satisRepository = satisRepository;
    }

    @GetMapping("/satisguncelle")
    public String satisGuncelle(Model model) {
        return "SatisGuncelle";
    }

    @GetMapping("/satisedit")
    public String getEditPageSatis(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("satis", satisRepository.findById(cid));
            page = "/SatisGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page = "redirect:/satis";
        }
        return page;
    }
    @PostMapping("/satisupdate")
    public String updateInvoice(@ModelAttribute(name = "satis") Satis satis) {
        satisRepository.save(satis);
        return "redirect:/satis";
    }


}
