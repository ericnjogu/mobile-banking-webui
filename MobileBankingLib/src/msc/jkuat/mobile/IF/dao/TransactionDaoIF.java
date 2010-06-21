/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF.dao;

import java.util.List;
import msc.jkuat.mobile.IF.TransactionIF;

/**
 *
 * @author enjogu
 */
public interface TransactionDaoIF {
    /**add transaction
     * @param accountNumber - the account number
     * @param t  - the transaction to add
     * */
    public void addTransaction(TransactionIF t, String accountNumber);
    /**get all available transactions for this account
     * @param accountNumber TODO*/
    public List<TransactionIF> getTransactions(String accountNumber);
}
