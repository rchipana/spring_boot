package com.bolsadeideas.springboot.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.ClienteService;

@Controller
@SessionAttributes("cliente")
public class IndexController {

	@Autowired
	private ClienteService clienteService;

	@Value("${application.controller.titulo}")
	private String titulo;
	/*
	 * @GetMapping("/index") public String index(Model model) {
	 * model.addAttribute("titulo", this.titulo); return "index"; }
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginForm() throws Exception {
		return "login";
	}

	@SuppressWarnings("unused")
	@PostMapping(value = "/login")
	public String validarUsuario(@RequestParam String nombre, @RequestParam String apellido, HttpSession session,
			Model model) throws Exception {

		Cliente cliente = this.clienteService.finlogin(nombre, apellido);
		System.out.println(cliente.getNombre() + "---------------->>>>>>>>>>>>");

		if (cliente == null) {
			model.addAttribute("error", "eroorrrrrrrrrrrrrrrrrrrr");
			return "redirect:/login";
		}
		session.setAttribute("cliente", cliente);
		session.setAttribute("fecha", parsearFecha(new Date()));

		return "redirect:/listar";

	}

	public String parsearFecha(Date d) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String formattedDate = formatter.format(d);
		return formattedDate;
		
	}

}
