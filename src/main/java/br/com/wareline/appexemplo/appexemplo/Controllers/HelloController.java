package br.com.wareline.appexemplo.appexemplo.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@RestController
class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("/hello")
    String hello() {
        return "Olá Wareliner! O nome desse servidor é " + env.getProperty("HOSTNAME");
    }

    @GetMapping("/read-file")
    String readFile() {
        return ""; 
    }

}
