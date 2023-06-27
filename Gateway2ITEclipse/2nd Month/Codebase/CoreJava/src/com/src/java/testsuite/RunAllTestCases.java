package com.src.java.testsuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.src.java.testables.junit.DomainUtilsTest;
import com.src.java.testables.junit.MathUtilsTest;
import com.src.java.testables.junit.RandomEmailGeneratorTest;
import com.src.java.testables.junit.RectangleTest;

@RunWith(Suite.class)
@SuiteClasses({ RectangleTest.class, RandomEmailGeneratorTest.class, MathUtilsTest.class, DomainUtilsTest.class })
public class RunAllTestCases {
}
