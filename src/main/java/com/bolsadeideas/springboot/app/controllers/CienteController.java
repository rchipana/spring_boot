package com.bolsadeideas.springboot.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.ClienteService;

@Controller
@SessionAttributes("cliente")
public class CienteController {
	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "listar";
	}

	@GetMapping(value = "/cargar_clientes/{term}", produces = { "application/json" })
	public @ResponseBody List<Cliente> cargarProductos(@PathVariable String term) {
	
		List<Cliente> lt = clienteService.findByNombre(term);
		for (Cliente item : lt) {
			System.out.println(item.getNombre() + "---------------->>>>>>>>>>>>");
		}
		return clienteService.findByNombre(term);
	}

	@GetMapping(value = "/buscar_clientes/{id}", produces = { "application/json" })
	public @ResponseBody Cliente buscar_clientes(@PathVariable int id) {
		Cliente c = clienteService.findById(id);
		return c;
	}
	
	@PostMapping("/save")
	public String save(Cliente c){
		clienteService.save(c);
		System.out.println(c.getId() + "---el id del cliente creado------------>>>>>>>>>>>>");
		return "redirect:/listar";
	}
}
