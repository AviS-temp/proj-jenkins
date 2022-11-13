package org.society.repository;

import org.society.entities.ElectionResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ElectionResultRepository extends JpaRepository<ElectionResult,Integer> {

	ElectionResult findBySocietyName(String societyName);

}
