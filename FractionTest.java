package hw7;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

//JUnit 4 Test
public class FractionTest {

	// Instance variables numerator & denominator
	private static int num;
	private static int den;

	// Create a fraction object and set epsilon
	Fraction fraction;
	double epsilon;

	// Set up initial fraction instance
	@Before
	public void setUp() {
		fraction = new Fraction(num,den);
		epsilon = 0.00000000001;
	}

	// Test reduceToLowestForm

	@Test
	public void testReduceToLowestFormWhenInLowestForm() {
		Fraction testFraction = new Fraction (2,3);
		testFraction.reduceToLowestForm(testFraction.numerator, 
				testFraction.denominator);
		assertTrue("Should return itself if already in lowest form", 
				testFraction.numerator == 2);
		assertTrue("Should return itself if already in lowest form", 
				testFraction.denominator == 3);
	}

	@Test
	public void testReduceToLowestFormWhenNotInLowestForm() {
		Fraction testFraction = new Fraction (4,16);
		testFraction.reduceToLowestForm(testFraction.numerator, 
				testFraction.denominator);
		assertTrue("Fraction should be reduced to lowest form", 
				testFraction.numerator == 1);
		assertTrue("Fraction should be reduced to lowest form", 
				testFraction.denominator == 4);
	}

	@Test
	public void testReduceToLowestFormWithNegative() {
		Fraction testFraction = new Fraction (3,-4);
		testFraction.reduceToLowestForm(testFraction.numerator, 
				testFraction.denominator);
		assertTrue("Negative signs should be moved to the numerator", 
				testFraction.numerator == -3);
		assertTrue("Negative signs should be moved to the numerator", 
				testFraction.denominator == 4);
	}

	@Test
	public void testReduceToLowestFormWithZero() {
		Fraction testFraction = new Fraction (0,5);
		testFraction.reduceToLowestForm(testFraction.numerator, 
				testFraction.denominator);
		assertTrue("0/n should be reduced to 0/1", 
				testFraction.numerator == 0);
		assertTrue("0/n should be reduced to 0/1", 
				testFraction.denominator == 1);
	}

	@Test
	public void testReduceToLowestFormWithConstants() {
		Fraction testFraction = new Fraction (49,7);
		testFraction.reduceToLowestForm(testFraction.numerator, 
				testFraction.denominator);
		assertTrue("Constants should be reduced to n/1", 
				testFraction.numerator == 7);
		assertTrue("Constants should be reduced to n/1", 
				testFraction.denominator == 1);
	}

	// Test add

