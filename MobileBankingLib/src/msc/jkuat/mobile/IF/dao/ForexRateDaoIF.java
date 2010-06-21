/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package msc.jkuat.mobile.IF.dao;

import java.util.List;
import msc.jkuat.mobile.IF.ForexRateIF;

/**
 *
 * @author enjogu
 */
public interface ForexRateDaoIF {
    /**get the current list of forex rates*/
    public List<ForexRateIF> getForexRates();
}
