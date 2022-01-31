package com.mvc.bys.controller;

import com.mvc.bys.model.Kategori;
import com.mvc.bys.repository.KategoriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//kategorileri güncelleme işlemlerini çeşitli yerlerde kullanarak yönlendirmelerini yapıyoruz
@Controller
public class KategoriGuncelleController {
    final KategoriRepository kategoriRepository;
    public KategoriGuncelleController(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }
    @GetMapping("/kategoriguncelle")
    public String guncelle(Model model)
    {
        return "KategoriGuncelle";
    }


    @GetMapping("/kategoriedit")
    public String getEditPage(
            Model model,
            RedirectAttributes attributes,
            @RequestParam String id
    ) {
        String page = null;
        try {
            int cid = Integer.parseInt(id);
            model.addAttribute("kategori", kategoriRepository.findById(cid));
            return "/KategoriGuncelle.html";
        } catch (Exception ex) {
            ex.printStackTrace();
            attributes.addAttribute("message", ex.getMessage());
            page="redirect:/kategori";
        }
        return page;
    }
    @PostMapping("/kategoriupdate")
    public String updateInvoice(@ModelAttribute(name = "kategori") Kategori kategori) {
        kategoriRepository.save(kategori);
        return "redirect:/kategori";
    }

}
