package br.com.wareline.appexemplo.appexemplo.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;

@Controller
class HelloController {

    @Autowired
    private Environment env;

    @GetMapping("/")
    String hello(Model model) {

        model.addAttribute("hostname", env.getProperty("HOSTNAME"));
        model.addAttribute("bgColor", env.getProperty("BG_COLOR"));

        return "hello";
    }

    @ResponseBody
    @GetMapping("/read-file/{file}")
    String readFile(@PathVariable("file") String file) throws IOException {

        Resource resource = new FileSystemResource("./data/" + file);
        InputStream inputStream = resource.getInputStream();
        byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
        String data = new String(bdata, StandardCharsets.UTF_8);
        
        return data; 
    }

    @ResponseBody
    @GetMapping("/client")
    ResponseEntity<String> client() throws IOException {

        String url = env.getProperty("MY_REMOTE_URL");
        RestTemplate rest = new RestTemplate();
        ResponseEntity<String> result = rest.getForEntity(url, String.class);
        return result; 
        
    }

    @ResponseBody
    @GetMapping("/remote")
    String remote() {
        return "Esta é uma resposta remota.";
    }

}
