package hw7;

public class Fraction {

	// Instance variables numerator & denominator
	int numerator;
	int denominator;

	// Fraction constructor
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	/*
	 * Helper method:
	 * find the greatest common divisor (GCD) of two integers
	 */
	private static int gcd(int int1, int int2) {
		while (int1 != 0 && int2 != 0) {
			int c = int2;
			int2 = int1 % int2;
			int1 = c;
		}
		// Return the absolute value of the GCD
		return Math.abs(int1 + int2);
	}

	/*
	 * Reduces the current fraction by eliminating common factors
	 */
	void reduceToLowestForm(int n, int d) {
		// Find GCD of numerator & denominator
		int theGcd = gcd(n, d);
		if (d < 0) {
			denominator = (-1 * d) / theGcd;
			numerator = (-1 * n) / theGcd;
		}
		else {
			denominator = (d / theGcd);
			numerator = (n / theGcd);
		}
	}

	/*
	 * Adds the current fraction to the otherFraction,
	 * returns a new Fraction that is the sum of the two Fractions
	 */
	Fraction add(Fraction otherFraction) {
		// Cross multiply the numerators & denominators and subtract
		int newNum = (this.numerator * otherFraction.denominator) + 
				(otherFraction.numerator * this.denominator);
		// Multiply denominators together to get a common denominator
		int newDen = this.denominator * otherFraction.denominator;
		// Create a new Fraction object
		Fraction newFraction = new Fraction (newNum, newDen);
		// Reduce it to lowest form
		newFraction.reduceToLowestForm(newFraction.numerator, newFraction.denominator);
		// Return the new fraction
		return newFraction;
	}

	/*
	 * Subtract otherFraction from the current fraction,
	 * i.e. thisFraction - otherFraction
	 */
	Fraction subtract(Fraction otherFraction) {
		// Create a negative one fraction
		Fraction negativeOne = new Fraction(-1,1);
		// Add the first fraction and negativeOne * the second fraction
		Fraction subtractedFractions = this.add(negativeOne.mul(otherFraction));
		// Reduce and return the resulting fraction
		return subtractedFractions;
	}

	/*
	 * Multiply the current fraction by the otherFraction
	 */
	Fraction mul(Fraction otherFraction) {
		// Multiply the numerators
		int newNum = this.numerator * otherFraction.numerator;
		// Multiply the denominators
		int newDen = this.denominator * otherFraction.denominator;
		// Reduce and return the resulting fraction
		// Create a new Fraction object
		Fraction newFraction = new Fraction (newNum, newDen);
		// Reduce it to lowest form
		newFraction.reduceToLowestForm(newFraction.numerator, newFraction.denominator);
		// Return the new fraction
		return newFraction;
	}

	/*
	 * Divide the current fraction by the otherFraction
	 */
	Fraction div(Fraction otherFraction) {
		// Multiply Fraction by the inverse of otherFraction to divide
		int newNum = this.numerator * otherFraction.denominator;
		// Multiply the denominators
		int newDen = this.denominator * otherFraction.numerator;
		// Reduce and return the resulting fraction
		// Create a new Fraction object
		Fraction newFraction = new Fraction (newNum, newDen);
		// Reduce it to lowest form
		newFraction.reduceToLowestForm(newFraction.numerator, newFraction.denominator);
		// Return the new fraction
		return newFraction;
	}

	/*
	 * Returns this fraction in decimal form
	 */
	double decimal() {
		// Divide the numerator by the denominator normally,
		// but convert one to a double so the result is a double
		return (double) numerator / denominator;
	}

	/*
	 * Squares the current fraction (modifies the current fraction),
	 * but doesn't reduce the fraction
	 */
	void sqr() {
		// Square both the numerator and denominator of the current fraction
		int newNum = (int) numerator * numerator;
		int newDen = (int) denominator * denominator;
		// Set the numerator and denominator to the results
		numerator = newNum;
		denominator = newDen;
	}

	/*
	 * Returns a string representation of the current fraction
	 */
	public String toString() {
		// Resolve negatives in the denominator by multiplying both the
		// numerator & denominator by (-1)
		if (denominator < 0) {
			denominator = (-1 * denominator);
			numerator = (-1 * numerator);
		}
		// Return the result as a string
		return(numerator + "/" + denominator);
	}

	/*
	 * Averages the current fraction with the otherFraction
	 */
	Fraction average(Fraction otherFraction) {
		// Add the two fractions together
		Fraction addedFractions = this.add(otherFraction);
		// Create a fraction 2/1
		Fraction twoFraction = new Fraction(2, 1);
		// Divide the result by twoFraction to get the average
		Fraction averagedFractions = addedFractions.div(twoFraction);
		// Reduce it to lowest form
		averagedFractions.reduceToLowestForm(averagedFractions.numerator, averagedFractions.denominator);
		// Return the new fraction
		return averagedFractions;
	}

	/*
	 * Averages all fractions in the array
	 */
	Fraction average(Fraction[] fractions) {
		// First check whether the array is empty;
		// if so, return the fraction 0/1
		if (fractions.length == 0) {
			return new Fraction (0,1);
		}
		else {
			// Initialize a zero-valued fraction as the start of our sum
			Fraction fractionSum = new Fraction(0,1);
			//Fraction theSum = fractionSum.add(fractions[0]);
			// Iteratively add each fraction in the array to the sum
			for (int i = 0; i < fractions.length; i++) {
				fractionSum = fractionSum.add(fractions[i]);
			}
			// Get the length of the fractions array and turn it into a fraction object
			Fraction fractionLength = new Fraction(fractions.length, 1);
			// Divide the fraction sum by the length of the fraction array
			Fraction theAverage = fractionSum.div(fractionLength);
			// Reduce it to lowest form
			theAverage.reduceToLowestForm(theAverage.numerator, theAverage.denominator);
			// Return a new fraction object
			return new Fraction(theAverage.numerator, theAverage.denominator);
		}
	}

	/*
	 * Averages all integers in the array
	 */
	Fraction average(int[] ints) {
		// First check whether the array is empty;
		// if so, return the fraction 0/1
		if (ints.length == 0) {
			return new Fraction(0,1);
		}
		else {
			// Initialize an empty list of Fractions to which we can add
			// fractions that result from the integer list
			Fraction[] fractions = new Fraction[ints.length];
			// Iterate through the integer list, convert each element to a fraction
			// and add it to the fractions list
			for (int i = 0; i < ints.length; i++) {
				fractions[i] = new Fraction(ints[i],1);
			}
			// Average all fractions in the fractions array
			Fraction theAverage = average(fractions);
			// Reduce it to lowest form
			theAverage.reduceToLowestForm(theAverage.numerator, theAverage.denominator);
			// Return a new fraction object
			return new Fraction(theAverage.numerator, theAverage.denominator);
		}
	}
}