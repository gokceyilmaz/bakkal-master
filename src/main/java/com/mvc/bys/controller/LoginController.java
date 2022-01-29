package com.mvc.bys.controller;

import com.mvc.bys.model.Kullanici;
import com.mvc.bys.repository.KullaniciRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class LoginController {
    final KullaniciRepository kullaniciRepository;
    public LoginController(KullaniciRepository kullaniciRepository) {
        this.kullaniciRepository = kullaniciRepository;
    }

    @GetMapping("/giris")
    public String girisYap()
    {
        return "/login";
    }


    @RequestMapping(value = "/giris", method = RequestMethod.POST)
    public String giris(Kullanici kullanici) {
        List<Kullanici> liste = kullaniciRepository.findAll();
        boolean isMatch = liste.stream().anyMatch(user -> user.getKullaniciAdi().equals(kullanici.getKullaniciAdi()) && user.getKullaniciParola().equals(kullanici.getKullaniciParola()));
        if(isMatch == false) {
            return "redirect:/giris";
        }
        else return "redirect:/anasayfa";
    }
}