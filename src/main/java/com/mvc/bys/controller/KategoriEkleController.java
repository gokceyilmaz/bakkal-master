package com.mvc.bys.controller;

import com.mvc.bys.model.Kategori;
import com.mvc.bys.repository.KategoriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KategoriEkleController {
    final KategoriRepository kategoriRepository;
    public KategoriEkleController(KategoriRepository kategoriRepository) {
        this.kategoriRepository = kategoriRepository;
    }

    @GetMapping("/kategoriekle")
    public String kategoriEkle()
    {
        return "KategoriEkle";
    }
    @RequestMapping(value = "/kategorikaydet", method = RequestMethod.POST)
    public String save(Kategori kategori) {
        kategoriRepository.save(kategori);
        return "redirect:/kategori";
    }


}
