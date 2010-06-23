/*
   Copyright [2010] [Eric Njogu]

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
*/

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
