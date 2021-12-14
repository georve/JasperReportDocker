package com.insurances.reports.repository;

import com.insurances.reports.domain.CrrReclamos;
import com.insurances.reports.domain.CrrReclamosPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrrReclamosRepository extends JpaRepository<CrrReclamos, CrrReclamosPK> {
}
