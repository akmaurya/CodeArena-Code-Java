package com.c1India.loginVerification.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Staff {
	private String name;
	private Integer age;
	private String[] position; // Array
	private List<String> skills; // List
	private Map<String, BigDecimal> salary; // Map
}
