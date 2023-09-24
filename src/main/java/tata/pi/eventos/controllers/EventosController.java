package tata.pi.eventos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tata.pi.eventos.models.Evento;
import tata.pi.eventos.repositories.EventoRepository;

@Controller
@RequestMapping("/eventos")
public class EventosController {

	@Autowired
	private EventoRepository er;

	@GetMapping("/form")
	public String form() {
		return "eventos/formEvento";

	}

	@PostMapping("/submit")
	public String submetido(Evento evento) {

		System.out.println("Dados do evento:");
		System.out.println("Nome: " + evento.getNome());
		System.out.println("Data: " + evento.getData());
		System.out.println("Horário: " + evento.getHorario());
		System.out.println("Local: " + evento.getLocal());
		er.save(evento);

		return "eventos/redirect:/success";
	}

	@GetMapping("/success")
	public String successPage() {
		return "eventos/success";
	}

	@GetMapping
	public ModelAndView listar() {
		List<Evento> eventos = er.findAll();
		ModelAndView mv = new ModelAndView("eventos/lista");
		mv.addObject("eventos", eventos);
		return mv;
		
		
	}

}
