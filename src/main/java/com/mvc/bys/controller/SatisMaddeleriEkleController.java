package com.mvc.bys.controller;

import com.mvc.bys.repository.SatisMaddeleriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SatisMaddeleriEkleController {
    final SatisMaddeleriRepository satisMaddeleriRepository;

    public SatisMaddeleriEkleController(SatisMaddeleriRepository satisMaddeleriRepository) {
        this.satisMaddeleriRepository = satisMaddeleriRepository;
    }
    @GetMapping("/satismaddeleriekle")
    public String satismaddeleriekle() {
        return "SatisMaddeleriEkle";
    }

}
