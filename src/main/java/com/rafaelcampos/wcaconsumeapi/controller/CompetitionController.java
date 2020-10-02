package com.rafaelcampos.wcaconsumeapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rafaelcampos.wcaconsumeapi.dto.CompetitionDTO;
import com.rafaelcampos.wcaconsumeapi.service.CompetitionService;

@RestController
@RequestMapping(path = "/competitions")
public class CompetitionController {

	@Autowired
	private CompetitionService competitionService;

	@GetMapping
	public ResponseEntity<List<CompetitionDTO>> findAll() {
		List<CompetitionDTO> competitions = competitionService.findAll();
		return ResponseEntity.ok(competitions);
	}

	@GetMapping("/cities/{city}")
	public ResponseEntity<List<CompetitionDTO>> findByCity(@PathVariable String city) {
		List<CompetitionDTO> competitions = competitionService.findByCity(city);

		if (!competitions.isEmpty()) {
			return ResponseEntity.ok(competitions);
		}

		return ResponseEntity.notFound().build();
	}
}
