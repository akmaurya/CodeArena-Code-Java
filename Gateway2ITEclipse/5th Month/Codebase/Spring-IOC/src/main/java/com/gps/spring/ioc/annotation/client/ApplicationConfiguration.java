package com.gps.spring.ioc.annotation.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gps.spring.ioc.annotation.dao.EmployeeDAO;
import com.gps.spring.ioc.annotation.dao.IEmployeeDAO;

@Configuration
public class ApplicationConfiguration {
	@Bean(name="employeeDAO")
    public IEmployeeDAO employeeDAO() {
        return new EmployeeDAO();
    }
}
