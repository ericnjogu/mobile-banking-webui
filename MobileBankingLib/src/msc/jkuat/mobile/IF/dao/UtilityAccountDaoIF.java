/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF.dao;

import java.util.List;

import msc.jkuat.mobile.IF.AccountIF;

/**
 *there will be two implementing classes, one for the utility acs and another for the customer accounts
 * @author enjogu
 */
public interface UtilityAccountDaoIF {
    /**obtain a list of all accounts*/
    public List<AccountIF> getAllAccounts();
}
