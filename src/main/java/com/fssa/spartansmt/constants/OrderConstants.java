package com.fssa.spartansmt.constants;


/*
 * @author MathankumarNagarajan
 * 
 * An interface which hold the constants variables for order model object
 * it has constants integer values.
 */

public class OrderConstants {
	
	private OrderConstants() {
		// Private Constructor
	}
	
	/*
	 * The Max Invalid User Id is Zero.
	 */
	public static final int MAX_INVALID_USER_ID = 0;
	
	/*
	 * Total Price Should be have more then Zero.
	 */
	public static final int INVALID_TOTAL_PRICE = 0;
	
	/*
	 * Ordered Product Quantity Should be have more then Zero.
	 */
	public static final int INVALID_PRODUCT_QUENTITY = 0;
	
	/*
	 * Order Id Must Have More then Zero. 
	 * (it will get automatically through the DB.
	 * In case any problem for ordered product validator 
	 * It will  stop the next step) .
	 */
	public static final int INVALID_ORDER_ID = 0;	
	
	

}
