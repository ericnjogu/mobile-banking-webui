/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

import java.math.BigDecimal;
import java.util.Date;

/**
 *interface for a transaction. javadoc for the fields accessed through the
 *getters and setters here is in the implementing class
 * @author enjogu
 */
public interface TransactionIF {

	public BigDecimal getAmount();

	public Date getDate();
	
	public String getFormattedDate();

	public String getDescription();

	public void setAmount(BigDecimal amount);

	public void setDate(Date date);

	public void setDescription(String description);
	
	public String getDrCrCode();
	
	public void setDrCrCode(String drCrCode);
}
