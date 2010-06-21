package msc.jkuat.mobile.IF.dao;

import java.util.List;

import msc.jkuat.mobile.IF.CustomerAccountIF;
import msc.jkuat.mobile.IF.UserInfoIF;

public interface CustomerAccountDaoIF {
	/**obtain a list of all accounts*/
    public List<CustomerAccountIF> getAllAccounts(UserInfoIF userInfo);
}
