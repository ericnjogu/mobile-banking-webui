/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.impl;

import msc.jkuat.mobile.IF.AccountIF;

/**
 *
 * @author enjogu
 */
public class Account implements AccountIF{
	/** e.g. A.N. Other - (personal), KPLC - (utility)*/
    private String name;
    /**e.g. 012456766300*/
    private String number;
    
    
    public String getName() {
        return this.name;
    }

    public String getNumber() {
        return this.number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
