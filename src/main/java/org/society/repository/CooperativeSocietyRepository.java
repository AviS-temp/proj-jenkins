package org.society.repository;

import org.society.entities.CooperativeSociety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CooperativeSocietyRepository extends JpaRepository<CooperativeSociety,Integer> {

	CooperativeSociety findBySocietyName(String societyName);

}
