package tata.pi.eventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {
	
	@PostMapping("/submit")
	public String submetido() {
		System.out.println("O método do formulário foi executado!");
		
		return "redirect:/success";
	}
	
	@GetMapping("/success")
	public String successPage() {
		return "success";
	}

}
