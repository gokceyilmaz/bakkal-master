package com.mvc.bys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SatisListeleController {
    @RequestMapping("/satis")
    public String anasayfa()
    {
        return"/Satis";
    }
}
