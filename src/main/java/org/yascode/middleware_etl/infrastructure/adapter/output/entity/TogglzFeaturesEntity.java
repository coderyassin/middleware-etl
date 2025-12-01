package org.yascode.middleware_etl.infrastructure.adapter.output.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "TOGGLZ_FEATURES")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TogglzFeaturesEntity {

    @Id
    @Column(name = "FEATURE_NAME ")
    private String featureName;

    @Column(name = "FEATURE_ENABLED ")
    private Integer featureEnabled;

    @Column(name = "STRATEGY_ID")
    private String strategyId;

    @Column(name = "STRATEGY_PARAMS")
    private String strategyParams;
}
