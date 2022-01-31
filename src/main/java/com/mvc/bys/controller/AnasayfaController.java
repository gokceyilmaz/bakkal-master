package com.mvc.bys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnasayfaController {

    @RequestMapping("/anasayfa") //anasayfa yönlendirmesi yapıyor
    public String anasayfa()
    {
        return"/Anasayfa";
    }

    @RequestMapping // proje çalıştığı an login sayfasını açıyor
    public String goLogin()
    {
        return"/login";
    }

}
