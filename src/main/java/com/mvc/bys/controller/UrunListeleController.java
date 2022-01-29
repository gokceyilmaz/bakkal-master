package com.mvc.bys.controller;

import com.mvc.bys.model.Urun;
import com.mvc.bys.repository.UrunRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UrunListeleController {
    final UrunRepository urunRepository;
    public UrunListeleController(UrunRepository urunRepository) {
        this.urunRepository = urunRepository;
    }

    @GetMapping("/urun")
    public String survey(Model model)
    {
        model.addAttribute("list", urunRepository.findAll());
        return "/Urun";
    }

    @RequestMapping(value = "/urunkaydet", method = RequestMethod.POST)
    public String save(Urun urun) {
        urunRepository.save(urun);
        return "redirect:/urun";
    }

    @GetMapping("/urunsil")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            urunRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/urun";
    }

}
