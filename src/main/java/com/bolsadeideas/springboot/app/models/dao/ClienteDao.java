package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import com.bolsadeideas.springboot.app.models.entity.Cliente;



public interface ClienteDao {
	public List<Cliente> findAll(); 
	public List<Cliente> findByNombre(String term); 
	public Cliente findById(int id); 
	public void save (Cliente  cliente); 
	public Cliente finlogin (String mombre ,  String apellido); 

}
