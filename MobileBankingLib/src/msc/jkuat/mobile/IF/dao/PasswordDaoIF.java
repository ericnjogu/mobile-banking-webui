/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF.dao;

/**
 *represents password storage
 * @author enjogu
 */
public interface PasswordDaoIF {
    /**store the password to persistent storage*/
    public void save(String secret);
    /**retrieve the password*/
    public String retrieve();
    /**find the password status*/
    public boolean isEnabled();
    /**set the password status*/
    public void setEnabled(boolean state);
}
