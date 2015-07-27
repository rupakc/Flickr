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
 * @author Rupak Chakraborty
 * TODO - Insert Search Photo entity and then Add MongoDB
 * TODO - Tag set and space in tag
 * TODO - Check Status Response before proceeding
 * TODO - Add Multithreading
 */

public class PhotoSearch {

	public String BASE_URL = "https://api.flickr.com/services/rest/?method=flickr.photos.search&api_key=";
	public String API_KEY = "9625bb206d0ec7da5451697fc8937706";
	public String TAG_URL = "&tags=";
	public String TAG = "fashion";
	public String SUFFIX_URL = "&format=json&nojsoncallback=1";
	public String PER_PAGE_URL = "&per_page=";
	public String PER_PAGE_NUMBER = "100";
	public String PAGE_NUMBER_URL = "&page=";
	public String PAGE_NUMBER = "1";
	public Set<String> tag_set = new HashSet<String>();

	/**
	 * @return the aPI_KEY
	 */
	public String getAPI_KEY() {
		return API_KEY;
	}

	/**
	 * @param aPI_KEY the aPI_KEY to set
	 */
	public void setAPI_KEY(String aPI_KEY) {
		API_KEY = aPI_KEY;
	}

	/**
	 * @return the tAG
	 */
	public String getTAG() {
		return TAG;
	}

	/**
	 * @param tAG the tAG to set
	 */
	public void setTAG(String tAG) {
		TAG = tAG;
	}

	/**
	 * @return the pER_PAGE_NUMBER
	 */
	public String getPER_PAGE_NUMBER() {
		return PER_PAGE_NUMBER;
	}

	/**
	 * @param pER_PAGE_NUMBER the pER_PAGE_NUMBER to set
	 */
	public void setPER_PAGE_NUMBER(String pER_PAGE_NUMBER) {
		PER_PAGE_NUMBER = pER_PAGE_NUMBER;
	}

	/**
	 * @return the pAGE_NUMBER
	 */
	public String getPAGE_NUMBER() {
		return PAGE_NUMBER;
	}

	/**
	 * @param pAGE_NUMBER the pAGE_NUMBER to set
	 */
	public void setPAGE_NUMBER(String pAGE_NUMBER) {
		PAGE_NUMBER = pAGE_NUMBER;
	}

	/**
	 * @return the tag_set
	 */
	public Set<String> getTag_set() {
		return tag_set;
	}

	/**
	 * @param tag_set the tag_set to set
	 */
	public void setTag_set(Set<String> tag_set) {
		this.tag_set = tag_set;
	}

	public String getLink() { 

		StringBuilder full_url = new StringBuilder(this.BASE_URL);

		full_url.append(this.API_KEY);
		full_url.append(this.TAG_URL);
		full_url.append(this.TAG);
		full_url.append(this.PER_PAGE_URL);
		full_url.append(this.PER_PAGE_NUMBER);
		full_url.append(this.PAGE_NUMBER_URL);
		full_url.append(this.PAGE_NUMBER);
		full_url.append(this.SUFFIX_URL);

		return full_url.toString();
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
	 * 
	 * @param response
	 * @param field_name
	 * @return
	 */ 

	public JSONArray getJSONArray(JSONObject response,String field_name) { 

		JSONArray jsonArray; 
		jsonArray = (JSONArray) response.get(field_name);

		return jsonArray;
	} 

	/** 
	 * 
	 * @param photo
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
	 * 
	 * @param response_object
	 * @return
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
	 * @param tag
	 */ 

	public void tagFetchPipelineSansPagination(String tag) { 

		this.TAG = tag;
		String link = getLink(); 

		try { 

			String json_response = getJSONResponse(link);
			JSONObject json_object = getParsedJSON(json_response);
			JSONObject photos = (JSONObject) json_object.get("photos");
			JSONArray photo_array = (JSONArray) photos.get("photo");
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
	} 

	public void tagFetchPipelinePagination(String tag,int number_of_pages,int results_per_page) { 
		
		JSONObject json_object = null;
		String json_response; 
		JSONObject photos = null;
		JSONArray photo_array; 
		Long current_page = 0L;
		Long total_pages = 0L; 
		this.TAG = tag;
		this.PAGE_NUMBER = String.valueOf(number_of_pages);
		this.PER_PAGE_NUMBER = String.valueOf(results_per_page);  
		
		while(true) {
			
			String link = getLink(); 
			
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

	public static void main(String args[]) throws IOException, ParseException {  

		PhotoSearch photo = new PhotoSearch();
		System.out.println(photo.getJSONResponse(photo.getLink()));
		JSONObject response = photo.getParsedJSON(photo.getJSONResponse(photo.getLink()));
		JSONObject photos = (JSONObject) response.get("photos");
		JSONArray array_photo = (JSONArray) photos.get("photo");
		photo.printPhotoObject((JSONObject) array_photo.get(10));
		photo.tagFetchPipelinePagination("fashion", 5, 10);
	}
}
