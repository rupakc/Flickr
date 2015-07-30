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
 * TODO - Add multithreading to the fetching	
 */ 

public class PhotoPublicUser {

	public String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.people.getPublicPhotos&api_key=";
	public String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	public String USER_TAG = "&user_id=";
	public String USER_ID = "27555616@N04";
	public String PAGE_TAG = "&page=";
	public String PAGE_NUMBER = "1";
	public String PER_PAGE_TAG = "&per_page=";
	public String PER_PAGE_NUMBER = "150";
	public String SUFFIX_URL = "&format=json&nojsoncallback=1";
	public String FAVORITE_METHOD = "flickr.favorites.getPublicList";


	/** 
	 * Forms a complete URL from the given constituent parts
	 * @return String containing the full link
	 */ 

	public String getFullLink() { 

		this.USER_ID = StringUtil.replaceAtRateOf(this.USER_ID);
		String url = this.BASE_URL + this.API_KEY + this.USER_TAG + this.USER_ID + this.PAGE_TAG + this.PAGE_NUMBER 
				+ this.PER_PAGE_TAG + this.PER_PAGE_NUMBER + this.SUFFIX_URL;
		return url;
	}

	/** 
	 * Changes the method name in the url for the api calls
	 * @param method_name String containing the method name
	 * @return String containing the changed url
	 */ 

	public String changeMethod(String method_name) { 

		String old_url = getFullLink();
		String new_url = StringUtil.replaceMethodInURL(old_url, method_name);

		return new_url;
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
	 * Returns a JSONArray from the object containing a given field name
	 * @param response JSONObject containing the response
	 * @param field_name String containing the field name
	 * @return JSONArray containing the particular items
	 */ 

	public JSONArray getJSONArray(JSONObject response,String field_name) { 

		JSONArray jsonArray; 
		jsonArray = (JSONArray) response.get(field_name);

		return jsonArray;
	} 

	/** 
	 * Prints the photo object to the screen
	 * @param photo JSONObject containing the photo object
	 */ 

	public void printPhotoObject(JSONObject photo) { 

		System.out.println("---------------------------------------\n");
		System.out.println("Id : " + photo.get("id"));
		System.out.println("Owner : " + photo.get("owner"));
		System.out.println("Secret : " + photo.get("secret"));
		System.out.println("Server : " + photo.get("server"));
		System.out.println("Farm : " + photo.get("farm"));
		System.out.println("Title : " + photo.get("title"));
		System.out.println("Ispublic : " + photo.get("ispublic"));
		System.out.println("Isfamily : " + photo.get("isfamily"));
		System.out.println("Isfriend : " + photo.get("isfriend"));
		System.out.println("------------------------------------------");
	} 

	/** 
	 * Checks the status of the JSON response returned
	 * @param response_object JSONObject which is to be checked
	 * @return true if status is OK else false
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
	 * Pipeline for fetching photos corresponding to a tag
	 * @param tag String containing the tag name
	 * @param number_of_pages The number of pages to search for
	 * @param results_per_page The number of results to be displayed per page
	 */ 

	public void tagFetchPipelinePagination(String userId,int number_of_pages,int results_per_page) { 

		JSONObject json_object = null;
		String json_response; 
		JSONObject photos = null;
		JSONArray photo_array; 
		Long current_page = 0L;
		Long total_pages = 0L; 
		this.USER_ID = userId;
		this.PAGE_NUMBER = String.valueOf(number_of_pages);
		this.PER_PAGE_NUMBER = String.valueOf(results_per_page);  

		while(true) {

			String link = getFullLink(); 		

			try { 

				json_response = getJSONResponse(link);
				json_object = getParsedJSON(json_response);
				photos = (JSONObject) json_object.get("photos");
				photo_array = (JSONArray) photos.get("photo");
				JSONObject temp; 

				for (int i = 0; i < photo_array.size(); i++) { 

					temp = (JSONObject) photo_array.get(i); //TODO-Add db support here
					printPhotoObject(temp);
				} 

			} catch (IOException e) {  

				e.printStackTrace(); 

			} catch (ParseException p) { 

				p.printStackTrace();
			}

			current_page = (Long) photos.get("page");
			total_pages = (Long) photos.get("pages");

			if (current_page <= total_pages) { 

				this.PAGE_NUMBER = String.valueOf(current_page+1); 

			} else {  

				break;
			}
		}
	} 

	public static void main(String args[]) { 

		PhotoPublicUser pUser = new PhotoPublicUser();
		pUser.tagFetchPipelinePagination("27555616@N04",1,500);
	}

}
