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

import msc.jkuat.mobile.IF.TransactionIF;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author enjogu
 */
public class Transaction implements TransactionIF {
	/**the transaction date*/
    private Date date;
    /**The transaction description*/
    private String description;
    /**the amount in question*/
    private BigDecimal amount;
    /**e.g. DR or CR*/
    private String drCrCode = null;
    /**the format used to for dates - should be set via spring configuration. default dd-MMM-yy*/
    private String dateFormat = "dd-MMM-yy";//default
    /**format the date for the UI*/
	private SimpleDateFormat sdf = null;

	
	
	public Transaction() {
		sdf = new SimpleDateFormat();
		sdf.applyPattern(this.dateFormat);//apply default
	}

	public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    @Override
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

	@Override
	public String getDrCrCode() {
		return drCrCode;
	}

	@Override
	public void setDrCrCode(String drCrCode) {
		this.drCrCode = drCrCode;
	}

	@Override
	public String getFormattedDate() {
		return sdf.format(this.date);
	}

	/**
	 * @param dateFormat the dateFormat to set
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
		sdf.applyPattern(this.dateFormat);//apply provided (replace default)
	}

	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}
}
