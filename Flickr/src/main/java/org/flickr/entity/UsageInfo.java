package org.flickr.entity;

/** 
 * 
 * @author Rupak Chakraborty
 *
 */

public class UsageInfo {
	
	private Long canshare;
	private Long candownload;
	private Long canblog;
	private Long canprint;
	
	/** 
	 * public constructor to initialize the UsageInfo with default values
	 */
	
	public UsageInfo() { 
		
		canshare = 0L;
		candownload = 0L;
		canblog = 0L;
		canprint = 0L;
	}

	/**
	 * @return the canshare
	 */
	
	public Long getCanshare() {
		return canshare;
	}

	/**
	 * @param canshare the canshare to set
	 */
	public void setCanshare(Long canshare) {
		this.canshare = canshare;
	}

	/**
	 * @return the candownload
	 */
	public Long getCandownload() {
		return candownload;
	}

	/**
	 * @param candownload the candownload to set
	 */
	public void setCandownload(Long candownload) {
		this.candownload = candownload;
	}

	/**
	 * @return the canblog
	 */
	public Long getCanblog() {
		return canblog;
	}

	/**
	 * @param canblog the canblog to set
	 */
	public void setCanblog(Long canblog) {
		this.canblog = canblog;
	}

	/**
	 * @return the canprint
	 */
	public Long getCanprint() {
		return canprint;
	}

	/**
	 * @param canprint the canprint to set
	 */
	public void setCanprint(Long canprint) {
		this.canprint = canprint;
	}
}
