/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

import java.math.BigDecimal;

/**
 *represents a forex rate for a foreign currency
 *against the local currency
 * @author enjogu
 */
public interface ForexRateIF {
	/**get the rate*/
    public BigDecimal getRate();

    /**set the forex rate*/
    public void setRate(BigDecimal amount);

	public String getSymbol();

	public void setSymbol(String symbol);

	public String getCurrencyName();

	public void setCurrencyName(String currencyName);

}
