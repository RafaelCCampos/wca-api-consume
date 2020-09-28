package com.rafaelcampos.wcaconsumeapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.rafaelcampos.wcaconsumeapi.dto.CompetitionDTO;

import lombok.Data;

@Data
@Entity
@Table(name = "competitions")
public class Competition {

	@Id
	private String id;
	private String name;

	@Column(name = "cityname")
	private String city;

	@Column(name = "countryid")
	private String country;

	@Column(name = "external_website")
	private String website;

	private LocalDate startDate;

	public CompetitionDTO convert() {
		CompetitionDTO competitionDTO = new CompetitionDTO();

		competitionDTO.setName(name);
		competitionDTO.setCity(city);
		competitionDTO.setCountry(country);
		competitionDTO.setWebsite(website);
		competitionDTO.setLink(String.format("https://www.worldcubeassociation.org/competitions/%s", id));
	
		return competitionDTO;
	}

}
