package org.yascode.middleware_etl.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EnumBasedFeatureProvider;
import org.togglz.core.repository.jdbc.JDBCStateRepository;
import org.togglz.core.spi.FeatureProvider;
import org.togglz.core.user.SimpleFeatureUser;
import org.togglz.core.user.UserProvider;
import org.yascode.middleware_etl.infrastructure.feature.ApplicationFeatures;

import javax.sql.DataSource;

@Configuration
public class TogglzConfig {

    /**
     * Feature Provider based on the ApplicationFeatures enum
     */
    @Bean
    public FeatureProvider featureProvider() {
        return new EnumBasedFeatureProvider(ApplicationFeatures.class);
    }

    /**
     * User Provider - Determines who can modify the features
     * In production, use Spring Security
     */
    @Bean
    public UserProvider userProvider() {
        return () -> new SimpleFeatureUser("admin", true); // All users are admins (dev only!)
    }

    /**
     * State Repository - Database storage
     */
    @Bean
    public org.togglz.core.repository.StateRepository stateRepository(DataSource dataSource) {
        return new JDBCStateRepository(dataSource, "TOGGLZ_FEATURES");
    }
}
