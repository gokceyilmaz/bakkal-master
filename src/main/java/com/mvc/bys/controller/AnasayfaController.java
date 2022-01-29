package com.mvc.bys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnasayfaController {

    @RequestMapping("/anasayfa")
    public String anasayfa()
    {
        return"/Anasayfa";
    }

    @RequestMapping
    public String goLogin()
    {
        return"/login";
    }

}
