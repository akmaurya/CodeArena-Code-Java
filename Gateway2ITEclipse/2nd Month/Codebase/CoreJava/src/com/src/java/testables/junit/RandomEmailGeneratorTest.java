package com.src.java.testables.junit;

import org.junit.Assert;
import org.junit.Test;

import com.src.java.testables.RandomEmailGenerator;

public class RandomEmailGeneratorTest {
	@Test()
	public void testEmailGenerator() {

		RandomEmailGenerator obj = new RandomEmailGenerator();
		String email = obj.generate();

		Assert.assertNotNull(email);
		Assert.assertEquals(email, "feedback@yoursite.com");
	}
}
