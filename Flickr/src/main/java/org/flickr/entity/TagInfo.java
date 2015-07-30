package org.flickr.entity;

/** 
 * Defines a Tag object associated with a photoInfo object
 * @author Rupak Chakraborty
 *
 */

public class TagInfo {
	
	private String Id;
	private String author;
	private String authorName;
	private String rawContent;
	private String content;
	private String machineTag; 
	
	/** 
	 * public constructor to initialize the object with default values 
	 */ 
	
	public TagInfo() { 
		
		this.Id = "";
		this.author = "";
		this.authorName = "";
		this.rawContent = "";
		this.content = "";
		this.machineTag = "";
	} 
	
	/** 
	 * 
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
	 * @return the authorName
	 */ 
	
	public String getAuthorName() {
		return authorName;
	} 
	
	/** 
	 * 
	 * @param authorName the authorName to set
	 */ 
	
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	} 
	
	/** 
	 * 
	 * @return the rawContent
	 */ 
	
	public String getRawContent() {
		return rawContent;
	} 
	
	/** 
	 * 
	 * @param rawContent the rawContent to set
	 */ 
	
	public void setRawContent(String rawContent) {
		this.rawContent = rawContent;
	} 
	
	/** 
	 * 
	 * @return the content
	 */ 
	
	public String getContent() {
		return content;
	} 
	
	/** 
	 * 
	 * @param content the content to set
	 */ 
	
	public void setContent(String content) {
		this.content = content;
	} 
	
	/** 
	 * 
	 * @return the machineTag
	 */ 
	
	public String getMachineTag() {
		return machineTag;
	}
	/**
	 * @param machineTag the machineTag to set
	 */
	public void setMachineTag(String machineTag) {
		this.machineTag = machineTag;
	}
	
}
