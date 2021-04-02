package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

//import javax.validation.Valid;

@Controller
public class HomeController {
    @GetMapping("/tvform")
    public String loadTvForm(Model model){
        model.addAttribute("tvshow",new Tvshow());
        return "tvform";
    }

    @PostMapping( "/tvprocess")
    public String processTvForm(@Valid Tvshow tvshow, BindingResult result){
        List<FieldError> errors = result.getFieldErrors();
        for (FieldError error : errors ) {
            System.out.println (error.getObjectName() + " - " +error.getDefaultMessage());
        }
        System.out.print(tvshow.getName());
        if(result.hasErrors()){
            System.out.println("hello");
            return "tvform";
        }else {
            return "tvshowconfirm";
        }

    }
}
