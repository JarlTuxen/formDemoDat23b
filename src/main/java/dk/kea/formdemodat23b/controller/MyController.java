package dk.kea.formdemodat23b.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MyController {

    @GetMapping("/")
    public String showInputForm(){
        return "inputForm";
    }

    @PostMapping("/processForm")
    public String processInput(@RequestParam("inputTekst") String input, RedirectAttributes redirectAttributes){
        //simuler at vi har processeret input og sender det videre til en anden side
        redirectAttributes.addAttribute("redirectTekst", input);
        return "redirect:/showResultPage";
    }

    @GetMapping("/showResultPage")
    public String showResult(@RequestParam("redirectTekst") String input, Model model){
        // brug model til at tilgå data via Thymeleaf i html-filen
        model.addAttribute("tekst", input);
        return "showResult";
    }
}
