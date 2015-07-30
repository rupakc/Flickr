package org.flickr.entity;

import java.util.Date;

/** 
 * Defines the Date object associated with PhotoInfo response object
 * @author Rupak Chakraborty
 *
 */ 

public class DateInfo {
	
	private Date posted;
	private double taken;
	private Long takengranularity;
	private Long takenunknown;
	private double lastupdated;
	
	/** 
	 * public constructor to initialize the DateInfo object of the PhotoInfo response object
	 */ 
	
	public DateInfo() { 
		
		posted = new Date();
		taken = 0.0;
		takengranularity = 0L;
		takenunknown = 0L;
		lastupdated = 0.0;
	}

	/** 
	 * 
	 * @return the posted
	 */ 
	
	public Date getPosted() {
		return posted;
	}

	/** 
	 * 
	 * @param posted the posted to set
	 */ 
	
	public void setPosted(Date posted) {
		this.posted = posted;
	}

	/** 
	 * 
	 * @return the taken
	 */
	public double getTaken() {
		return taken;
	}

	/** 
	 * 
	 * @param taken the taken to set
	 */ 
	
	public void setTaken(double taken) {
		this.taken = taken;
	}

	/** 
	 * 
	 * @return the takengranularity
	 */ 
	
	public Long getTakengranularity() {
		return takengranularity;
	}

	/** 
	 * 
	 * @param takengranularity the takengranularity to set
	 */ 
	
	public void setTakengranularity(Long takengranularity) {
		this.takengranularity = takengranularity;
	}

	/** 
	 * 
	 * @return the takenunknown
	 */ 
	
	public Long getTakenunknown() {
		return takenunknown;
	}

	/** 
	 * 
	 * @param takenunknown the takenunknown to set
	 */ 
	
	public void setTakenunknown(Long takenunknown) {
		this.takenunknown = takenunknown;
	}

	/** 
	 * 
	 * @return the lastupdated
	 */ 
	
	public double getLastupdated() {
		return lastupdated;
	}

	/** 
	 * 
	 * @param lastupdated the lastupdated to set
	 */ 
	
	public void setLastupdated(double lastupdated) {
		this.lastupdated = lastupdated;
	}
}
