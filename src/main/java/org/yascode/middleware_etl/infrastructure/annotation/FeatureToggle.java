package org.yascode.middleware_etl.infrastructure.annotation;

import org.yascode.middleware_etl.infrastructure.feature.ApplicationFeatures;

import java.lang.annotation.*;

/**
 * Annotation to protect a method with a feature flag
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FeatureToggle {

    ApplicationFeatures value();

    /**
     * Message if the feature is disabled
     */
    String fallbackMessage() default "Feature is not available";

    /**
     * Fallback class if the feature is disabled
     */
    Class<?> fallbackBean() default void.class;
}
