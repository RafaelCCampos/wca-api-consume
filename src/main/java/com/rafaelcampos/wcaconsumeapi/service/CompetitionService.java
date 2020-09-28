package com.rafaelcampos.wcaconsumeapi.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rafaelcampos.wcaconsumeapi.dto.CompetitionDTO;
import com.rafaelcampos.wcaconsumeapi.repository.CompetitionRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CompetitionService {
	
	@Autowired
	private CompetitionRepository competitionRepository;

	public List<CompetitionDTO> findAll() {
		log.info("Find all competitions");
		return competitionRepository.findAll().stream().map(x -> x.convert()).collect(Collectors.toList());
	}

	public List<CompetitionDTO> findByCity(String city) {
		log.info("Find competitions by city {}",city);
		
		return competitionRepository.findByCityContaining(city).stream().map(x -> x.convert()).collect(Collectors.toList());
	}
}
