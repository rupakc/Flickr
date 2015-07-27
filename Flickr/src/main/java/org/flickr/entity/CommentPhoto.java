package org.flickr.entity;

/**
 * @author Rupak Chakraborty
 *
 */

public class CommentPhoto {
	
	private String Id;
	private String author;
	private String pathalias;
	private String authorName;
	private String content;
	private String permalink;
	private Long iconserver;
	private Long iconfarm;
	private String realName;
	private double timestamp; 
	
	/**
	 * @return the id
	 */ 
	
	public String getId() {
		return Id;
	} 
	
	/** 
	 * 
	 * @param id the id to set
	 */ 
	
	public void setId(String id) {
		Id = id;
	} 
	
	/** 
	 * 
	 * @return the author
	 */ 
	
	public String getAuthor() {
		return author;
	} 
	
	/** 
	 * 
	 * @param author the author to set
	 */ 
	
	public void setAuthor(String author) {
		this.author = author;
	} 
	
	/** 
	 * 
	 * @return the pathalias
	 */ 
	
	public String getPathalias() {
		return pathalias;
	} 
	
	/**
	 * @param pathalias the pathalias to set
	 */ 
	
	public void setPathalias(String pathalias) {
		this.pathalias = pathalias;
	} 
	
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	} 
	
	/**
	 * @param authorName the authorName to set
	 */ 
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	} 
	
	/**
	 * @return the content
	 */ 
	
	public String getContent() {
		return content;
	} 
	
	/**
	 * @param content the content to set
	 */ 
	
	public void setContent(String content) {
		this.content = content;
	} 
	
	/**
	 * @return the permalink
	 */ 
	
	public String getPermalink() {
		return permalink;
	}
	/**
	 * @param permalink the permalink to set
	 */
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	} 
	
	/**
	 * @return the iconserver
	 */ 
	
	public Long getIconserver() {
		return iconserver;
	} 
	
	/**
	 * @param iconserver the iconserver to set
	 */ 
	
	public void setIconserver(Long iconserver) {
		this.iconserver = iconserver;
	} 
	
	/**
	 * @return the iconfarm
	 */ 
	
	public Long getIconfarm() {
		return iconfarm;
	}
	/**
	 * @param iconfarm the iconfarm to set
	 */
	public void setIconfarm(Long iconfarm) {
		this.iconfarm = iconfarm;
	}
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	} 
	
	/** 
	 * 
	 * @return the timestamp
	 */ 
	
	public double getTimestamp() {
		return timestamp;
	} 
	
	/** 
	 * 
	 * @param timestamp the timestamp to set
	 */ 
	
	public void setTimestamp(double timestamp) {
		this.timestamp = timestamp;
	} 		
}
