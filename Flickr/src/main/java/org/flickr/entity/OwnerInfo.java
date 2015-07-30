package org.flickr.entity;

/** 
 * Defines the object associated with the owner of a given PhotoInfo object
 * @author Rupak Chakraborty
 *
 */ 

public class OwnerInfo {
	
	private String userName;
	private String realName;
	private String nsId;
	private String location;
	private String pathAlias;
	private Long iconserver;
	private Long iconfarm; 
	
	/** 
	 * public constructor to initialize the ownerInfo object with default values
	 */ 
	
	public OwnerInfo() { 
		
		userName = "";
		realName = "";
		nsId = "";
		location = "";
		pathAlias = "";
		iconserver = 0L;
		iconfarm = 0L;
	} 
	
	/**
	 * @return the userName
	 */ 
	
	public String getUserName() {
		return userName;
	} 
	
	/**
	 * @param userName the userName to set
	 */ 
	
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the nsId
	 */ 
	
	public String getNsId() {
		return nsId;
	} 
	
	/**
	 * @param nsId the nsId to set
	 */ 
	
	public void setNsId(String nsId) {
		this.nsId = nsId;
	} 
	
	/**
	 * @return the location
	 */ 
	
	public String getLocation() {
		return location;
	} 
	
	/**
	 * @param location the location to set
	 */ 
	
	public void setLocation(String location) {
		this.location = location;
	} 
	
	/**
	 * @return the pathAlias
	 */ 
	
	public String getPathAlias() {
		return pathAlias;
	} 
	
	/**
	 * @param pathAlias the pathAlias to set
	 */ 
	
	public void setPathAlias(String pathAlias) {
		this.pathAlias = pathAlias;
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
}
