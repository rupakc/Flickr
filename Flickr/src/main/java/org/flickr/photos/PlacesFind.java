package org.flickr.photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.flickr.util.StringUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * 
 * @author Rupak Chakraborty
 *
 */  

public class PlacesFind {

	public String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.places.find&api_key=";
	public String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	public String QUERY_URL = "&query=";
	public String QUERY = "india";
	public String SUFFIX_URL = "&format=json&nojsoncallback=1";

	/** 
	 * Forms a complete URL from the constituent parts
	 * @return String containing the full url
	 */

	public String getFullLink() { 

		StringBuilder link = new StringBuilder(this.BASE_URL);

		link.append(this.API_KEY);
		link.append(this.QUERY_URL);
		link.append(this.QUERY);
		link.append(this.SUFFIX_URL);

		return link.toString();
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
	 * Defines the pipeline for fetching places pertaining to a given query
	 * @param query String containing the query for which the places are fetched 
	 */ 
	
	public void placeFindPipeline(String query) { 

		this.QUERY = StringUtil.fillTagSpace(query);
		String link = getFullLink();

		try { 

			String json_response = getJSONResponse(link);
			JSONObject json_object = getParsedJSON(json_response);

			if (checkStatus(json_object)) { 

				JSONObject places = (JSONObject) json_object.get("places");
				JSONArray place_array = (JSONArray) places.get("place");
				JSONObject temp;  

				for (int i = 0; i < place_array.size(); i++) { 

					temp = (JSONObject) place_array.get(i);
					System.out.println(temp);
					printPlace(temp);
				}
			} 
			
		} catch(IOException e) {  

			e.printStackTrace(); 

		} catch(ParseException pe) { 

			pe.printStackTrace();
		}
	} 
	
	/** 
	 * Prints the place response to the console in a pretty fashion
	 * @param place_response JSONObject containing the response
	 */ 
	
	public void printPlace(JSONObject place_response) { 
		
		System.out.println("-------------------------------------------\n");
		System.out.println("Place Id : " + place_response.get("place_id"));
		System.out.println("Woe Name : " + place_response.get("woe_name"));
		System.out.println("Woe Id : " + place_response.get("woe_id"));
		System.out.println("Content : " + place_response.get("_content"));
		System.out.println("Latitude : " + place_response.get("latitude"));
		System.out.println("Longitude : " + place_response.get("longitude"));
		System.out.println("Timezone : " + place_response.get("timezone"));
		System.out.println("Place Url : " + place_response.get("place_url"));
		System.out.println("Place Type : " + place_response.get("place_type"));
		System.out.println("Place Type Id : " + place_response.get("place_type_id"));
		System.out.println("-------------------------------------------------\n");
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

	public static void main(String args[]) throws IOException { 

		PlacesFind find = new PlacesFind();
		System.out.println(find.getJSONResponse(find.getFullLink()));
		find.placeFindPipeline("San Francisco");
	}
}
