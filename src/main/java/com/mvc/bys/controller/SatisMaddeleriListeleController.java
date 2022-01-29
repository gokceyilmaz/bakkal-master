package com.mvc.bys.controller;
import com.mvc.bys.model.SatisMaddeleri;
import com.mvc.bys.repository.SatisMaddeleriRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SatisMaddeleriListeleController {
    final SatisMaddeleriRepository satisMaddeleriRepository;

    public SatisMaddeleriListeleController(SatisMaddeleriRepository satisMaddeleriRepository) {
        this.satisMaddeleriRepository = satisMaddeleriRepository;
    }

    @GetMapping("/satismaddeleri")
    public String satisMaddeleriSurvey(Model model) {
        model.addAttribute("list", satisMaddeleriRepository.findAll());
        return "/SatisMaddeleri";
    }
    @RequestMapping(value = "/satismaddelerikaydet", method = RequestMethod.POST)
    public String save(SatisMaddeleri satisMaddeleri) {
        SatisMaddeleri duzenlendi = new SatisMaddeleri();
        satisMaddeleriRepository.save(satisMaddeleri);
        return "redirect:/satismaddeleri";
    }


    @GetMapping("/satismaddelerisil")
    public String deleteSatis(@RequestParam String id) {
        try {
            int cid = Integer.parseInt(id);
            satisMaddeleriRepository.deleteById(cid);
        } catch (Exception ex) {
            System.err.println("delete Error : " + ex);
        }
        return "redirect:/satismaddeleri";
    }



}
