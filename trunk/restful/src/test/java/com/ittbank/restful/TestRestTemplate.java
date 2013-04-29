package com.ittbank.restful;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TestRestTemplate {
	
	@Test
	public void testGetMethod(){
		RestTemplate restTemplate = new RestTemplate();
//		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8080/restful/order/{id}", String.class,"42");
		ResponseEntity<String> entity = restTemplate.postForEntity("http://localhost:8080/restful/order/42", null,String.class);
		System.out.println(entity.getBody());
	}
	
	@Test
	public void testPostMethod(){
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> entity = template.postForEntity(
				"http://localhost:8080/restful/order", null, String.class);
		HttpHeaders headers = entity.getHeaders();
		System.out.println(headers.getLastModified());
		MediaType contentType = entity.getHeaders().getContentType();
		System.out.println("contentType:[" + contentType + "]");
		HttpStatus statusCode = entity.getStatusCode();
		System.out.println("statusCode:[" + statusCode + "]");
	}
}
