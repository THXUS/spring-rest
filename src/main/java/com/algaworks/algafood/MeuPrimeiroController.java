package com.algaworks.algafood;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MeuPrimeiroController {


    @GetMapping("/hello")
    @ResponseBody
    public String helloWorld() {
        return "Hello World";
    }
}
