package com.insurances.reports.repository;

import com.insurances.reports.domain.Aseguradora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AseguradoraRepository extends JpaRepository<Aseguradora,Integer> {
}
