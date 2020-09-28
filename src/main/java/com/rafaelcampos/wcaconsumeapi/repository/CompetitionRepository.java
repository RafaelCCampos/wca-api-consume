package com.rafaelcampos.wcaconsumeapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rafaelcampos.wcaconsumeapi.model.Competition;

@Repository
public interface CompetitionRepository extends JpaRepository<Competition, String> {

	public List<Competition> findByCityContaining(String city);
}
