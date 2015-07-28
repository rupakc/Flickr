package org.flickr.photos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/** 
 * 
 * @author Rupak Chakraborty
 * 
 * TODO - Add Multithreading 
 */  

public class RelatedTags {

	public String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.tags.getRelated&api_key=";
	public String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	public String TAG_URL = "&tag=";
	public String TAG = "fashion";
	public String SUFFIX_URL = "&format=json&nojsoncallback=1";

	public String getLink() { 

		StringBuilder link = new StringBuilder(this.BASE_URL); 

		link.append(this.API_KEY);
		link.append(this.TAG_URL);
		link.append(this.TAG);
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
	 * For a given tag name returns a set of related tags
	 * @param tag_name String containing the tag name
	 * @return Set<String> containing the related tags to be returned
	 */ 

	public Set<String> getRelatedTagSet(String tag_name) { 

		Set<String> tag_set = new HashSet<String>();
		this.TAG = tag_name;
		String link = getLink();

		try { 

			String json_response = getJSONResponse(link);
			JSONObject json_object = getParsedJSON(json_response);  
			
			if (checkStatus(json_object)) { 
				
				JSONObject tags = (JSONObject) json_object.get("tags");
				JSONArray tag = getJSONArray(tags, "tag");
				JSONObject temp; 
				String content = ""; 

				for (int i = 0; i < tag.size(); i++) { 

					temp = (JSONObject) tag.get(i);
					content = (String) temp.get("_content");
					tag_set.add(content);
				} 
			}

		} catch(IOException e) { 

			e.printStackTrace(); 

		} catch(ParseException pe) { 

			pe.printStackTrace();
		}

		return tag_set;
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

		RelatedTags related = new RelatedTags();
		System.out.println(related.getRelatedTagSet("fashion"));
	}
}

