package com.bolsadeideas.springboot.app.models.service;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;


public interface ClienteService {
	public List<Cliente> findAll(); 
	public List<Cliente> findByNombre(String term); 
	public Cliente findById(int id); 
	public void save (Cliente  cliente); 
	public Cliente finlogin (String mombre ,  String apellido); 
}
