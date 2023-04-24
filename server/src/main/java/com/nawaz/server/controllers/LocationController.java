package com.nawaz.server.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@CrossOrigin
@RestController
@RequestMapping("/locations")
public class LocationController {
	public static final String GET_LOCATIONS_URL = "https://api.stb.gov.sg/content/attractions/v2/search";
	public static final String GET_LOCATION_DETAILS_URL = "https://api.stb.gov.sg/content/attractions/v2/search";
//			+ "searchType=uuids&searchValues=002f7ff7096635b4a698fead4a60518ad23";
	
	@Value("${API_KEY}")
    private String key;

	@GetMapping("/{keyword}")
	public ResponseEntity<String> getAllLocaionsByKeyword(@PathVariable String keyword) {		        
        String url = UriComponentsBuilder.fromUriString(GET_LOCATIONS_URL)
        .queryParam("searchType", "keyword")
        .queryParam("searchValues", keyword)
        .queryParam("language", "en")
        .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", key);        
        HttpEntity<String> entity = new HttpEntity<>("{}", headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(url, HttpMethod.GET, entity, String.class);
    
        ResponseEntity<String> response = new ResponseEntity<String>(resp.getBody(),resp.getStatusCode());
        
        return response;
	}
	
	@GetMapping("/details/{uuid}")
	public ResponseEntity<String> getLocaionDetailssByUUID(@PathVariable String uuid) {		        
        String url = UriComponentsBuilder.fromUriString(GET_LOCATION_DETAILS_URL)
        .queryParam("searchType", "uuids")
        .queryParam("searchValues", uuid)
        .queryParam("language", "en")
        .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-API-KEY", key);        
        HttpEntity<String> entity = new HttpEntity<>("{}", headers);

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = template.exchange(url, HttpMethod.GET, entity, String.class);
        
        ResponseEntity<String> response = new ResponseEntity<String>(resp.getBody(),resp.getStatusCode());

        return response;
	}


//	@GetMapping("/{keyword}")
//	public ResponseEntity<Location> getAllLocaionsByKeyword(@PathVariable String keyword) {		
//		Location res = locationServiceImpl.get(id);
//		System.out.println("res : "+res);
//		
//		ResponseEntity<Location> responseEntity = new ResponseEntity<>(res, HttpStatus.ACCEPTED);
//		
//		return responseEntity;
//	}
 
}
