package org.yascode.middleware_etl.infrastructure.adapter.output.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yascode.middleware_etl.infrastructure.adapter.output.entity.TogglzFeaturesEntity;

public interface TogglzFeaturesEntityRepository extends JpaRepository<TogglzFeaturesEntity, String> {
}
