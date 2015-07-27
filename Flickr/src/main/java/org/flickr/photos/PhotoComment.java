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
 * TODO - Add Multithreading and Integrate with MongoDB 
 * TODO - Status check
 */

public class PhotoComment {
	//https://api.flickr.com/services/rest/?method=flickr.photos.comments.getList&api_key=68c3c94595322226822b36ad9bafe209&photo_id=19592127128&format=json&nojsoncallback=1

	String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.comments.getList&api_key=";
	String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	String PHOTO_URL = "&photo_id=";
	String PHOTO_ID = "19592127128";
	String SUFFIX_URL = "&format=json&nojsoncallback=1";

	/** 
	 * Forms a complete URL from its constituent parts
	 * @return String containing the complete URL
	 */ 

	public String getURL() { 

		StringBuilder link = new StringBuilder(this.BASE_URL);

		link.append(this.API_KEY);
		link.append(this.PHOTO_URL);
		link.append(this.PHOTO_ID);
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
	 * 
	 * @param photoId
	 */
	
	public void photoCommentPipeline(String photoId) { 

		this.PHOTO_ID = photoId;
		String link = getURL(); 

		try { 

			String json_response = getJSONResponse(link);
			JSONObject json_object = getParsedJSON(json_response);
			JSONObject comments = (JSONObject) json_object.get("comments");
			JSONArray comments_array = (JSONArray) comments.get("comment"); 
			JSONObject temp; 

			for (int i = 0; i < comments_array.size(); i++) { 

				temp = (JSONObject) comments_array.get(i);
				printComment(temp);
			} 

		} catch(IOException e) {  

			e.printStackTrace(); 

		} catch(ParseException pe) { 

			pe.printStackTrace();
		}
	}
	
	/** 
	 * Prints out a comment to the console
	 * @param comment JSONObject containing the comment which is to be printed
	 */ 
	
	public void printComment(JSONObject comment) { 
		
		System.out.println("--------------------------------------------\n");
		System.out.println("Id : " + comment.get("id"));
		System.out.println("Author : " + comment.get("author"));
		System.out.println("Path Alias : " + comment.get("path_alias"));
		System.out.println("Author Name : " + comment.get("authorname"));
		System.out.println("Content : " + comment.get("_content"));
		System.out.println("Permalink : " + comment.get("permalink"));
		System.out.println("IconServer : " + comment.get("iconserver"));
		System.out.println("IconFarm : " + comment.get("iconfarm"));
		System.out.println("Real Name : " + comment.get("realname"));
		System.out.println("Date Created : " + comment.get("datecreate"));
		System.out.println("---------------------------------------------\n");
	} 
	
	/** 
	 * Main function to test the function of the class
	 * @param args
	 */ 
	
	public static void main(String args[]) { 
		
		PhotoComment comment = new PhotoComment();
		comment.photoCommentPipeline("19592127128");
	}
}
