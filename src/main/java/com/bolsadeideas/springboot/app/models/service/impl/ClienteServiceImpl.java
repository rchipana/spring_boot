package com.bolsadeideas.springboot.app.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.app.models.dao.ClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteDao clienteDao;

	@Override
	public List<Cliente> findAll() {

		return clienteDao.findAll();
	}

	@Override
	public List<Cliente> findByNombre(String term) {
		return clienteDao.findByNombre(term);

	}

	@Override
	public Cliente findById(int id) {
		return clienteDao.findById(id);
	}

	@Override
	public void save(Cliente cliente) {
		clienteDao.save(cliente);

	}

	@Override
	public Cliente finlogin(String mombre, String apellido) {
		Cliente c = clienteDao.finlogin(mombre, apellido);
		
		if (c != null) {
			if (c.getApellido().equals(apellido)) {
				System.out.println(c.getNombre() + "---------------->>>>>>>>>>>>");
				return c;
			}
		}
		
		return null;
		
	}

}
