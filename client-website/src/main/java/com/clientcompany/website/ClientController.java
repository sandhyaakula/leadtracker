package com.clientcompany.website;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClientController {
	@GetMapping("/offers")
    public String offers() {
        return "offers"  ;  
        
    }

}
