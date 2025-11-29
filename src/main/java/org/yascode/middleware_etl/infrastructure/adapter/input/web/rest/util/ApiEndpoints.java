package org.yascode.middleware_etl.infrastructure.adapter.input.web.rest.util;

public class ApiEndpoints {

    public static final String API_BASE = "/api";
    public static final String API_VERSION = "X-API-VERSION";
    public static final String VERSION_V1 = "1";
    public static final String VERSION_V2 = "2";
    public static final String API_VERSION_V1 = API_VERSION + "=" + VERSION_V1;
    public static final String API_VERSION_V2 = API_VERSION + "=" + VERSION_V2;

    public static class Notification {
        public static final String NOTIFICATIONS_BASE = API_BASE + "/notifications";
        public static final String NOTIFICATIONS_GET_ALL = "";
        public static final String NOTIFICATIONS_GET_BY_ID  = "/{id}";
        public static final String NOTIFICATIONS_CREATE = "";
        public static final String NOTIFICATIONS_UPDATE = "/{id}";
        public static final String NOTIFICATIONS_DELETE = "/{id}";
    }
}
