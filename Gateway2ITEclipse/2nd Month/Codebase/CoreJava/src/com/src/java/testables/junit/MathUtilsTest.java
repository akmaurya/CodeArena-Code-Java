package com.src.java.testables.junit;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.src.java.testables.MathUtils;

/**
 * The custom runner Parameterized implements parameterized tests. When running
 * a parameterized test class, instances are created for the cross-product of
 * the test methods and the test data elements.
 * 
 * @author GPS
 * 
 */
@RunWith(value = Parameterized.class)
public class MathUtilsTest {
	private int numberA;
	private int numberB;
	private int expected;

	// parameters pass via this constructor
	public MathUtilsTest(int numberA, int numberB, int expected) {
		this.numberA = numberA;
		this.numberB = numberB;
		this.expected = expected;
	}

	// Declares parameters here
	@Parameters
	public static Iterable<Object[]> data1() {
		return Arrays.asList(new Object[][] { { 1, 1, 2 }, { 2, 2, 4 }, { 8, 2, 10 }, { 4, 5, 9 } });
	}

	@Test
	public void test_add() {
		assertEquals(expected, MathUtils.add(numberA, numberB));
	}
}
