/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

/**
 *abstracts the process of getting locale specific strings
 * @author enjogu
 */
public interface Locale {
    /**
     * @param constant - the key that acts as an index to the info
     * @return the locale specific string
     */
    public String getString(String constant);
    /**
     * 
     * @param constant - the key
     * @param params - the parameters to be substituted into the return string
     * @return
     */
    public String getString(String constant, Object[] params);
}
