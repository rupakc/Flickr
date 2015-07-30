package org.flickr.entity;

import java.util.Set;

/** 
 * Defines a PhotoInfo object to be used to store the response of PhotoInfo
 * @author Rupak Chakraborty
 *
 */

public class PhotoInfo {
	
	private String Id;
	private String secret;
	private Long server;
	private Long farm;
	private Long rotation;
	private double dateupload;
	private Long safetylevel;
	private Long isfavorite;
	private Long license;
	private Long views;
	private String titleContent;
	private String descriptionContent;
	private Long commentsContent;
	private String media;
	private Long haspeople;
	private String urlType;
	private String urlContent;
	private Set<String> notes;
	private TagInfo tagInfo;
	private OwnerInfo ownerInfo;
	private DateInfo dateInfo;
	private VisibilityInfo visibilityInfo;
	private UsageInfo usageInfo;
	private PublicEditInfo publicInfo; 
	
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
	 * @return the rotation
	 */
	public Long getRotation() {
		return rotation;
	}
	/**
	 * @param rotation the rotation to set
	 */
	public void setRotation(Long rotation) {
		this.rotation = rotation;
	}
	/**
	 * @return the dateupload
	 */
	public double getDateupload() {
		return dateupload;
	}
	/**
	 * @param dateupload the dateupload to set
	 */
	public void setDateupload(double dateupload) {
		this.dateupload = dateupload;
	}
	/**
	 * @return the safetylevel
	 */
	public Long getSafetylevel() {
		return safetylevel;
	}
	/**
	 * @param safetylevel the safetylevel to set
	 */
	public void setSafetylevel(Long safetylevel) {
		this.safetylevel = safetylevel;
	}
	/**
	 * @return the isfavorite
	 */
	public Long getIsfavorite() {
		return isfavorite;
	}
	/**
	 * @param isfavorite the isfavorite to set
	 */
	public void setIsfavorite(Long isfavorite) {
		this.isfavorite = isfavorite;
	}
	/**
	 * @return the license
	 */
	public Long getLicense() {
		return license;
	}
	/**
	 * @param license the license to set
	 */
	public void setLicense(Long license) {
		this.license = license;
	}
	/**
	 * @return the views
	 */
	public Long getViews() {
		return views;
	}
	/**
	 * @param views the views to set
	 */
	public void setViews(Long views) {
		this.views = views;
	}
	/**
	 * @return the titleContent
	 */
	public String getTitleContent() {
		return titleContent;
	}
	/**
	 * @param titleContent the titleContent to set
	 */
	public void setTitleContent(String titleContent) {
		this.titleContent = titleContent;
	}
	/**
	 * @return the descriptionContent
	 */
	public String getDescriptionContent() {
		return descriptionContent;
	}
	/**
	 * @param descriptionContent the descriptionContent to set
	 */
	public void setDescriptionContent(String descriptionContent) {
		this.descriptionContent = descriptionContent;
	}
	/**
	 * @return the commentsContent
	 */
	public Long getCommentsContent() {
		return commentsContent;
	}
	/**
	 * @param commentsContent the commentsContent to set
	 */
	public void setCommentsContent(Long commentsContent) {
		this.commentsContent = commentsContent;
	}
	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}
	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}
	/**
	 * @return the haspeople
	 */
	public Long getHaspeople() {
		return haspeople;
	}
	/**
	 * @param haspeople the haspeople to set
	 */
	public void setHaspeople(Long haspeople) {
		this.haspeople = haspeople;
	}
	/**
	 * @return the urlType
	 */
	public String getUrlType() {
		return urlType;
	}
	/**
	 * @param urlType the urlType to set
	 */
	public void setUrlType(String urlType) {
		this.urlType = urlType;
	}
	/**
	 * @return the urlContent
	 */
	public String getUrlContent() {
		return urlContent;
	}
	/**
	 * @param urlContent the urlContent to set
	 */
	public void setUrlContent(String urlContent) {
		this.urlContent = urlContent;
	}
	/**
	 * @return the notes
	 */
	public Set<String> getNotes() {
		return notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(Set<String> notes) {
		this.notes = notes;
	}
	/**
	 * @return the tagInfo
	 */
	public TagInfo getTagInfo() {
		return tagInfo;
	}
	/**
	 * @param tagInfo the tagInfo to set
	 */
	public void setTagInfo(TagInfo tagInfo) {
		this.tagInfo = tagInfo;
	}
	/**
	 * @return the ownerInfo
	 */
	public OwnerInfo getOwnerInfo() {
		return ownerInfo;
	}
	/**
	 * @param ownerInfo the ownerInfo to set
	 */
	public void setOwnerInfo(OwnerInfo ownerInfo) {
		this.ownerInfo = ownerInfo;
	}
	/**
	 * @return the dateInfo
	 */
	public DateInfo getDateInfo() {
		return dateInfo;
	}
	/**
	 * @param dateInfo the dateInfo to set
	 */
	public void setDateInfo(DateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}
	/**
	 * @return the visibilityInfo
	 */
	public VisibilityInfo getVisibilityInfo() {
		return visibilityInfo;
	}
	/**
	 * @param visibilityInfo the visibilityInfo to set
	 */
	public void setVisibilityInfo(VisibilityInfo visibilityInfo) {
		this.visibilityInfo = visibilityInfo;
	}
	/**
	 * @return the usageInfo
	 */
	public UsageInfo getUsageInfo() {
		return usageInfo;
	}
	/**
	 * @param usageInfo the usageInfo to set
	 */
	public void setUsageInfo(UsageInfo usageInfo) {
		this.usageInfo = usageInfo;
	}
	/**
	 * @return the publicInfo
	 */
	public PublicEditInfo getPublicInfo() {
		return publicInfo;
	}
	/**
	 * @param publicInfo the publicInfo to set
	 */
	public void setPublicInfo(PublicEditInfo publicInfo) {
		this.publicInfo = publicInfo;
	}
}
