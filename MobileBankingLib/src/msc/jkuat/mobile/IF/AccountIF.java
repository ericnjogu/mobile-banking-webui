/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

/**
 *used as a base class for customer accounts
 *used directly by utility accounts
 * @author enjogu
 */
public interface AccountIF {

    public String getName();

    public String getNumber();

    public void setName(String name);

    public void setNumber(String number);
   
}
