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
 * Given a camera brand name fetches all models from flickr photos 
 * 
 * @author Rupak Chakraborty
 *
 */ 

public class CameraBrandModel {
	//https://api.flickr.com/services/rest/?method=flickr.cameras.getBrandModels&api_key=9625bb206d0ec7da5451697fc8937706&brand=canon&format=json&nojsoncallback=1

	String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.cameras.getBrandModels&api_key=";
	String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	String BRAND_TAG = "&brand=";
	String BRAND_NAME = "canon";
	String SUFFIX_URL = "&format=json&nojsoncallback=1";

	public String getLink() { 

		String full_url = this.BASE_URL + this.API_KEY + this.BRAND_TAG + this.BRAND_NAME + this.SUFFIX_URL;

		return full_url;
	}

	/** 
	 * Given a link to the API endpoint returns the JSON response
	 * @param link String containing the link of the endpoint
	 * @return String containing the response
	 * @throws IOException
	 */ 

	public static String getJSONResponse(String link)throws IOException { 

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

	public static JSONObject getParsedJSON(String response) throws ParseException { 

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

	public static JSONArray getJSONArray(JSONObject response,String field_name) { 

		JSONArray jsonArray; 
		jsonArray = (JSONArray) response.get(field_name);

		return jsonArray;
	} 

	/** 
	 * Checks the status of the JSONObject returned
	 * @param response_object JSONObject whose status is to be checked
	 * @return true if the status is correct false otherwise
	 */ 

	public static boolean checkStatus(JSONObject response_object) { 

		boolean status = false;
		String stat = (String) response_object.get("stat");

		if (stat.equalsIgnoreCase("OK")) { 

			status = true;
		}

		return status;
	}

	public void modelPipeline(String brand) { 

		this.BRAND_NAME = brand;
		String url = getLink(); 
		try {
			String response = getJSONResponse(url);
			JSONObject response_object = getParsedJSON(response);
			JSONObject cameras = (JSONObject) response_object.get("cameras");
			JSONArray camera = (JSONArray) cameras.get("camera");
			JSONObject temp; 

			System.out.println("Brand : " + cameras.get("brand"));

			for (int i = 0; i < camera.size(); i++) {  

				System.out.println(camera.get(i));
			}

		} catch(Exception e) {  
			
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) { 
		
		CameraBrandModel model = new CameraBrandModel();
		model.modelPipeline("canon");
	}
}
