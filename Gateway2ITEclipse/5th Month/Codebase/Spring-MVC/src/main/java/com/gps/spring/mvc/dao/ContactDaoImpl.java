package com.gps.spring.mvc.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.gps.spring.mvc.model.Contact;

/**
 * Contact DAO Implementation
 * 
 * @author GPS
 *
 */
@Repository
public class ContactDaoImpl extends NamedParameterJdbcDaoSupport implements ContactDao {

	@Override
	public void addContact(Contact contact) {
		String sql = "insert into Contact (ID, FIRSTNAME, LASTNAME, TELEPHONE, EMAIL) values (:id, :fName, :lName, :phone, :email)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", contact.getId())
				.addValue("fName", contact.getFirstName()).addValue("lName", contact.getLastName())
				.addValue("phone", contact.getTelephone()).addValue("email", contact.getEmail());
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Contact> listContact() {
		String sql = "select * from Contact";
		return this.getNamedParameterJdbcTemplate().query(sql, new BeanPropertyRowMapper(Contact.class));
	}

	@Override
	public void removeContact(Integer id) {
		String sql = "DELETE FROM CONTACT WHERE ID = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", id);
		this.getNamedParameterJdbcTemplate().update(sql, namedParameters);
	}
}
