package com.novabite.backend.repository;

import com.novabite.backend.domain.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, String> {
}
