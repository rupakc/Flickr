package org.flickr.entity;

/** 
 * Defines a camera model object for storing information relating to Camera brands 
 * 
 * @author Rupak Chakraborty
 *
 */

public class CameraModel {
	
	private String brand;
	private String name;
	private double megapixels;
	private double lcdscreensize;
	private String memorytype;
	private String Id;
	private String smallurl;
	private String largeurl; 
	
	
	/**
	 * @return the brand
	 */ 
	
	public String getBrand() {
		return brand;
	} 
	
	/**
	 * @param brand the brand to set
	 */ 
	
	public void setBrand(String brand) {
		this.brand = brand;
	} 
	
	/**
	 * @return the name
	 */ 
	
	public String getName() {
		return name;
	} 
	
	/**
	 * @param name the name to set
	 */ 
	
	public void setName(String name) {
		this.name = name;
	} 
	
	/**
	 * @return the megapixels
	 */ 
	
	public double getMegapixels() {
		return megapixels;
	} 
	
	/**
	 * @param megapixels the megapixels to set
	 */ 
	
	public void setMegapixels(double megapixels) {
		this.megapixels = megapixels;
	} 
	
	/**
	 * @return the lcdscreensize
	 */ 
	
	public double getLcdscreensize() {
		return lcdscreensize;
	} 
	
	/**
	 * @param lcdscreensize the lcdscreensize to set
	 */ 
	
	public void setLcdscreensize(double lcdscreensize) {
		this.lcdscreensize = lcdscreensize;
	} 
	
	/**
	 * @return the memorytype
	 */ 
	
	public String getMemorytype() {
		return memorytype;
	} 
	
	/**
	 * @param memorytype the memorytype to set
	 */ 
	
	public void setMemorytype(String memorytype) {
		this.memorytype = memorytype;
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
	 * @return the smallurl
	 */ 
	
	public String getSmallurl() {
		return smallurl;
	} 
	
	/**
	 * @param smallurl the smallurl to set
	 */ 
	
	public void setSmallurl(String smallurl) {
		this.smallurl = smallurl;
	} 
	
	/**
	 * @return the largeurl
	 */ 
	
	public String getLargeurl() {
		return largeurl;
	} 
	
	/**
	 * @param largeurl the largeurl to set
	 */ 
	
	public void setLargeurl(String largeurl) {
		this.largeurl = largeurl;
	}
}