	@Test
	public void testAddWhenResultInLowestForm() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(1, 3);
		Fraction addedFractions = fraction1.add(fraction2);
		assertTrue("Fractions should be added properly", 
				addedFractions.numerator == 2);
		assertTrue("Fractions should be added properly", 
				addedFractions.denominator == 3);
	}

	@Test
	public void testAddWhenResultNotInLowestForm() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(5, 3);
		Fraction addedFractions = fraction1.add(fraction2);
		assertTrue("Fractions should be reduced to lowest form", 
				addedFractions.numerator == 2);
		assertTrue("Fractions should be reduced to lowest form", 
				addedFractions.denominator == 1);
	}

	@Test
	public void testAddWhenResultIsZero() {
		Fraction fraction1 = new Fraction(-1, 3);
		Fraction fraction2 = new Fraction(1, 3);
		Fraction addedFractions = fraction1.add(fraction2);
		assertTrue("If fractions add to zero, result should be 0/1", 
				addedFractions.numerator == 0);
		assertTrue("If fractions add to zero, result should be 0/1", 
				addedFractions.denominator == 1);
	}

	@Test
	public void testAddWithNegatives() {
		Fraction fraction1 = new Fraction(4, -3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction addedFractions = fraction1.add(fraction2);
		assertTrue("Negative signs should be moved to numerator", 
				addedFractions.numerator == -2);
		assertTrue("Negative signs should be moved to numerator", 
				addedFractions.denominator == 3);
	}

	// Test subtract

	@Test
	public void testSubtractWhenResultInLowestForm() {
		Fraction fraction1 = new Fraction(2, 3);
		Fraction fraction2 = new Fraction(1, 3);
		Fraction subtractedFractions = fraction1.subtract(fraction2);
		assertTrue("Fractions should be subtracted properly", 
				subtractedFractions.numerator == 1);
		assertTrue("Fractions should be subtracted properly", 
				subtractedFractions.denominator == 3);
	}

	@Test
	public void testSubtractWhenResultNotInLowestForm() {
		Fraction fraction1 = new Fraction(13, 4);
		Fraction fraction2 = new Fraction(1, 4);
		Fraction subtractedFractions = fraction1.subtract(fraction2);
		assertTrue("Fractions should be reduced to lowest form", 
				subtractedFractions.numerator == 3);
		assertTrue("Fractions should be reduced to lowest form", 
				subtractedFractions.denominator == 1);
	}

	@Test
	public void testSubtractWhenResultIsZero() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(1, 3);
		Fraction subtractedFractions = fraction1.subtract(fraction2);
		assertTrue("If fractions subtract to zero, result should be 0/1", 
				subtractedFractions.numerator == 0);
		assertTrue("If fractions subtract to zero, result should be 0/1", 
				subtractedFractions.denominator == 1);
	}

	@Test
	public void testSubtractWhenResultIsNegative() {
		Fraction fraction1 = new Fraction(2, 3);
		Fraction fraction2 = new Fraction(3, 3);
		Fraction subtractedFractions = fraction1.subtract(fraction2);
		assertTrue("Negative signs should be moved to numerator",
				subtractedFractions.numerator == -1);
		assertTrue("Negative signs should be moved to numerator", 
				subtractedFractions.denominator == 3);
	}


	// Test multiply

	@Test
	public void testMultiplyWhenResultInLowestForm() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Fractions should be multiplied correctly", 
				multipliedFractions.numerator == 2);
		assertTrue("Fractions should be multiplied correctly", 
				multipliedFractions.denominator == 9);
	}

	@Test
	public void testMultiplyWhenResultNotInLowestForm() {
		Fraction fraction1 = new Fraction(3, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Fractions should be reduced to lowest form", 
				multipliedFractions.numerator == 2);
		assertTrue("Fractions should be reduced to lowest form", 
				multipliedFractions.denominator == 3);
	}

	@Test
	public void testMultiplyWhenDenIsNegative() {
		Fraction fraction1 = new Fraction(1, -3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Negative signs should be moved to numerator", 
				multipliedFractions.numerator == -2);
		assertTrue("Negative signs should be moved to numerator", 
				multipliedFractions.denominator == 9);
	}

	@Test
	public void testMultiplyWhenNumIsNegative() {
		Fraction fraction1 = new Fraction(-1, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Negative signs should be in numerator", 
				multipliedFractions.numerator == -2);
		assertTrue("Negative signs should be in numerator", 
				multipliedFractions.denominator == 9);
	}

	@Test
	public void testMultiplyWhenBothAreNegative() {
		Fraction fraction1 = new Fraction(1, -3);
		Fraction fraction2 = new Fraction(-2, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Two negative fractions should multiply to a positive fraction", 
				multipliedFractions.numerator == 2);
		assertTrue("Two negative fractions should multiply to a positive fraction", 
				multipliedFractions.denominator == 9);
	}

	@Test
	public void testMultiplyWithZero() {
		Fraction fraction1 = new Fraction(55, -3);
		Fraction fraction2 = new Fraction(0, 3);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("Any fraction multiplied by 0 should be 0/1", 
				multipliedFractions.numerator == 0);
		assertTrue("Any fraction multiplied by 0 should be 0/1", 
				multipliedFractions.denominator == 1);
	}

	@Test
	public void testMultiplyWithOne() {
		Fraction fraction1 = new Fraction(1, -3);
		Fraction fraction2 = new Fraction(1, 1);
		Fraction multipliedFractions = fraction1.mul(fraction2);
		assertTrue("A fraction multiplied by one is itself", 
				multipliedFractions.numerator == -1);
		assertTrue("A fraction multiplied by one is itself", 
				multipliedFractions.denominator == 3);
	}

	// Test divide
	@Test
	public void testDivideWhenInLowestForm() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction dividedFractions = fraction1.div(fraction2);
		assertTrue("Fractions should be divided properly", 
				dividedFractions.numerator == 1);
		assertTrue("Fractions should be divided properly", 
				dividedFractions.denominator == 2);
	}

	@Test
	public void testDivideWhenNotInLowestForm() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(5, 3);
		Fraction dividedFractions = fraction1.div(fraction2);
		assertTrue("Fractions should be reduced to lowest form", 
				dividedFractions.numerator == 1);
		assertTrue("Fractions should be reduced to lowest form", 
				dividedFractions.denominator == 5);
	}

	@Test
	public void testDivideWhenOneIsNegative() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(2, -3);
		Fraction dividedFractions = fraction1.div(fraction2);
		assertTrue("Negative signs should be in numerator", 
				dividedFractions.numerator == -1);
		assertTrue("Negative signs should be in numerator", 
				dividedFractions.denominator == 2);
	}

	@Test
	public void testDivideWhenBothAreNegative() {
		Fraction fraction1 = new Fraction(1, -3);
		Fraction fraction2 = new Fraction(-2, 3);
		Fraction dividedFractions = fraction1.div(fraction2);
		assertTrue("Two negative fractions divide to a positive result", 
				dividedFractions.numerator == 1);
		assertTrue("Two negative fractions divide to a positive result", 
				dividedFractions.denominator == 2);
	}

	@Test
	public void testDivideWhenResultIsOne() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(1, 3);
		Fraction dividedFractions = fraction1.div(fraction2);
		assertTrue("A fraction divided by itself results in 1/1", 
				dividedFractions.numerator == 1);
		assertTrue("A fraction divided by itself results in 1/1", 
				dividedFractions.denominator == 1);
	}

	// Test decimal
	@Test
	public void testDecimal() {
		Fraction fraction = new Fraction(1, 4);
		double expected = 0.25;
		assertEquals("Decimal should be positive when fraction is positive",
				expected, fraction.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithNegative() {
		Fraction fraction = new Fraction(1, -4);
		double expected = -0.25;
		assertEquals("Decimal should be negative when fraction is negative",
				expected, fraction.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithZero() {
		Fraction fraction = new Fraction(0, 1);
		double expected = 0.00;
		assertEquals("Decimal should be 0.0 when fraction is 0",
				expected, fraction.decimal(), epsilon);
	}

	@Test
	public void testDecimalWithRepeatingNumber() {
		Fraction fraction = new Fraction(1, -3);
		double expected = -0.33333333333;
		assertEquals("Decimal should have repeating digits",
				expected, fraction.decimal(), epsilon);
	}

	// Test sqr
	@Test
	public void testSqr() {
		Fraction fraction = new Fraction(1, 3);
		fraction.sqr();
		assertTrue("Fraction should be squared properly", 
				fraction.numerator == 1);
		assertTrue("Fraction should be squared properly", 
				fraction.denominator == 9);
	}

	@Test
	public void testSqrResultNotInLowestForm() {
		Fraction fraction = new Fraction(2, 4);
		fraction.sqr();
		assertTrue("Fraction should NOT be reduced to lowest form", 
				fraction.numerator == 4);
		assertTrue("Fraction should NOT be reduced to lowest form", 
				fraction.denominator == 16);
	}

	@Test
	public void testSqrWithNegativeDenominator() {
		Fraction fraction = new Fraction(1, -4);
		fraction.sqr();
		assertTrue("Any integer squared is positive", 
				fraction.numerator == 1);
		assertTrue("Any integer squared is positive", 
				fraction.denominator == 16);
	}

	@Test
	public void testSqrWithBothNegative() {
		Fraction fraction = new Fraction(-3, -4);
		fraction.sqr();
		assertTrue("Any integer squared is positive", 
				fraction.numerator == 9);
		assertTrue("Any integer squared is positive", 
				fraction.denominator == 16);
	}

	@Test
	public void testSqrWithZero() {
		Fraction fraction = new Fraction(0, 4);
		fraction.sqr();
		assertTrue("Zero squared is zero", 
				fraction.numerator == 0);
		assertTrue("Zero squared is zero", 
				fraction.denominator == 16);
	}

	// Test toString

	@Test
	public void testToString() {
		Fraction testFraction = new Fraction(1, 3);
		String expected = "1/3";
		assertEquals("Should return the fraction as a string",
				expected, testFraction.toString());
	}

	@Test
	public void testToStringOneNegative() {
		Fraction testFraction = new Fraction(1, -3);
		String expected = "-1/3";
		assertEquals("Should return the negative sign in numerator",
				expected, testFraction.toString());
	}

	@Test
	public void testToStringBothNegative() {
		Fraction testFraction = new Fraction(-1, -3);
		String expected = "1/3";
		assertEquals("Should return the negative sign in numerator",
				expected, testFraction.toString());
	}

	@Test
	public void testToStringWithZero() {
		Fraction testFraction = new Fraction(0, -3);
		String expected = "0/3";
		assertEquals("Should get rid of the negative sign if fraction of form 0/n",
				expected, testFraction.toString());
	}

	// Test average (two fractions)

	@Test
	public void testAverage() {
		Fraction fraction1 = new Fraction(1, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction avgFractions = fraction1.average(fraction2);
		assertTrue("Fractions should be averaged properly", 
				avgFractions.numerator == 1);
		assertTrue("Fractions should be averaged properly", 
				avgFractions.denominator == 2);
	}

	@Test
	public void testAvgWhenOneIsZero() {
		Fraction fraction1 = new Fraction(0, 3);
		Fraction fraction2 = new Fraction(2, 3);
		Fraction avgFractions = fraction1.average(fraction2);
		assertTrue("Fractions should be averaged properly when one is zero", 
				avgFractions.numerator == 1);
		assertTrue("Fractions should be averaged properly when one is zero",
				avgFractions.denominator == 3);
	}

	@Test
	public void testAverageWhenBothZero() {
		Fraction fraction1 = new Fraction(0, 6);
		Fraction fraction2 = new Fraction(0, 4);
		Fraction avgFractions = fraction1.average(fraction2);
		assertTrue("Average of two zero fractions should be zero", 
				avgFractions.numerator == 0);
		assertTrue("Average of two zero fractions should be zero", 
				avgFractions.denominator == 1);
	}

	@Test
	public void testAverageWithOneNegative() {
		Fraction fraction1 = new Fraction(-5, 8);
		Fraction fraction2 = new Fraction(2, 9);
		Fraction avgFractions = fraction1.average(fraction2);
		assertTrue("Fractions should be averaged properly when one is negative", 
				avgFractions.numerator == -29);
		assertTrue("Fractions should be averaged properly when one is negative", 
				avgFractions.denominator == 144);
	}

	@Test
	public void testAverageWithBothNegative() {
		Fraction fraction1 = new Fraction(-1, 6);
		Fraction fraction2 = new Fraction(2, -3);
		Fraction avgFractions = fraction1.average(fraction2);
		assertTrue("Fractions should be averaged properly when both are negative",
				avgFractions.numerator == -5);
		assertTrue("Fractions should be averaged properly when both are negative",
				avgFractions.denominator == 12);
	}

	// Test average (fraction array)

	@Test
	public void testAverageFractionArrayWhenEmpty() {
		Fraction[] fractions = {};
		Fraction avgFractions = fraction.average(fractions);
		assertTrue("Average of an empty array should be 0/1",
				avgFractions.numerator == 0);
		assertTrue("Average of an empty array should be 0/1",
				avgFractions.denominator == 1);
	}


	@Test
	public void testAverageFractionArrayWithOneElement() {
		Fraction fraction1 = new Fraction(1,2);
		Fraction[] fractions = {fraction1};
		Fraction avgFractions = fraction.average(fractions);
		assertTrue("Average of a one-element array should be that element", 
				avgFractions.numerator == 1);
		assertTrue("Average of a one-element array should be that element",
				avgFractions.denominator == 2);
	}

	@Test
	public void testAverageFractionArrayOfSameElements() {
		Fraction fraction1 = new Fraction(1,2);
		Fraction fraction2 = new Fraction(1,2);
		Fraction fraction3 = new Fraction(1,2);
		Fraction[] fractions = {fraction1, fraction2, fraction3};
		Fraction avgFractions = fraction.average(fractions);
		assertTrue("Average of an array of all the same elements should be that element",
				avgFractions.numerator == 1);
		assertTrue("Average of an array of all the same elements should be that element",
				avgFractions.denominator == 2);
	}

	@Test
	public void testAverageFractionArrayOfDifferentElements() {
		Fraction fraction1 = new Fraction(1,2);
		Fraction fraction2 = new Fraction(3,5);
		Fraction fraction3 = new Fraction(6,8);
		Fraction[] fractions = {fraction1, fraction2, fraction3};
		Fraction avgFractions = fraction.average(fractions);
		assertTrue("Takes the average properly",
				avgFractions.numerator == 37);
		assertTrue("Takes the average properly",
				avgFractions.denominator == 60);
	}

	// Test average (integer array)

	@Test
	public void testAverageIntegerArrayWhenEmpty() {
		int[] fractions = {};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Average of an empty array should be 0/1",
				avgInteger.numerator == 0);
		assertTrue("Average of an empty array should be 0/1",
				avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayWithOneElement() {
		int[] fractions = {3};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Average of a one-element array should be that element", 
				avgInteger.numerator == 3);
		assertTrue("Average of a one-element array should be that element", 
				avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayWithSameElements() {
		int[] fractions = {3,3,3};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Average of an array of all the same elements should be that element",
				avgInteger.numerator == 3);
		assertTrue("Average of an array of all the same elements should be that element",
				avgInteger.denominator == 1);
	}

	@Test
	public void testAverageIntegerArrayOfPositives() {
		int[] fractions = {51, 101, 602, 71, 51, 0, 34, 51, 9};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Takes the average of positive elements properly",
				avgInteger.numerator == 970);
		assertTrue("Takes the average of positive elements properly",
				avgInteger.denominator == 9);
	}

	@Test
	public void testAverageIntegerArrayOfNegatives() {
		int[] fractions = {-51, -101, -602, -71, -51, 0, -34, -51, -9};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Takes the average of negative elements properly",
				avgInteger.numerator == -970);
		assertTrue("Takes the average of negative elements properly",
				avgInteger.denominator == 9);
	}

	@Test
	public void testAverageIntegerArrayPositivesAndNegatives() {
		int[] fractions = {-5, 2, -6, 7, 0};
		Fraction avgInteger = fraction.average(fractions);
		assertTrue("Takes the average of both negative & positive elements properly",
				avgInteger.numerator == -2);
		assertTrue("Takes the average of both negative & positive elements properly",
				avgInteger.denominator == 5);
	}

}