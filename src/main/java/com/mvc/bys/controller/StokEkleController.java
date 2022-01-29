package com.mvc.bys.controller;

import com.mvc.bys.repository.StokRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StokEkleController {
    final StokRepository stokRepository;
    public StokEkleController(StokRepository stokRepository) {
        this.stokRepository = stokRepository;
    }
    @GetMapping("/stokekle")
    public String urunekle()
    {
        return "StokEkle";
    }

}
