package org.flickr.entity;

/** 
 * Defines a visibility info object of the 
 * @author Rupak Chakraborty
 *
 */ 

public class VisibilityInfo {
	
	private Long ispublic;
	private Long isfriend;
	private Long isfamily;
	
	public VisibilityInfo() { 
		
		ispublic = 0L;
		isfriend = 0L;
		isfamily = 0L;
	}

	/**
	 * @return the ispublic
	 */
	public Long getIspublic() {
		return ispublic;
	}

	/**
	 * @param ispublic the ispublic to set
	 */
	public void setIspublic(Long ispublic) {
		this.ispublic = ispublic;
	}

	/**
	 * @return the isfriend
	 */
	public Long getIsfriend() {
		return isfriend;
	}

	/**
	 * @param isfriend the isfriend to set
	 */
	public void setIsfriend(Long isfriend) {
		this.isfriend = isfriend;
	}

	/**
	 * @return the isfamily
	 */
	public Long getIsfamily() {
		return isfamily;
	}

	/**
	 * @param isfamily the isfamily to set
	 */
	public void setIsfamily(Long isfamily) {
		this.isfamily = isfamily;
	}
}
