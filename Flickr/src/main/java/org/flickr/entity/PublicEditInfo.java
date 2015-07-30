package org.flickr.entity;

/** 
 * Defines the public editability object associated with a PhotoInfo response object 
 * @author Rupak Chakraborty
 *
 */

public class PublicEditInfo {
	
	private Long usercancomment;
	private Long usercanaddmeta;
	private Long publiccancomment;
	private Long publiccanaddmeta;
	
	public PublicEditInfo() { 
		
	}
	
	/**
	 * @return the usercancomment
	 */
	public Long getUsercancomment() {
		return usercancomment;
	}
	/**
	 * @param usercancomment the usercancomment to set
	 */
	public void setUsercancomment(Long usercancomment) {
		this.usercancomment = usercancomment;
	}
	/**
	 * @return the usercanaddmeta
	 */
	public Long getUsercanaddmeta() {
		return usercanaddmeta;
	}
	/**
	 * @param usercanaddmeta the usercanaddmeta to set
	 */
	public void setUsercanaddmeta(Long usercanaddmeta) {
		this.usercanaddmeta = usercanaddmeta;
	}
	/**
	 * @return the publiccancomment
	 */
	public Long getPubliccancomment() {
		return publiccancomment;
	}
	/**
	 * @param publiccancomment the publiccancomment to set
	 */
	public void setPubliccancomment(Long publiccancomment) {
		this.publiccancomment = publiccancomment;
	}
	/**
	 * @return the publiccanaddmeta
	 */
	public Long getPubliccanaddmeta() {
		return publiccanaddmeta;
	}
	/**
	 * @param publiccanaddmeta the publiccanaddmeta to set
	 */
	public void setPubliccanaddmeta(Long publiccanaddmeta) {
		this.publiccanaddmeta = publiccanaddmeta;
	}
}
