package com.bolsadeideas.springboot.app.models.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.app.models.dao.ClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Cliente> findAll() {
		return jdbcTemplate.query("SELECT * FROM CLIENTES", BeanPropertyRowMapper.newInstance(Cliente.class));
	}

	@Override
	public List<Cliente> findByNombre(String term) {
		String sql = "select * from CLIENTES where (UPPER(nombre) like UPPER ('%" + term
				+ "%') or UPPER(apellido) like UPPER ('%" + term + "%'))";
		// Map<String, Object> params = new HashMap<String, Object>();

		// params.put("name", term+"%");
		return jdbcTemplate.query(sql, new ClienteMapper());

	}

	private static final class ClienteMapper implements RowMapper<Cliente> {
		@Override
		public Cliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Cliente c = new Cliente();
			c.setId(resultSet.getLong("id"));
			c.setNombre(resultSet.getString("nombre"));
			return c;
		}
	}

	@Override
	public Cliente findById(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM CLIENTES WHERE ID = ?",
				BeanPropertyRowMapper.newInstance(Cliente.class), id);

	}

	@Override
	public void save(Cliente cliente) {
		jdbcTemplate.update("INSERT INTO clientes (id, nombre, apellido, email, create_at) VALUES(?,?,?,?,?)",
				new Object[] { cliente.getId(), cliente.getNombre(), cliente.getApellido(), cliente.getEmail(),
						cliente.getCreateAt() });

	}

	@Override
	public Cliente finlogin(String mombre, String apellido) {
		try {
			return jdbcTemplate.queryForObject("SELECT * FROM CLIENTES WHERE NOMBRE = ?",
					BeanPropertyRowMapper.newInstance(Cliente.class), mombre);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

}
