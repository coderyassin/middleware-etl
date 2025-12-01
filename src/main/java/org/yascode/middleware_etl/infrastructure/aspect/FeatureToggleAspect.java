package org.yascode.middleware_etl.infrastructure.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.togglz.core.manager.FeatureManager;
import org.yascode.middleware_etl.infrastructure.annotation.FeatureToggle;
import org.yascode.middleware_etl.infrastructure.exception.FeatureNotEnabledException;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class FeatureToggleAspect {

    private final FeatureManager featureManager;
    private final ApplicationContext applicationContext;

    public FeatureToggleAspect(FeatureManager featureManager,
                               ApplicationContext applicationContext) {
        this.featureManager = featureManager;
        this.applicationContext = applicationContext;
    }

    @Around("@annotation(org.yascode.middleware_etl.infrastructure.annotation.FeatureToggle)")
    public Object checkFeature(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        FeatureToggle annotation = method.getAnnotation(FeatureToggle.class);

        // Check if the feature is active
        if (!featureManager.isActive(annotation.value())) {
            log.warn("🚫 Feature {} is disabled for method {}",
                    annotation.value(), method.getName());

            // If a fallback bean is defined, use it
            if (annotation.fallbackBean() != void.class) {
                Object fallbackBean = applicationContext.getBean(annotation.fallbackBean());
                return method.invoke(fallbackBean, joinPoint.getArgs());
            }

            // Otherwise, throw an exception
            throw new FeatureNotEnabledException(annotation.fallbackMessage());
        }

        log.debug("✅ Feature {} is enabled for method {}",
                annotation.value(), method.getName());
        return joinPoint.proceed();
    }
}
