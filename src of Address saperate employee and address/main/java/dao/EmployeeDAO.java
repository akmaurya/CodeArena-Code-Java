package dao;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import beans.employee.Employee;

@Component
public class EmployeeDAO{
	private static ArrayList<Employee> employee;
	
	public EmployeeDAO(){
		employee = new ArrayList<Employee>();
	}
	public static ArrayList<Employee> getEmployee() {
		return employee;
	}
	public static void setEmployee(Employee employee) {
		EmployeeDAO.employee.add(employee);
	}
	
	
}



















/*@Component
public class EmployeeDAO {
	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int save(Employee p) {
		String sql = "insert into Emp99(name,salary,designation) values('" + p.getName() + "'," + p.getSalary() + ",'"
				+ p.getDesignation() + "')";
		return template.update(sql);
	}

	public int update(Employee p) {
		String sql = "update Emp99 set name='" + p.getName() + "', salary=" + p.getSalary() + ",designation='"
				+ p.getDesignation() + "' where id=" + p.getId() + "";
		return template.update(sql);
	}

	public int delete(int id) {
		String sql = "delete from Emp99 where id=" + id + "";
		return template.update(sql);
	}

	public Employee getEmpById(int id) {
		String sql = "select * from Emp99 where id=?";
		return template.queryForObject(sql, new Object[] { id }, new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	public List<Employee> getEmployees() {
		return template.query("select * from Emp99", new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int row) throws SQLException {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getFloat(3));
				e.setDesignation(rs.getString(4));
				return e;
			}
		});
	}
}*/