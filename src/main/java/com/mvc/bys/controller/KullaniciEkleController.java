package com.mvc.bys.controller;

import com.mvc.bys.repository.KullaniciRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class KullaniciEkleController {
    final KullaniciRepository kullaniciRepository;
    public KullaniciEkleController(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }
    @GetMapping("/kullaniciekle")
    public String kullaniciekle()
    {
        return "KullaniciEkle";
    }
}
