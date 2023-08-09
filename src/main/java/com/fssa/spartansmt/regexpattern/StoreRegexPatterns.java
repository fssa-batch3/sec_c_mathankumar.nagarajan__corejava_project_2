package com.fssa.spartansmt.regexpattern;

public class StoreRegexPatterns {
	private StoreRegexPatterns() {
//	private constructor
	}

	/*
	 * IMAGE REGEX Pattern is Used to validate the Image URL.
	 */
	public static final String IMAGE_REGEX = "(http)?s?:?(\\/\\/[^\"']*\\.(?:png|jpg|jpeg|gif|png|svg|webp))";

}
