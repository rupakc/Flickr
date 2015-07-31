package org.flickr.photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * 
 * @author Rupak Chakraborty
 *
 */ 

public class CameraBrands {

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
	
	/** 
	 * Returns all the camera brands used in Flickr
	 * @return Map<String,String> containing the ids and names of the camera brands
	 */ 
	
	public static Map<String,String> getAllBrands() { 

		Map<String,String> brand_map = new HashMap<String,String>();
		String url ="https://api.flickr.com/services/rest/?method=flickr.cameras.getBrands&api_key=9625bb206d0ec7da5451697fc8937706&format=json&nojsoncallback=1";
		
		try { 
			
			String response = getJSONResponse(url);
			JSONObject parsed_object = getParsedJSON(response);

			if (checkStatus(parsed_object)) { 

				JSONObject brands = (JSONObject) parsed_object.get("brands");
				JSONArray brand = (JSONArray) brands.get("brand");
				JSONObject temp; 

				for (int i = 0; i < brand.size(); i++) { 

					temp = (JSONObject) brand.get(i);
					brand_map.put((String)temp.get("id"),(String)temp.get("name"));
				}
			} 
			
		} catch(Exception e) { 
			
			e.printStackTrace();
		}

		return brand_map;
	}
	
	public static void main(String args[]) { 
		
		System.out.println(CameraBrands.getAllBrands());
	}
}
