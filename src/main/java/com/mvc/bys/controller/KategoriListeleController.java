package com.mvc.bys.controller;

import com.mvc.bys.model.Kategori;
import com.mvc.bys.repository.KategoriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//kateorileri listeleme  ve silme işlemlerine yönlendirme yapıyoruz.
@Controller
public class KategoriListeleController {
    final KategoriRepository kategoriRepository;
    public KategoriListeleController(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    @GetMapping("/kategori")
    public String survey(Model model)
    {
        model.addAttribute("list", kategoriRepository.findAll());
        return "/Kategori";
    }


    @GetMapping("/kategorisil")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            kategoriRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/kategori";
    }

}
