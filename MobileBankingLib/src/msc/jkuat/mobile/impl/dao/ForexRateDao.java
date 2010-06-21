package msc.jkuat.mobile.impl.dao;

import java.util.List;

import msc.jkuat.mobile.IF.ForexRateIF;
import msc.jkuat.mobile.IF.dao.ForexRateDaoIF;

public class ForexRateDao implements ForexRateDaoIF {
	/**a list of forex rates. to be injected via spring*/
	private List<ForexRateIF> forexStore = null;
	@Override
	public List<ForexRateIF> getForexRates() {
		return forexStore;
	}
	/**
	 * @param forexStore the forexStore to set
	 */
	public void setForexStore(List<ForexRateIF> forexList) {
		if (forexList == null) {
			throw new IllegalArgumentException("forexList should not be null");
		}
		this.forexStore = forexList;
	}
	/**
	 * @return the forexStore
	 */
	public List<ForexRateIF> getForexStore() {
		return forexStore;
	}
}
