package org.yascode.middleware_etl.infrastructure.feature;

import org.togglz.core.Feature;
import org.togglz.core.annotation.Label;
import org.togglz.core.context.FeatureContext;

public enum ApplicationFeatures implements Feature {

    @Label("Get Notifications")
    GET_NOTIFICATIONS,

    @Label("Get Notification")
    GET_NOTIFICATION;

    public boolean isActive() {
        return FeatureContext.getFeatureManager().isActive(this);
    }
}
