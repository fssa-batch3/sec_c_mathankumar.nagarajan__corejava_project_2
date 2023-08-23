package com.fssa.spartansmt.regexpattern;

/*
 * @author MathankumarNagarajan
 * 
 * An interface which holds the regex pattern of the Product Module Object
 */

public class ProductRegexPatterns {
	
	private ProductRegexPatterns() {
		// private constructor
	}

	/*
	 * IMAGE REGEX Pattern Use to validate the Image URL.
	 */
	public static final String IMAGE_REGEX = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg|webp))";

}
