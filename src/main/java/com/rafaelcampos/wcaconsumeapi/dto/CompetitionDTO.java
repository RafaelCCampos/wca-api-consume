package com.rafaelcampos.wcaconsumeapi.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CompetitionDTO {
	
	private String name;
	private String city;
	private String country;
	private String website;
	private LocalDate startDate;
	private String link;
}
