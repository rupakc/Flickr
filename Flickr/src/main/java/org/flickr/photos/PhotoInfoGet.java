package org.flickr.photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * 
 * @author Rupak Chakraborty
 *
 */ 

public class PhotoInfoGet {

	String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.getInfo&api_key=";
	String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	String PHOTO_ID_TAG = "&photo_id=";
	String PHOTO_ID = "19592127128";
	String SUFFIX_URL = "&format=json&nojsoncallback=1";

	/**  
	 * Constructs a full url from the given constituent parts 
	 * @return String containing the complete url (API endpoint)
	 */

	public String getFullLink() { 

		String url = this.BASE_URL + this.API_KEY + this.PHOTO_ID_TAG + this.PHOTO_ID + this.SUFFIX_URL;

		return url;
	}

	/** 
	 * Given a link to the API endpoint returns the JSON response
	 * @param link String containing the link of the endpoint
	 * @return String containing the response
	 * @throws IOException
	 */ 

	public String getJSONResponse(String link)throws IOException { 

		URL url = new URL(link);
		String temp = "";
		String response = "";
		BufferedReader br;

		br = new BufferedReader(new InputStreamReader(url.openStream()));

		while((temp = br.readLine()) != null) { 

			response = response + temp;
		}

		return response;
	}

	/**
	 * Parses a string containing the String JSON response and returns a JSONObject 
	 * @param response String containing the json object
	 * @return JSONObject containing the JSON response
	 * @throws ParseException
	 */ 

	public JSONObject getParsedJSON(String response) throws ParseException { 

		JSONParser parser;
		JSONObject json;

		parser = new JSONParser();
		json = (JSONObject) parser.parse(response);

		return json;
	}

	/** 
	 * Returns a JSONArray in a given JSON object given the field name
	 * @param response JSONObject containing the response 
	 * @param field_name String containing the field corresponding to the JSONArray
	 * @return JSONArray associated with the given field name
	 */ 

	public JSONArray getJSONArray(JSONObject response,String field_name) { 

		JSONArray jsonArray; 
		jsonArray = (JSONArray) response.get(field_name);

		return jsonArray;
	} 

	/** 
	 * Checks the status of the JSONObject returned
	 * @param response_object JSONObject whose status is to be checked
	 * @return true if the status is correct false otherwise
	 */ 

	public boolean checkStatus(JSONObject response_object) { 

		boolean status = false;
		String stat = (String) response_object.get("stat");

		if (stat.equalsIgnoreCase("OK")) { 

			status = true;
		}

		return status;
	}
	
	/** 
	 * Defines the pipeline for fetching information relating to a particular photo
	 * @param photo_id String containing the photo_id whose information is to be fetched
	 * @throws IOException
	 * @throws ParseException
	 */ 
	
	public void photoInfoPipeline(String photo_id) throws IOException, ParseException { 

		this.PHOTO_ID = photo_id;
		String link = getFullLink();
		String response = getJSONResponse(link);
		JSONObject parsed_object = getParsedJSON(response);
		System.out.println(parsed_object);
		printPhotoInfo((JSONObject)parsed_object.get("photo"));
	}
	
	/** 
	 * Prints a given JSON photoInfo object to the console
	 * @param photo JSONObject containing the photo to print
	 */ 
	
	public void printPhotoInfo(JSONObject photo) {
		
		System.out.println("---------------------------------------------\n");
		System.out.println("Id : " + photo.get("id"));
		System.out.println("Secret : " + photo.get("secret"));
		System.out.println("Server : " + photo.get("server"));
		System.out.println("Farm : " + photo.get("farm"));
		System.out.println("Rotation : " + photo.get("rotation"));
		System.out.println("Date Uploaded : " + photo.get("dateuploaded"));
		System.out.println("Safety Level : " + photo.get("safety_level"));
		System.out.println("Title : " + photo.get("title"));
		System.out.println("Description : " + photo.get("description"));
		System.out.println("Is favorite : " + photo.get("isfavorite"));
		System.out.println("License : " + photo.get("license"));
		System.out.println("Views : " + photo.get("Views"));
		System.out.println("Owner : " + photo.get("owner"));
		System.out.println("Dates : " + photo.get("dates"));
		System.out.println("Visibility : " + photo.get("visibility"));
		System.out.println("Usage : " + photo.get("usage"));
		System.out.println("------------------------------------------------\n");
	}
	
	/** 
	 * Main function to test the functionality of the class
	 * @param args
	 */ 
	
	public static void main(String args[]) { 

		PhotoInfoGet infoget = new PhotoInfoGet();
		try {
			infoget.photoInfoPipeline(infoget.PHOTO_ID);
		} catch (IOException | ParseException e) {
			e.printStackTrace();
		}
	}
}
