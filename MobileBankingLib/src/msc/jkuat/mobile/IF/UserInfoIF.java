/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

/**
 *This file specifies the information that we will keep about the user
 * @author admin
 */
public interface UserInfoIF {
    /**get the user specified PIN*/
    public String getPIN();
    /**set the PIN to a user specified value
     *@param pin - the value to set
     */
    public void setPIN(String pin);
    /**
     * change PIN
     * @param newPIN - the new PIN
     */
    public void changePIN(String newPIN);
    /**e.g. Eric*/
    public String getFirstName();
    /**e.g. Njogu*/
    public String getLastName();
    /**e.g. Mr.*/
    public String getTitle();
}
