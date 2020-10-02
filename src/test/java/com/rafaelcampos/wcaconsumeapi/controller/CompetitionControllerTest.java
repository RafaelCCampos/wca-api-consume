package com.rafaelcampos.wcaconsumeapi.controller;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.rafaelcampos.wcaconsumeapi.dto.CompetitionDTO;
import com.rafaelcampos.wcaconsumeapi.service.CompetitionService;

import io.restassured.http.ContentType;

@WebMvcTest
public class CompetitionControllerTest {
	
	private String city = "uberlandia";
	private List<CompetitionDTO> competitions = new ArrayList<>();
	
	@Autowired
	private CompetitionController competitionController;
	
	@MockBean
	private CompetitionService competitionService;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(competitionController);
	}
	
	@Test
	public void mustReturnSuccess_WhenGetCompetition() {
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/competitions")
		.then()
			.statusCode(HttpStatus.OK.value());
	}
	
	@Test
	public void mustReturnNotFound_WhenGetCompetition() {
		
		when(competitionService.findByCity(city))
		.thenReturn(competitions);
		
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/competitions/cities/{city}", city)
		.then()
			.statusCode(HttpStatus.NOT_FOUND.value());
	}
}
