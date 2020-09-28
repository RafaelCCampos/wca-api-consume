package com.rafaelcampos.wcaconsumeapi.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.rafaelcampos.wcaconsumeapi.model.Competition;

@Configuration
public class CompetitionApi {
	
	@Bean
	public void getPersons() {
	RestTemplate restTemplate = new RestTemplate();
	
	//https://www.worldcubeassociation.org/api/v0/competitions/uberlandiaopen2018
	
	UriComponents uri = UriComponentsBuilder.newInstance()
			.scheme("https")
			.host("www.worldcubeassociation.org")
			.path("api/v0/competitions/uberlandiaopen2018")
			.build();
	
	ResponseEntity<Competition> entity = restTemplate.getForEntity(uri.toUriString(), Competition.class);
	
	System.out.println(entity.getBody().getName());
	
	}
	
}			
