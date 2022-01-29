package com.mvc.bys.controller;

import com.mvc.bys.repository.UrunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UrunEkleController {
    final UrunRepository urunRepository;
    public UrunEkleController(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    @GetMapping("/urunekle")
    public String urunekle()
    {
        return "UrunEkle";
    }

}
