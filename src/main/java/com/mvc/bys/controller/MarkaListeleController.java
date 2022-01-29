package com.mvc.bys.controller;

import com.mvc.bys.model.Marka;
import com.mvc.bys.repository.MarkaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MarkaListeleController {
    final MarkaRepository markaRepository;
    public MarkaListeleController(MarkaRepository markaRepository) {
        this.markaRepository = markaRepository;
    }

    @GetMapping("/marka")
    public String survey(Model model)
    {
        model.addAttribute("list", markaRepository.findAll());
        return "/Marka";
    }

    @RequestMapping(value = "/markakaydet", method = RequestMethod.POST)
    public String save(Marka marka) {
        markaRepository.save(marka);
        return "redirect:/marka";
    }

    @GetMapping("/markasil")
    public String delete(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            markaRepository.deleteById(cid);
        }catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/marka";
    }

}
