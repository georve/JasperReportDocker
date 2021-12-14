package com.insurances.reports.repository;

import com.insurances.reports.domain.CrrReclamantes;
import com.insurances.reports.domain.CrrReclamantesPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrrReaclamantesRepository extends JpaRepository<CrrReclamantes, CrrReclamantesPK> {
}
