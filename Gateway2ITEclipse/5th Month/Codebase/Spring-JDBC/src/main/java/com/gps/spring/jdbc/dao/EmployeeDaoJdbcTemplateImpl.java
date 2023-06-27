package com.gps.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.gps.spring.jdbc.model.Employee;

@Component
public class EmployeeDaoJdbcTemplateImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	/**
	 * Returning count of employees
	 * 
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public int getEmployeeCount() {
		String sql = "select count(*) from Employee";
		return jdbcTemplate.queryForInt(sql);
	}

	/**
	 * Returning name of an employee based on Id
	 * 
	 * @param empId
	 * @return
	 */
	public String getEmployeeName(String empId) {
		String sql = "select EmpName from Employee where EmpId = ?";
		return jdbcTemplate.queryForObject(sql, String.class, new Object[] { empId });
	}

	/**
	 * Returning an employee based on Id using RowMapper Interface
	 * 'EmployeeMapper'
	 * 
	 * @param empId
	 * @return
	 */
	public Employee getEmployee(String empId) {
		String sql = "select * from Employee where EmpId = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] { empId }, new EmployeeMapper());
	}

	/**
	 * Returning employee List using RowMapper Interface 'EmployeeMapper'
	 * 
	 * @param empId
	 * @return
	 */
	public List<Employee> getEmployeeList() {
		String sql = "select * from Employee";
		return jdbcTemplate.query(sql, new EmployeeMapper());
	}

	/**
	 * Insert an employee
	 * 
	 * @param emp
	 */
	public void addEmployee(Employee emp) {
		String sql = "insert into employee values (?, ?, ?, ?)";
		jdbcTemplate
				.update(sql, new Object[] { emp.getEmpId(), emp.getEmpName(), emp.getEmpSalary(), emp.getEmpAge() });
	}

	/**
	 * Insert an employee using Named Parameter
	 * 
	 * @param emp
	 */
	public void addEmployeeWithNamedParameter(Employee emp) {
		String sql = "insert into employee values (:id, :name, :salary, :age)";
		SqlParameterSource namedParameters = new MapSqlParameterSource("id", emp.getEmpId())
				.addValue("name", emp.getEmpName()).addValue("age", emp.getEmpAge())
				.addValue("salary", emp.getEmpSalary());
		namedParameterJdbcTemplate.update(sql, namedParameters);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
