/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.impl;

import java.math.BigDecimal;

/**
 *constants that will be used to get localized labels and specify operations
 * @author enjogu
 */
public class AppConstants {
    /**various constants*//*
    public static String OPERATION_BUY_AIRTIME = "buy-airtime";
    public static String OPERATION_TRANSFER_FUNDS = "funds-transfer";
    public static String OPERATION_GET_FOREX = "get_forex";
    //currency symbols
    public static String CURRENCY_USD = "USD";
    public static String CURRENCY_GB = "STP";
    public static String CURRENCY_JP = "YEN";
    public static String CURRENCY_DW = "DM";
    public static String CURRENCY_UG = "UG";
    public static String CURRENCY_TZ = "TZ";*/
	
    //commissions - can be derived from a CommissionService later
    /**commission for airtime purchase*/
    public static BigDecimal AIRTIME_COMM = new BigDecimal(10);
    /**commission for amount transferred btn accounts*/
    public static BigDecimal TRANSFER_COMM = new BigDecimal(50);
    /**commission for utility bill payments*/
    public static BigDecimal UTILITY_COMM = new BigDecimal(10);
    /**debit*/
    public static String DEBIT = "DR";
    /**credit*/
    public static String CREDIT = "CR";
}
