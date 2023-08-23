package com.fssa.spartansmt.regexpattern;

/*
 * @author MathankumarNagarajan
 * 
 * An interface which holds Regex Patterns Variables.
 * It has only hold the regex patterns used in the Store Module.
 */
public class StoreRegexPatterns {
	
	private StoreRegexPatterns() {
		// Private defulat constructor
	}

	/*
	 * IMAGE REGEX Pattern is Used to validate the Image URL.
	 */
	public static final String IMAGE_REGEX = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg|webp))";

}
