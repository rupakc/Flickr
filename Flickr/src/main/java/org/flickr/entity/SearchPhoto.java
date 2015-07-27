package org.flickr.entity;

/** 
 * 
 * @author rupachak
 *
 */ 

public class SearchPhoto {
	
	private String Id;
	private String owner;
	private String secret;
	private Long server;
	private Long farm;
	private String title;
	private String isPublic;
	private String isFamily;
	private String isFriend; 
	
	/** 
	 * 
	 */ 
	
	public SearchPhoto() { 
		
	}
	
	/**
	 * @return the id
	 */
	public String getId() {
		return Id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		Id = id;
	}
	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * @param owner the owner to set
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * @return the secret
	 */
	public String getSecret() {
		return secret;
	}
	/**
	 * @param secret the secret to set
	 */
	public void setSecret(String secret) {
		this.secret = secret;
	}
	/**
	 * @return the server
	 */
	public Long getServer() {
		return server;
	}
	/**
	 * @param server the server to set
	 */
	public void setServer(Long server) {
		this.server = server;
	}
	/**
	 * @return the farm
	 */
	public Long getFarm() {
		return farm;
	}
	/**
	 * @param farm the farm to set
	 */
	public void setFarm(Long farm) {
		this.farm = farm;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the isPublic
	 */
	public String getIsPublic() {
		return isPublic;
	}
	/**
	 * @param isPublic the isPublic to set
	 */
	public void setIsPublic(String isPublic) {
		this.isPublic = isPublic;
	}
	/**
	 * @return the isFamily
	 */
	public String getIsFamily() {
		return isFamily;
	}
	/**
	 * @param isFamily the isFamily to set
	 */
	public void setIsFamily(String isFamily) {
		this.isFamily = isFamily;
	}
	/**
	 * @return the isFriend
	 */
	public String getIsFriend() {
		return isFriend;
	}
	/**
	 * @param isFriend the isFriend to set
	 */
	public void setIsFriend(String isFriend) {
		this.isFriend = isFriend;
	} 
}
