/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.impl;

import msc.jkuat.mobile.IF.ForexRateIF;

import java.math.BigDecimal;

/**
 *represents the forex rate of a given currency.
 * @author enjogu
 */
public class ForexRate implements ForexRateIF {
    /** the rate*/
    private BigDecimal rate = null;
    /**e.g USD*/
    private String symbol = null;
    /**the name of the currency*/
    private String currencyName = null;

	@Override
	public BigDecimal getRate() {
		return rate;
	}

	@Override
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

}
