package org.flickr.entity;

/**
 * @author Rupak Chakraborty
 *
 */

public class TagPlaces extends FindPlaces {
	
	private Long photoCount;
	
	public TagPlaces() { 
		
	} 
	
	/**
	 * Returns the total number of photos in a given place
	 * @return Long containing the photoCount
	 */ 
	
	public Long getPhotoCount() { 
		
		return photoCount;
	}

	/** 
	 * Sets the photo count for a given place tag
	 * @param Long containing the photoCount to set
	 */ 
	
	public void setPhotoCount(Long photoCount) { 
		
		this.photoCount = photoCount;
	} 
}
