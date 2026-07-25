package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary {
	private String number = "0"; // string containing the binary value '0' or '1'

	/**
	 * A constructor that generates a binary object.
	 *
	 * @param number a String of the binary values. It should contain only zeros or
	 *               ones with any length and order. otherwise, the value of "0"
	 *               will be stored. Trailing zeros will be excluded and empty
	 *               string will be considered as zero.
	 */
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}

		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}

		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}

		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);

		// uncomment the following code
		/*
		 * if (this.number.isEmpty()) { // replace empty strings with a single zero
		 * this.number = "0";
		 * }
		 */
	}

	/**
	 * Return the binary value of the variable
	 *
	 * @return the binary value in a string format.
	 */
	public String getValue() {
		return this.number;
	}

	/**
	 * Adding two binary variables. For more information, visit
	 * <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers
	 * </a>.
	 *
	 * @param num1 The first addend object
	 * @param num2 The second addend object
	 * @return A binary variable with a value of <i>num1+num2</i>.
	 */
	public static Binary add(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		// initial variable
		int carry = 0;
		String num3 = ""; // the binary value of the sum
		while (ind1 >= 0 || ind2 >= 0 || carry != 0) // loop until all digits are processed
		{
			int sum = carry; // previous carry
			if (ind1 >= 0) { // if num1 has a digit to add
				sum += (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				sum += (num2.number.charAt(ind2) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind2--; // update ind2
			}
			carry = sum / 2; // the new carry
			sum = sum % 2; // the resultant digit
			num3 = ((sum == 0) ? "0" : "1") + num3; // convert sum to string and append it to num3
		}
		Binary result = new Binary(num3); // create a binary object with the calculated value.
		return result;

	}

	/**
	 * OR two binary variables.
	 *
	 * @param num1 The first operand object
	 * @param num2 The second operand object
	 * @return A binary variable with a value of <i>num1 OR num2</i>.
	 */
	public static Binary or(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // the binary value of the OR
		while (ind1 >= 0 || ind2 >= 0) // loop until all digits are processed
		{
			int or_val = 0; // previous carry
			int val2 = 0;
			if (ind1 >= 0) { // if num1 has a digit to add
				or_val = (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				val2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
				ind2--; // update ind2
			}
			or_val = (or_val == val2) ? or_val : 1; // if both are same, set as or_val, else set as 1
			num3 = ((or_val == 0) ? "0" : "1") + num3; // convert or_val to string and append it to num3
		}
		Binary result = new Binary(num3); // create a binary object with the calculated value.
		return result;

	}

	/**
	 * AND two binary variables.
	 *
	 * @param num1 The first operand object
	 * @param num2 The second operand object
	 * @return A binary variable with a value of <i>num1 AND num2</i>.
	 */
	public static Binary and(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length() - 1;
		int ind2 = num2.number.length() - 1;
		String num3 = ""; // the binary value of the AND
		while (ind1 >= 0 || ind2 >= 0) // loop until all digits are processed
		{
			int and_val = 0; // previous carry
			int val2 = 0;
			if (ind1 >= 0) { // if num1 has a digit to add
				and_val = (num1.number.charAt(ind1) == '1') ? 1 : 0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if (ind2 >= 0) { // if num2 has a digit to add
				val2 = (num2.number.charAt(ind2) == '1') ? 1 : 0;
				ind2--; // update ind2
			}
			and_val = (and_val == 1 && val2 == 1) ? 1 : 0; // if both are 1, set as 1, else set as 0
			num3 = ((and_val == 0) ? "0" : "1") + num3; // convert and_val to string and append it to num3
		}
		Binary result = new Binary(num3); // create a binary object with the calculated value.
		return result;

	}

	/**
	 * Multiply two binary variables.
	 *
	 * @param num1 The first operand object
	 * @param num2 The second operand object
	 * @return A binary variable with a value of <i>num1 * num2</i>.
	 */
	public static Binary multiply(Binary num1, Binary num2) {
		Binary result = new Binary("0"); // Initialize result as 0
		String num1_str = num1.getValue();
		String num2_str = num2.getValue();

		// Iterate through the second number from right to left (least significant bit
		// first)
		for (int i = num2_str.length() - 1; i >= 0; i--) {
			// If the current bit is 1, add the shifted num1 to the result
			if (num2_str.charAt(i) == '1') {
				Binary temp = new Binary(num1_str);
				result = Binary.add(result, temp);
			}

			// Shift num1 to the left (append a 0) for the next bit position
			num1_str += "0";
		}

		return result;
	}
}
