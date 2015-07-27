package org.flickr.entity;

/**
 * @author Rupak Chakraborty
 *
 */

public class FindPlaces {

	private String placeId;
	private String woeName;
	private String woeId;
	private String content;
	private double latitude;
	private double longitude;
	private String placeUrl;
	private String timezone;
	private String placeType;
	private Long placeTypeId;

	public FindPlaces() { 

	}

	/**
	 * @return the placeId
	 */
	public String getPlaceId() {
		return placeId;
	}

	/**
	 * @param placeId the placeId to set
	 */
	public void setPlaceId(String placeId) {
		this.placeId = placeId;
	}

	/**
	 * @return the woeName
	 */
	public String getWoeName() {
		return woeName;
	}

	/**
	 * @param woeName the woeName to set
	 */
	public void setWoeName(String woeName) {
		this.woeName = woeName;
	}

	/**
	 * @return the woeId
	 */
	public String getWoeId() {
		return woeId;
	}

	/**
	 * @param woeId the woeId to set
	 */
	public void setWoeId(String woeId) {
		this.woeId = woeId;
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
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the placeUrl
	 */
	public String getPlaceUrl() {
		return placeUrl;
	}

	/**
	 * @param placeUrl the placeUrl to set
	 */
	public void setPlaceUrl(String placeUrl) {
		this.placeUrl = placeUrl;
	}

	/**
	 * @return the timezone
	 */
	public String getTimezone() {
		return timezone;
	}

	/**
	 * @param timezone the timezone to set
	 */
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}

	/**
	 * @return the placeType
	 */
	public String getPlaceType() {
		return placeType;
	}

	/**
	 * @param placeType the placeType to set
	 */
	public void setPlaceType(String placeType) {
		this.placeType = placeType;
	}

	/**
	 * @return the placeTypeId
	 */
	public Long getPlaceTypeId() {
		return placeTypeId;
	}

	/**
	 * @param placeTypeId the placeTypeId to set
	 */
	public void setPlaceTypeId(Long placeTypeId) {
		this.placeTypeId = placeTypeId;
	}
}
