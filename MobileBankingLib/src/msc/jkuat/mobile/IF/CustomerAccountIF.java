/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF;

import java.math.BigDecimal;
import java.util.List;

/**
 *represents a customer account
 *see implementing class for javadoc on fields whose getters and setters
 *appear here
 * @author enjogu
 */
public interface CustomerAccountIF extends AccountIF{
    public BigDecimal getBalance();
    public void setBalance(BigDecimal balance);
    public void setInterestRate(BigDecimal rate);
    public BigDecimal getInterestRate();
    public BigDecimal getMinimumBalance();
    public void setMinimumBalance(BigDecimal minBal);
    /**
     * get a mini-statement
     * @return a list of transactions
     */
    public List<TransactionIF> getMiniStatement();
    /**
     * transfer money
     * @param customerAccountTo - the  account number to transfer to
     * @param amount - the amount to transfer
     */
    public void transferFundsTo(CustomerAccountIF customerAccountTo, 
    		BigDecimal amount) throws Exception;
    /**
     * buy airtime
     * @param phoneNumber - the phone to top up
     * @param amount - the amount to transfer
     */
    public void buyAirtime(String phoneNumber, BigDecimal amount) throws Exception;
    /**
     * pay utility bill
     * @param customerAccountNumberFrom - the account to debit
     * @param amount - the amount to pay
     * @param ref -e.g. the bill number or person to pay or specific cause/detail
     */
    public void payUtilityBill(AccountIF utilityAccount, 
    		BigDecimal amount, String ref) throws Exception;
    /*TODO pull up the following two into AccountIF so that 
     * utility account also has debit and credit. In that case
     * the implementation will be moved into Account
     */
    /**credit account*/
    public void credit(BigDecimal amount, String description);
    /**debit account*/
    public void debit(BigDecimal amount, String description);
}
