package tata.pi.eventos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import tata.pi.eventos.models.Evento;
import tata.pi.eventos.repositories.EventoRepository;

@Controller
public class EventosController {
	
	@Autowired
	private EventoRepository er;
	
	@RequestMapping("/eventos/form")
	public String form() {
		return "formEvento";	
	
	}
	
	@PostMapping("/submit")
	public String submetido(Evento evento) {
   
        System.out.println("Dados do evento:");
        System.out.println("Nome: " + evento.getNome());
        System.out.println("Data: " + evento.getData());
        System.out.println("Horário: " + evento.getHorario());
        System.out.println("Local: " + evento.getLocal());
        er.save(evento);
        
        return "redirect:/success";
    }
	
	
	@GetMapping("/success")
	public String successPage() {
		return "success";
	}
	
}
