package com.mvc.bys.controller;

import com.mvc.bys.repository.KullaniciRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

//jpa repository den extends aldığımız kullanıcırepository interface'ini kullanarak
// kulanıcı ekleme işlemlerini de yapıyoruz.
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
