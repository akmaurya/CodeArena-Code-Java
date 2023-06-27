package com.src.java.testables.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.src.java.testables.DomainUtils;

//@RunWith(value = Parameterized.class)
public class DomainUtilsTest {

//	public DomainUtilsTest(String domain, Boolean expected) {
//		this.domain = domain;
//		this.expected = expected;
//	}

//	@Parameters
//	public static Iterable<Object[]> data() {
//		return Arrays.asList(new Object[][] { { "google.com", true }, { "mkyong.com", true }, { "-mkyong.com", false },
//				{ "mkyong-.com", false }, { "3423kjk", false }, { "mk#$kdo.com", false } });
//	}

	@Test
	public void testValidateCorrectDomainName() {
		assertEquals("Failing test case for correct domain name", true, DomainUtils.isValidDomainName("www.google.com"));
	}
	
	@Test
	public void testValidateInCorrectDomainName() {
		assertEquals("Failing test case for in correct domain name", false, DomainUtils.isValidDomainName("mk#$kdo.com"));
	}
}
