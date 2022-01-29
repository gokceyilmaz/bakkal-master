package com.mvc.bys.controller;

import com.mvc.bys.repository.SatisRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SatisEkleController {
    final SatisRepository satisRepository;

    public SatisEkleController(SatisRepository satisRepository) {
        this.satisRepository = satisRepository;
    }


    @GetMapping("/satisekle")
    public String satisekle() {
        return "SatisEkle";
    }


}
