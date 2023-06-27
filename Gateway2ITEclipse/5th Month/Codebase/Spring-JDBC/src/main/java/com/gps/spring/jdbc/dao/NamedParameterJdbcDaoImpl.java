package com.gps.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.gps.spring.jdbc.model.Employee;

public class NamedParameterJdbcDaoImpl extends NamedParameterJdbcDaoSupport {

	/**
	 * Returning an employee based on Id using RowMapper Interface
	 * 'EmployeeMapper'
	 * 
	 * @param empId
	 * @return
	 */
	public Employee getEmployee(String empId) {
		String sql = "select * from Employee where EmpId = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", empId);
		return this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters, new EmployeeMapper());
	}

	/**
	 * Returning an employee based on Id using RowMapper Interface
	 * 'BeanPropertyRowMapper'
	 * 
	 * @param empId
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Employee getEmployeeUsingBeanPropertyRowMapper(String empId) {
		String sql = "select * from Employee where EmpId = :id";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", empId);
		return (Employee) this.getNamedParameterJdbcTemplate().queryForObject(sql, namedParameters,
				new BeanPropertyRowMapper(Employee.class));
	}

	/**
	 * 
	 * Created a EmployeeMapper Inner class which will help to O-R mapping
	 *
	 */
	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setEmpId(rs.getString("empid"));
			employee.setEmpName(rs.getString("empname"));
			employee.setEmpSalary(rs.getFloat("empsalary"));
			employee.setEmpAge(rs.getInt("empage"));
			return employee;
		}
	}
}
