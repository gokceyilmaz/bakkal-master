package com.mvc.bys.controller;

import com.mvc.bys.model.Satis;
import com.mvc.bys.repository.SatisRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SatisListeleController {
    final SatisRepository satisRepository;

    public SatisListeleController(SatisRepository satisRepository) {
        this.satisRepository = satisRepository;
    }

    @GetMapping("/satis")
    public String satisSurvey(Model model) {
        model.addAttribute("list", satisRepository.findAll());
        return "/Satis";
    }
    @RequestMapping(value = "/satiskaydet", method = RequestMethod.POST)
    public String save(Satis satis) {
        satisRepository.save(satis);
        return "redirect:/satis";
    }


    @GetMapping("/satissil")
    public String deleteSatis(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            satisRepository.deleteById(cid);
        } catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/satis";
    }


}
