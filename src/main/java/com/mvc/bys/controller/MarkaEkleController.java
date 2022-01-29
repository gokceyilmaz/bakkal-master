package com.mvc.bys.controller;

import com.mvc.bys.repository.MarkaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MarkaEkleController {
    final MarkaRepository markaRepository;
    public MarkaEkleController(MarkaRepository markaRepository) {
        this.markaRepository = markaRepository;
    }

    @GetMapping("/markaekle")
    public String markaekle()
    {
        return "MarkaEkle";
    }
}
