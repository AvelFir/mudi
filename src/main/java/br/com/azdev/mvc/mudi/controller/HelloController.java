package br.com.azdev.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("nome", "World");
        return "hello";
    }
}
